package com.example.doctor.doctordetails.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor.doctordetails.model.LoginDetails;
import com.example.doctor.doctordetails.model.Patient;
import com.example.doctor.doctordetails.repositoty.PaitientRepository;
import com.example.doctor.doctordetails.service.PateintService;




@RestController
public class PatientController {
	
	@Autowired
	public PateintService pateintService;
	
	@Autowired
	public PaitientRepository paitientRepository;
	
	@Autowired
	public AuthenticationManager authenticationManager;

	
	
	
	public PatientController() {
		
	}



	public PatientController(PateintService pateintService, PaitientRepository paitientRepository,
			AuthenticationManager authenticationManager) {
		this.pateintService = pateintService;
		this.paitientRepository = paitientRepository;
		this.authenticationManager = authenticationManager;
	}



	@GetMapping("/allPatientDetails")
	public List<Patient> allPatient()
	{
		List<Patient> patient = pateintService.findAllPatient();
		return patient;
		
	}


	 @PostMapping("/mydetails")
	    public Optional<Patient> patient(@Valid @RequestBody LoginDetails loginDetails){
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDetails.getUsername(), loginDetails.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			Optional<Patient>emp= paitientRepository.findByname(loginDetails.getUsername());
			emp.orElseThrow (() -> new RuntimeException("This patient is not found"));
			return emp;
	    }
	 
	 @PostMapping("/patient1")
	    public String patient1(@Valid @RequestBody LoginDetails loginDetails){
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDetails.getUsername(), loginDetails.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return "hey";
	 }
	 
	 @GetMapping("/patient/{pid}")
	 public Optional<Patient> FindPatientById(@PathVariable("pid") Integer id)
	 {
		 
		 Optional<Patient> patient= paitientRepository.findById(id);
		 patient.orElseThrow(() -> new RuntimeException("Patient of this id:"+id+" is not present in database" ));
			
			return patient;
		 
	 }
}



