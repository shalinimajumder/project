package com.example.doctor.doctordetails.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto<T> {
	
	private T data;
	private HttpStatus status;
	
	
	public ResponseDto(T data, HttpStatus status) {
		super();
		this.data = data;
		this.status = status;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}
