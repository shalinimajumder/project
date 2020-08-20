package com.example.doctor.doctordetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.doctordetails.model.Patient;
import com.example.doctor.doctordetails.repositoty.PaitientRepository;


@Service
public class PatientServiceImpl implements PateintService {
	
	@Autowired
	public PaitientRepository paitientRepository; 
	
	

	public PatientServiceImpl(PaitientRepository paitientRepository) {
		
		this.paitientRepository = paitientRepository;
	}



	@Override
	public List<Patient> findAllPatient() {
		
		List<Patient> patient = paitientRepository.findAll();
		return patient;
	}



	@Override
	public Optional<Patient> findByid(Integer id) {
		Optional<Patient> patient = paitientRepository.findById(id);
		return patient;
	}

}
