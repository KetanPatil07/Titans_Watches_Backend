package com.titan.serviceipl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titan.entity.User;
import com.titan.repo.UserRepo;
import com.titan.service.UserServices;

@Service
public class Userserviceimpl implements UserServices{
	
	@Autowired
	public UserRepo userrepo;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);
	}

	@Override
	public List<User> getallUsers() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		userrepo.deleteAll();
	}

}
