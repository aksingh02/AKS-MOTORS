package com.aks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aks.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
	
	public boolean existsByEmail(String email);
	public UserDtls findByEmail(String email);
	
	public boolean existsByPassword(String password);
	public UserDtls findByPassword(String password);

}
 