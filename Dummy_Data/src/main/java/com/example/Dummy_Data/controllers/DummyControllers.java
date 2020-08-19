package com.example.Dummy_Data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dummy_Data.model.CRUDentity;
import com.example.Dummy_Data.service.DummyService;


@RestController
@RequestMapping("/user")
public class DummyControllers {
	
	@Autowired
	DummyService service;
	
	@GetMapping("/dummydata/{id}")
	@ResponseStatus(HttpStatus.OK)
	public  ResponseEntity<Boolean> GetDummyFunction(@PathVariable("id") Long number)
	{
		//System.out.println("inside");
		Boolean flag=service.sendDummyData(number.intValue());
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
				
      
	}

}
