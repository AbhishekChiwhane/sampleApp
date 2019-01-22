/**
 * 
 */
package com.uxpsystems.assignment.exception;

/**
 * @author Abhishek
 *
 */
public class UserException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6804033300966709779L;
	private String errorMessage;
	private String remediation;
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the remediation
	 */
	public String getRemediation() {
		return remediation;
	}
	/**
	 * @param remediation the remediation to set
	 */
	public void setRemediation(String remediation) {
		this.remediation = remediation;
	}
	public UserException(String errorMessage, String remediation) {
		super();
		this.errorMessage = errorMessage;
		this.remediation = remediation;
	}
	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public UserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public UserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
