package com.customer.dao;

import org.springframework.data.repository.CrudRepository;

import com.customer.entity.Customer;


public interface CustomerDao extends CrudRepository<Customer, Integer> {

}
