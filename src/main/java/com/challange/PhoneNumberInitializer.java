package com.challange;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challange.phoneNumber.entity.Customer;
import com.challange.phoneNumber.entity.PhoneNumber;
import com.challange.phoneNumber.repository.CustomerRepository;
import com.challange.phoneNumber.repository.PhoneRepository;

@Component
public class PhoneNumberInitializer {

	@Autowired
	PhoneRepository phoneRepo;

	@Autowired
	CustomerRepository customerRepo;

	@PostConstruct
	public void initialize() {

		List<Customer> lc = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setName("Yusuf" + i);
			lc.add(customerRepo.save(customer));
		}

		for (Customer c : lc) {
			for (int i = 0; i < 10; i++) {
				PhoneNumber pn = new PhoneNumber(c, generateRandomNumber(), false);
				phoneRepo.save(pn);
			}
		}

	}

	String generateRandomNumber() {
		Random rand = new Random();
		int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
		int num2 = rand.nextInt(743);
		int num3 = rand.nextInt(10000);

		DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
		DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

		return df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
	}
}
