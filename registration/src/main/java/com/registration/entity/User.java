package com.registration.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* author Venkateswarlu Bikki
*/

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	
		
		/**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		@ Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String name;
		//s@Enumerated(EnumType.ORDINAL)
		private String userType;
		private String password;
		
		private String email;
		private String address;
		@Override
		public String toString() {
			return "User [name=" + name + ", userType=" + userType + ", password=" + password + ", email=" + email
					+ ", address=" + address + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

	/*
	 * public UserType getuserType() { return userType; }
	 */
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
		
		
		

}
