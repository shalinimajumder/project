package com.example.doctor.doctordetails.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctor.doctordetails.exception.RoleException;
import com.example.doctor.doctordetails.model.Anthentication;
import com.example.doctor.doctordetails.repositoty.RoleRepository;
import com.example.doctor.doctordetails.service.RoleService;



@RestController
public class AuthController {
	
	@Autowired
	public RoleService roleService;
	
	@Autowired
	public RoleRepository RoleRepository;
	
	

	public AuthController(RoleService roleService,
			com.example.doctor.doctordetails.repositoty.RoleRepository roleRepository) {
		
		this.roleService = roleService;
		RoleRepository = roleRepository;
	}
	
	@PostMapping("/saveRole")
	public String Register(@Valid @RequestBody Anthentication anthentication)
	{
		if(anthentication.getRoles().equals("ROLE_ADMIN")||anthentication.getRoles().equals("ROLE_USER"))
		{
			Anthentication Auth= roleService.saveRole(anthentication);
			
			return "saved";
		}
		else
		{
			throw new RoleException("Role Must be ROLE_ADMIN or ROLE_USER");
		}
		
		
	}
	
	
	

}
