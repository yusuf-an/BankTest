package com.challange.phoneNumber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challange.phoneNumber.entity.PhoneNumber;
import com.challange.phoneNumber.repository.PhoneRepository;

@RestController
public class PhoneNumberController {

	@Autowired
	PhoneRepository phoneRepo;

	@GetMapping("/phone-numbers")
	public List<PhoneNumber> getPhoneNumber() {
		return phoneRepo.findAll();
	}

	@GetMapping("/phone-numbers/{userId}")
	public List<PhoneNumber> getPhoneNumber(@PathVariable Long userId) {
		return phoneRepo.findByCustomerId(userId);
	}

	@PostMapping("/activate/{phoneNumber}")
	public PhoneNumber getPhoneNumber(@PathVariable String phoneNumber) {
		PhoneNumber phone = phoneRepo.findByPhoneNumber(phoneNumber);
		phone.setActive(true);
		return phoneRepo.save(phone);
	}

}