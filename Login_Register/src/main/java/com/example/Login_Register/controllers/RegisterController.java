package com.example.Login_Register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login_Register.entity.RegisterEntity;
import com.example.Login_Register.service.LoginService;
import com.example.Login_Register.service.RegisterService;

@RestController
@RequestMapping("/user")
public class RegisterController {

@Autowired
RegisterService service;


@PostMapping("/register")
public String PostFunction(@RequestBody RegisterEntity data)
{

 String message =service.saveUser(data);
 return message;
}

}
