package com.example.doctor.doctordetails.repositoty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.doctor.doctordetails.model.Patient;



@Repository
public interface PaitientRepository extends JpaRepository<Patient, Integer>  {
	
	@Query("SELECT u FROM Patient u WHERE u.email= ?1" )
	
	Optional<Patient> findByname(String email);

}
