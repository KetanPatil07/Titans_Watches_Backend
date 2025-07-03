package com.titan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.titan.entity.User;

@Service
public interface UserServices {

	User createUser(User user);
	
	List<User>getallUsers();
	
	Optional<User>findById(Long id);
	
	void deleteById(Long id);
	
	void deleteAll();
	
}
