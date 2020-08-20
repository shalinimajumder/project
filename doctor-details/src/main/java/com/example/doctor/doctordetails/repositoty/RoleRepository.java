package com.example.doctor.doctordetails.repositoty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doctor.doctordetails.model.Anthentication;

@Repository
public interface RoleRepository  extends JpaRepository<Anthentication, Integer>{
	
	Optional<Anthentication> findByEmail(String email);

}
