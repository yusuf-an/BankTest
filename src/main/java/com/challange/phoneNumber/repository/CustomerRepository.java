package com.challange.phoneNumber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challange.phoneNumber.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
