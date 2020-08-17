package com.example.CRUD.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUD.entity.CRUDentity;
import com.example.CRUD.repository.CRUDrepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service

public class CRUDservice {

	@Autowired
	CRUDrepository repository;
	
	@HystrixCommand(fallbackMethod = "getAllDatadefaultAction")
	public List<CRUDentity> getAllData() {
		return repository.getallData();
	}
	
	public List<CRUDentity> getAllDatadefaultAction(){
		CRUDentity entity= new CRUDentity();
		entity.setAge(0);
		entity.setCurrentstatus("Default Value");
		entity.setDate("Default Value");
		entity.setDetectedcity("Default Value");
		entity.setDetectedstate("Default Value");
		entity.setName("Default Value");
		entity.setId(0L);
		
		List<CRUDentity> list=new ArrayList<>();
		list.add(entity);
		return list;
	}
	
	@HystrixCommand(fallbackMethod = "saveDatadefaultAction")
	public Boolean saveData(CRUDentity data) {
	  CRUDentity temp= repository.save(data);
		  return true;
		
	}
	
	public Boolean saveDatadefaultAction(CRUDentity e)
	{
		return false;
	}
	@HystrixCommand(fallbackMethod = "getDatadefaultAction")
	public CRUDentity getData(Long id) {
		Optional<CRUDentity> optional=repository.findById(id);
			return optional.get();
	
	}
	
	public CRUDentity getDatadefaultAction(Long id)
	{
		CRUDentity entity= new CRUDentity();
		entity.setAge(0);
		entity.setCurrentstatus("Default Value");
		entity.setDate("Default Value");
		entity.setDetectedcity("Default Value");
		entity.setDetectedstate("Default Value");
		entity.setName("Default Value");
		entity.setId(0L);
		
		return entity;
	}

	@HystrixCommand(fallbackMethod = "editDatadefaultAction")
	public Boolean editData(Long id, CRUDentity data) {
		Optional<CRUDentity> value=repository.findById(id);
		
	    data.setId(value.get().getId());
	    repository.save(data);
	    return true;	
		
	}
	
	public Boolean editDatadefaultAction(Long id, CRUDentity data) {
		return false;
	}
  
	@HystrixCommand(fallbackMethod = "deleteDatadefaultAction")
	public Boolean deleteData(Long id) {
		repository.deleteById(id);
		return true;
	}
	
	public Boolean deleteDatadefaultAction(Long id)
	{
		return false;
	}

	@HystrixCommand(fallbackMethod = "defaultAction")
	public Boolean StoreDummyData(CRUDentity[] data) {
		List<CRUDentity> list=Arrays.asList(data);
		System.out.println(2/0); //Custom Exception for Hysterix Circuit Breaker testing.
		System.out.println("Hello"+list);
		repository.saveAll(list);
		return true;
	}
	
	
	
	public Boolean defaultAction(CRUDentity[] data)
	{
		return false;
	}

	
	

}
