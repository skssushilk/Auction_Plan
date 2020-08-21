package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.customer.dao.CustomerDao;
import com.customer.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao custDao;

	public String addCustomer(@RequestBody Customer customer) {
		Customer cust = custDao.save(customer);
		return "Customer added using custNo = " + cust.getCustNo();
	}

	public String updateCustomer(@RequestBody Customer customer) {
		if (custDao.findById(customer.getCustNo()).isPresent()) {
			Customer cust = new Customer(customer.getCustNo(), customer.getName(), customer.getEmail(),
					customer.getAddress(), customer.getPassword());

			Customer custNew = custDao.save(cust);
			return "Customer data updated using custNo = " + custNew.getCustNo();
		} else
			return "custNo = " + customer.getCustNo() + " is not available.";
	}

	public List<Customer> findAllCustomer() {
		List<Customer> e = (List<Customer>) custDao.findAll();
		return e;
	}

	public Customer findCustomerByCustNo(@PathVariable("custNo") int custNo) {
		if (custDao.findById(custNo).isPresent()) {
			return custDao.findById(custNo).get();
		} else
			return new Customer();

	}

	public String deleteAllCustomer() {
		custDao.deleteAll();
		return "All Customer Data deleted";
	}

	public String deleteCustomerByCustNo(@PathVariable("custNo") int custNo) {
		if (custDao.findById(custNo).isPresent()) {
			custDao.deleteById(custNo);
			return "Customer having custNo = " + custNo + " is deleted";
		} else
			return "custNo = " + custNo + " is not available";
	}

}
