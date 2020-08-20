package com.example.doctor.doctordetails.service;

import java.util.List;

import com.example.doctor.doctordetails.dto.OrderResponse;


public interface ServiceInterface {
	
	public List<OrderResponse> getAllpaitient(String doctorName);

}
