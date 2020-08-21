package com.registration.dto;

/**
* author Venkateswarlu Bikki
*/

public class UserDto {
	//private Integer id;
	private String name;
	public String toString() {
		return "UserDto [name=" + name + ", userType=" + userType + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", getName()=" + getName() + ", getuserType()=" + getuserType()
				+ ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + ", getAddress()=" + getAddress()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getuserType() {
		return userType;
	}
	public void setuserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	private String userType;
	private String password;
	
	private String email;
	private String address;

}
