package com.challange.phoneNumber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challange.phoneNumber.entity.PhoneNumber;

public interface PhoneRepository extends JpaRepository<PhoneNumber, Long>{

	List<PhoneNumber> findByCustomerId(Long id);

	PhoneNumber findByPhoneNumber(String phoneNumber);
	
}
