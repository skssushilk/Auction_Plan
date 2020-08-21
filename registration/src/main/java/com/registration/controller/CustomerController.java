package com.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.registration.entity.Customer;
import com.registration.repository.CustomerDao;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDao custDao;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCustomer(@RequestBody Customer customer) {
		Customer cust = custDao.save(customer);
		return "Customer added using custNo = " + cust.getCustNo();
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateCustomer(@RequestBody Customer customer) {
		if (custDao.findById(customer.getCustNo()).isPresent()) {
			Customer cust = new Customer(customer.getCustNo(), customer.getName(), customer.getEmail(),
					customer.getAddress(), customer.getPassword());

			Customer custNew = custDao.save(cust);
			return "Customer data updated using custNo = " + custNew.getCustNo();
		} else
			return "custNo = " + customer.getCustNo() + " is not available.";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Customer> findAllCustomer() {
		List<Customer> e = (List<Customer>) custDao.findAll();
		return e;
	}

	@RequestMapping(value = "/find/{custNo}", method = RequestMethod.GET)
	public Customer findCustomerByCustNo(@PathVariable("custNo") int custNo) {
		if (custDao.findById(custNo).isPresent()) {
			return custDao.findById(custNo).get();
		} else
			return new Customer();

	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public String deleteCustomerByCustNo() {
		custDao.deleteAll();
		return "All Customer Data deleted";
	}

	@RequestMapping(value = "/delete/{custNo}", method = RequestMethod.DELETE)
	public String deleteCustomerByCustNo(@PathVariable("custNo") int custNo) {
		if (custDao.findById(custNo).isPresent()) {
			custDao.deleteById(custNo);
			return "Customer having custNo = " + custNo + " is deleted";
		} else
			return "custNo = " + custNo + " is not available";
	}

}
