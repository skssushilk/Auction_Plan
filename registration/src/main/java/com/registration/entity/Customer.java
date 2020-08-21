package com.registration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custNo;
	private String name;
	private String email;
	private String address;
	private String password;

	public Customer(int custNo, String name, String email, String address, String password) {
		super();
		this.custNo = custNo;
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public Customer() {

	}

	public int getCustNo() {
		return custNo;
	}

	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custNo=" + custNo + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", password=" + password + "]";
	}

}
