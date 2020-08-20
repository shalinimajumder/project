package com.example.doctor.doctordetails.dto;

import java.util.List;


public class OrderResponse {
	
	private String pateintname;
	
	public OrderResponse() {
		
	}

	public OrderResponse(String pateintname) {
		super();
		this.pateintname = pateintname;
	}


	public String getPateintname() {
		return pateintname;
	}

	public void setPateintname(String pateintname) {
		this.pateintname = pateintname;
	}

	
	
	

}
