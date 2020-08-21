package com.registration.repository;

import org.springframework.data.repository.CrudRepository;

import com.registration.entity.Customer;


public interface CustomerDao extends CrudRepository<Customer, Integer> {

}
