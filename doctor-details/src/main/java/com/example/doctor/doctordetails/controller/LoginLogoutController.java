package com.example.doctor.doctordetails.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLogoutController {
	
	@GetMapping("/doctor")
	public String home()
	{
		return "welcome doctor";
		
	}

}
