package com.uxpsystems.assignment.representation;

public enum StatusEnum {
 ACTIVATED("Activated"), DEACTIVATED("Deactivated");
	String status;
	StatusEnum(String status){
		this.status = status;
	}
 public String getStatus() {
	 return this.status;
 }
}
