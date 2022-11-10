package com.aks.service;

import com.aks.model.UserDtls;

public interface UserService {
	
	public UserDtls createUser(UserDtls user);
	
	public boolean checkEmail(String email);
	
	public boolean checkPassword(String password);

}
