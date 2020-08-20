package com.example.doctor.doctordetails.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor.doctordetails.dto.DoctorRequest;
import com.example.doctor.doctordetails.dto.OrderResponse;
import com.example.doctor.doctordetails.model.Doctor;
import com.example.doctor.doctordetails.model.MyDoctorDetails;
import com.example.doctor.doctordetails.repositoty.DoctorRepoisitory;
import com.example.doctor.doctordetails.repositoty.PaitientRepository;
import com.example.doctor.doctordetails.service.ServiceInterface;




@RestController
public class DoctorController {
	
	@Autowired
	private DoctorRepoisitory doctorRepoisitory;
	
	@Autowired
	private PaitientRepository paitientRepository;
	
	@Autowired
	private ServiceInterface serviceInterface;
	
	

	
	
	public DoctorController(DoctorRepoisitory doctorRepoisitory, PaitientRepository paitientRepository,
			ServiceInterface serviceInterface) {
		super();
		this.doctorRepoisitory = doctorRepoisitory;
		this.paitientRepository = paitientRepository;
		this.serviceInterface = serviceInterface;
	}

	@PostMapping("/savePatient")
	public String SaveDoctor(@RequestBody DoctorRequest doctorRequest) 
	{
		doctorRepoisitory.save(doctorRequest.getDoctor());
		return "saved";
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/patientdetails")
	public List<Doctor> Alldoctors()
	{
		return doctorRepoisitory.findAll();
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/join")  
	 public List<OrderResponse> getinfo(@SuppressWarnings("deprecation") @AuthenticationPrincipal MyDoctorDetails myDoctorDetails)
	 {
//		Optional<Doctor> doctor = doctorRepoisitory.findByEmail(user.getEmail());
//		if(doctor.isEmpty())
//		{
//			throw new RequestParamNotAvailable("Doctor Name Not Available");
//		}
//		
//		else
//		{
//		return serviceInterface.getAllpaitient(user.getEmail());
//		}
		 
		
		return serviceInterface.getAllpaitient(myDoctorDetails.getUsername());
		
	 }
	 
}
