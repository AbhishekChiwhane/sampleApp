/**
 * 
 */
package com.uxpsystems.assignment.representation;

import java.io.Serializable;

/**
 * @author Abhishek
 *
 */
public class User extends JsonResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5772770524838659504L;

	private long id;
	private String username;
	private char[] password;
	//private StatusEnum userStatus;
	private String userStatus;
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public User(long id, String username, char[] password, StatusEnum userStatus)
	 * { super(); this.id = id; this.username = username; this.password = password;
	 * this.userStatus = userStatus; }
	 */
	
	public User(long id, String username, char[] password, String userStatus) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userStatus = userStatus;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(char[] password) {
		this.password = password;
	}

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
