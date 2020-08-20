package com.example.doctor.doctordetails.exception;

import java.util.Date;

public class CustomErrorDetails {
	
	private Date timestamp;
	private String massage;
	private String errordetails;
	
	
	public CustomErrorDetails(Date timestamp, String massage, String errordetails) {
		this.timestamp = timestamp;
		this.massage = massage;
		this.errordetails = errordetails;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public String getMassage() {
		return massage;
	}


	public void setMassage(String massage) {
		this.massage = massage;
	}


	public String getErrordetails() {
		return errordetails;
	}


	public void setErrordetails(String errordetails) {
		this.errordetails = errordetails;
	}
	
	
	

}
