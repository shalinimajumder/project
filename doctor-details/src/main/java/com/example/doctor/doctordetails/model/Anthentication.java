package com.example.doctor.doctordetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="rolesDetails")
public class Anthentication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer role_id;
	@Column
	private String email;
	
	@NotEmpty(message= "validation.password.notBlank")
	@Column
	private String password;
	
	@NotBlank(message="validation.role.notBlank")
	@Column
	private String roles;

	public Anthentication() {
		
	}

	public Anthentication(String email, @NotEmpty(message = "password not blank") String password,
			@NotBlank(message = "Role not blank") String roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	
	

	
}

	
	
	
	
	


