/**
 * 
 */
package com.uxpsystems.assignment.representation;

/**
 * @author Abhishek
 *
 */
public class JsonErrorResponse extends JsonResponse{
	
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
	public JsonErrorResponse(String errorMessage, String remediation) {
		super();
		this.errorMessage = errorMessage;
		this.remediation = remediation;
	}
	
	

}
