package com.uxpsystems.assignment.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uxpsystems.assignment.entity.UserEntity;
import com.uxpsystems.assignment.exception.UserException;
import com.uxpsystems.assignment.representation.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<UserEntity> getAllUsers() {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
		Root<UserEntity> queryRoot = criteria.from(UserEntity.class);
		criteria.select(queryRoot);
		List<UserEntity> entities = session.createQuery(criteria).getResultList();
		return entities;
	}

	@Override
	public UserEntity getUserById(long id) throws UserException {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
		Root<UserEntity> queryRoot = criteria.from(UserEntity.class);
		criteria.select(queryRoot);
		criteria.where(builder.equal(queryRoot.get("id"), id));
		UserEntity entity = null;
		try {
			entity = session.createQuery(criteria).getSingleResult();
		} catch (Exception e) {
			throw new UserException("No user found for id: " + id, "Please provide valid user");
		}
		return entity;

	}

	@Override
	public long createUser(User user) throws UserException {
		UserEntity entity = new UserEntity();
		entity.setName(user.getUsername());
		entity.setPassword(user.getPassword().toString());
		entity.setStatus(user.getUserStatus());
		Transaction transaction = null;
		Long id = null;
		try {
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			transaction = session.beginTransaction();
			id = (Long) session.save(entity);
			transaction.commit();
		} catch (HibernateException e) {
			if (null != transaction)
				transaction.rollback();
		}

		return id.longValue();
	}

	@Override
	public void updateUser(User user) throws UserException {
		UserEntity entity = new UserEntity();
		entity.setId(user.getId());
		entity.setName(user.getUsername());
		entity.setPassword(user.getPassword().toString());
		entity.setStatus(user.getUserStatus());
		Transaction transaction = null;
		try {
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(entity);
			transaction.commit();
		} catch (HibernateException e) {
			if (null != transaction)
				transaction.rollback();
		}

	}

	@Override
	public void deleteUser(long id) throws UserException {
		Transaction transaction = null;
		try {
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			transaction = session.beginTransaction();
			UserEntity entity = getUserById(id);
			session.delete(entity);
			transaction.commit();

		} catch (HibernateException e) {
			if (null != transaction)
				transaction.rollback();
		}

	}
	
}
