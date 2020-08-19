package com.example.Login_Register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Login_Register.entity.RegisterEntity;
import com.example.Login_Register.models.AuthenticationRequest;
import com.example.Login_Register.repository.Login_Register_Repository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class LoginService {
	
	@Autowired
    Login_Register_Repository repository;
	
	@HystrixCommand(fallbackMethod = "authenticateUserdefaultAction")
	public String authenticateUser(AuthenticationRequest data) {
	Long id =repository.findByPhonenumberAndPassword(data.getPhone(), data.getPassword());	
	 
	if(id!= null)
		return "Successfull";
	
	return "Authentication failed!!";
	
	}
	
  public String authenticateUserdefaultAction(AuthenticationRequest s)
	{
		return "Something Went Wrong...";
	}

}
