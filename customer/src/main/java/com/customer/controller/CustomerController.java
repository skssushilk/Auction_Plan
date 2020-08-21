package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Customer> findAllCustomer() {
		return service.findAllCustomer();
	}

	@RequestMapping(value = "/find/{custNo}", method = RequestMethod.GET)
	public Customer findCustomerByCustNo(@PathVariable("custNo") int custNo) {
		return service.findCustomerByCustNo(custNo);

	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public String deleteAllCustomer() {
		return service.deleteAllCustomer();
	}

	@RequestMapping(value = "/delete/{custNo}", method = RequestMethod.DELETE)
	public String deleteCustomerByCustNo(@PathVariable("custNo") int custNo) {
		return service.deleteCustomerByCustNo(custNo);
	}

}
