package com.example.doctor.doctordetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor.doctordetails.model.Anthentication;
import com.example.doctor.doctordetails.repositoty.RoleRepository;


@Service
public class RoleServiveImpl implements RoleService {
	
	@Autowired
	public RoleRepository roleRepository;
	
	

	public RoleServiveImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}



	@Override
	public Anthentication saveRole(Anthentication auth) {
		Anthentication auth2= roleRepository.save(auth);
		return auth;
	}



	
}
