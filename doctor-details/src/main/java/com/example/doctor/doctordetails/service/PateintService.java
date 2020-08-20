package com.example.doctor.doctordetails.service;

import java.util.List;
import java.util.Optional;

import com.example.doctor.doctordetails.model.Patient;



public interface PateintService {
	
	public List<Patient> findAllPatient();
	
	public Optional<Patient> findByid(Integer id);

}
