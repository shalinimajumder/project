package com.example.doctor.doctordetails.securityService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.doctor.doctordetails.model.Anthentication;
import com.example.doctor.doctordetails.model.MyDoctorDetails;
import com.example.doctor.doctordetails.repositoty.RoleRepository;


@Service
public class CustomDoctorDetails implements UserDetailsService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		
		Optional<Anthentication> anthentication =roleRepository.findByEmail(s);
		anthentication.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));
		return anthentication.map(MyDoctorDetails::new).get();
	}
	
	

}
