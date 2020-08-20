package com.example.doctor.doctordetails.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.doctor.doctordetails.model.Doctor;


public class DoctorRequest {
	
	private Doctor doctor;

	public DoctorRequest() {
		
	}

	public DoctorRequest(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	

}
