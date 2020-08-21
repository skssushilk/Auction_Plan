package com.registration.repository;

import org.springframework.data.repository.CrudRepository;

import com.registration.entity.User;

/**
* author Venkateswarlu Bikki
*/
public interface UserRepository extends CrudRepository<User, Integer> {

}
