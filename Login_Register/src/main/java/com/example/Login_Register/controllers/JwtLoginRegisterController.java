package com.example.Login_Register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login_Register.entity.RegisterEntity;
import com.example.Login_Register.models.AuthenticationRequest;
import com.example.Login_Register.models.AuthenticationResponse;
import com.example.Login_Register.service.CustomUserDetailsService;
import com.example.Login_Register.service.LoginService;
import com.example.Login_Register.service.RegisterService;
import com.example.Login_Register.service.jwtUtil;



@RestController
@RequestMapping("/user")
public class JwtLoginRegisterController {


@Autowired
private jwtUtil jwtTokenUtil;

@Autowired
CustomUserDetailsService userDetailService;

@Autowired
private AuthenticationManager authenticationManager; 

@GetMapping("/check")
public String check() {
    return "You checked the JWT example";
}

@PostMapping("/register")
public String PostFunction(@RequestBody RegisterEntity data)
{

 String message =userDetailService.saveUser(data);
 return message;
}

@PostMapping("/login")
public ResponseEntity<?> CreateAuthenticationToken(@RequestBody AuthenticationRequest data) throws Exception
{
	try {
 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getPhone(), data.getPassword()));
	}
	catch (BadCredentialsException e) {
		throw new Exception("Incorrect username or password");
	}
	
	UserDetails userDetails = userDetailService.loadUserByUsername(data.getPhone());
	
	final String jwt = jwtTokenUtil.generateToken(userDetails.getUsername()); 
	
 return ResponseEntity.ok(new AuthenticationResponse(jwt));

}


	
}
