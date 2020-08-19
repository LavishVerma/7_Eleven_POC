package com.example.Login_Register.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Login_Register.entity.RegisterEntity;
import com.example.Login_Register.repository.Login_Register_Repository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired 
	Login_Register_Repository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		RegisterEntity user= repository.findByPhonenumber(username);
		return new User(user.getPhonenumber(),user.getPassword(),new ArrayList<>());
	}
	
	@HystrixCommand(fallbackMethod = "saveUserdefaultAction")
	public String saveUser(RegisterEntity data) {	 	
	repository.save(data);
	return "Successfull";
	}
	
	public String saveUserdefaultAction(RegisterEntity d)
	{
		return "Something Went Wrong. Check what you have done wrong.";
	}

}
