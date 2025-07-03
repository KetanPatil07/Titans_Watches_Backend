package com.titan.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.titan.entity.User;
import com.titan.service.UserServices;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*")
public class Usercontroller {

	@Autowired
	public UserServices userservice;
	
	@PostMapping("/Adduser")
	public User createUser(@RequestBody User user)
	{
		return userservice.createUser(user);
	}

	@GetMapping("/Getuser")
	public List<User>getallUsers()
	{
		return userservice.getallUsers();
	}
	
	@GetMapping("/{id}")
	public Optional<User>findById(@PathVariable Long id)
	{
		return userservice.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id)
	{
		userservice.deleteById(id);
	}
	
	@DeleteMapping("/deleteall")
	void deleteAll()
	{
		userservice.deleteAll();
	}
	
}
