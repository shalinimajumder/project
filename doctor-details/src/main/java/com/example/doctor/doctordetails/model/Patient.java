package com.example.doctor.doctordetails.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@Column
	@NotNull(message= "{validation.name.notBlank}")
	private String pateintname;
	@Column
	@NotNull(message= "{validation.height.notBlank}")
	private Integer height;
	@NotNull(message = "{validation.age.notNull}")
	private Integer age;
	
	@Email( message="{validation.email.format}")
	@NotNull(message= "{validation.email.notBlank}")
	@Column(unique = true)
	private String email;
	
	
	
	
	public Patient() {
		
	}




	public Patient(@NotNull(message = "{validation.name.notBlank}") String pateintname,
			@NotNull(message = "{validation.height.notBlank}") Integer height,
			@NotNull(message = "{validation.age.notNull}") Integer age,
			@Email(message = "{validation.email.format}") @NotNull(message = "{validation.email.notBlank}") String email) {
		super();
		this.pateintname = pateintname;
		this.height = height;
		this.age = age;
		this.email = email;
	}




	public Integer getPid() {
		return pid;
	}




	public void setPid(Integer pid) {
		this.pid = pid;
	}




	public String getPateintname() {
		return pateintname;
	}




	public void setPateintname(String pateintname) {
		this.pateintname = pateintname;
	}




	public Integer getHeight() {
		return height;
	}




	public void setHeight(Integer height) {
		this.height = height;
	}




	public Integer getAge() {
		return age;
	}




	public void setAge(Integer age) {
		this.age = age;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	
	
	
	
	

}
