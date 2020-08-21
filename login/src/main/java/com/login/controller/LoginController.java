package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.UserDetailDto;
import com.login.entity.User;
import com.login.repositories.UserRepository;
@RestController
public class LoginController {

	@Autowired
	UserRepository	 userRepository;
	
	
@PostMapping(value="loginuser")
public String loginUser(@RequestBody UserDetailDto  userDetailDto) {
	String message=null;
	User user1=userRepository.findByNameAndPassword(userDetailDto.getUsername() ,userDetailDto.getPassword());
	if(user1.getUserType().equalsIgnoreCase("ADMIN")){
		message="ADMIN Service is calling";
		//message=adminLogin();
	}
	else if(user1.getUserType().equalsIgnoreCase("SELLER")){
		message="SELLER Service is calling";
		//message=sellerLogin();
	}
	else if(user1.getUserType().equalsIgnoreCase("CUSTOMER")){
		message="CUSTOMER Service is calling";
		//message=customerLogin();
	}
	
		
		return message;
}

 /*public static String adminLogin() {
 
// List<ServiceInstance> s=dc.getInstances("SELLER-CUSTOMERS");
//ServiceInstance s1=s.get(0);

ServiceInstance s2=lbc.choose("SELLERS"); 
ServiceInstance s3=lbc.choose("CUSTOMERS");
 
 String url=s2.getUri().toString();
 url=url+"/allSellers"; String url1=s3.getUri().toString();
 url1=url1+"/allcustomers";
 RestTemplate client=new RestTemplate(); ResponseEntity<String> result=null;
 result=client.exchange(url,HttpMethod.GET,createHeader(),String.class);
 RestTemplate client1=new RestTemplate(); ResponseEntity<String> result1=null;
 result1=client1.exchange(url1,HttpMethod.GET,createHeader(),String.class);
 
 System.out.println(result.getBody()); return
"-----SELLERS----"+"/n"+result.getBody().toString()+"/n"+"---CUSTOMERS---"+"/n"+result1.getBody()
 .toString(); 
 } 
 public String sellerLogin() {

List<ServiceInstance> s=dc.getInstances("SELLER");
ServiceInstance s1=s.get(0);
 
ServiceInstance s2=lbc.choose("PRODUCTS");
 String url=s2.getUri().toString();
 url=url+"/allproducts";
 RestTemplate client=new RestTemplate(); 
 ResponseEntity<String> result=null;
 result=client.exchange(url,HttpMethod.GET,createHeader(),String.class);
  
 return result.getBody().toString(); 
 }
 
 public String customerLogin() {
 ServiceInstance s2=lbc.choose("PRODUSTS");
 String url=s2.getUri().toString();
 url=url+"/allSellers";
 
 RestTemplate client=new RestTemplate(); ResponseEntity<String> result=null;
 result=client.exchange(url,HttpMethod.GET,createHeader(),String.class);
 System.out.println(result.getBody()); 
 return result.getBody().toString();
 }
 
 public static HttpEntity<?> createHeader()
 {
	 HttpHeaders h=new HttpHeaders();
     h.set("Accept",MediaType.APPLICATION_JSON_VALUE);
     return new HttpEntity<>(h); 
 }
 */
}
