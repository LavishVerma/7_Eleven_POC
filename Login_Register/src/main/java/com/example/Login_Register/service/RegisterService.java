package com.example.Login_Register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Login_Register.entity.RegisterEntity;
import com.example.Login_Register.repository.Login_Register_Repository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RegisterService {
	
	@Autowired
    Login_Register_Repository repository;
	
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
