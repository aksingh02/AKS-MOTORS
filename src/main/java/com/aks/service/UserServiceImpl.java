package com.aks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aks.model.UserDtls;
import com.aks.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDtls createUser(UserDtls user) {
		

		return userRepo.save(user);
	}
	
	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}
	 
	
	@Override
	public boolean checkPassword(String password) {

		return userRepo.existsByPassword(password);
	}
}
