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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer did;
	@Column
	@NotNull(message= "{validation.name.notBlank}")
	private String name;
	
	@Email( message="{validation.email.format}")
	@NotNull(message= "{validation.email.notBlank}")
	@Column(unique = true)
	private String email;
	
	
	@OneToMany(targetEntity = Patient.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "Doctor_id" ,referencedColumnName = "did")
	private List<Patient> patient;
	
	public Doctor() {
		
	}

	public Doctor(@NotNull(message = "{validation.name.notBlank}") String name,
			@Email(message = "{validation.email.format}") @NotNull(message = "{validation.email.notBlank}") String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	

	

}
