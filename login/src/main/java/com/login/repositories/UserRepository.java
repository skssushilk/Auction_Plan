package com.login.repositories;

import org.springframework.data.repository.CrudRepository;

import com.login.entity.User;

/**
* author Venkateswarlu Bikki
*/
public interface UserRepository extends CrudRepository<User, Integer> {
   // User findbyNameAndPassword(String name,String password);
	User findByNameAndPassword(String username, String password);

}