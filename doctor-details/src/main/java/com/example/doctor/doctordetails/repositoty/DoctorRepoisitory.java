package com.example.doctor.doctordetails.repositoty;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.example.doctor.doctordetails.dto.OrderResponse;
import com.example.doctor.doctordetails.model.Doctor;



@Repository
public interface DoctorRepoisitory extends JpaRepository<Doctor, Integer> {
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
	/*
	 * @Query("SELECT new com.example.demo.dto.OrderResponse(d.name , p.pateintname) FROM Doctor d JOIN d.patient p"
	 * ) public List<OrderResponse> getjoinInformation();
	 */
	
	@Query("SELECT new com.example.doctor.doctordetails.dto.OrderResponse( p.pateintname) FROM Doctor d JOIN d.patient p where d.email=?1")
	public List<OrderResponse> getPaitent(String email );
	
	Optional<Doctor> findByName(String name);
	
	
	
	
}
