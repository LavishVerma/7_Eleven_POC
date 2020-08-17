package com.example.Login_Register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login_Register.entity.RegisterEntity;
import com.example.Login_Register.models.LoginModel;
import com.example.Login_Register.service.LoginService;



@RestController
@RequestMapping("/user")
public class LoginController {

@Autowired
LoginService service;

@PostMapping("/login")
public ResponseEntity<String> PostFunction(@RequestBody LoginModel data)
{

 String value= service.authenticateUser(data);
 return new ResponseEntity<String>(value,HttpStatus.OK);
}


	
}
