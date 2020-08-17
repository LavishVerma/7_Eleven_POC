package com.example.Login_Register.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Login_Register.entity.RegisterEntity;

@Repository
public interface Login_Register_Repository extends CrudRepository<RegisterEntity, Long> {
	
	@Query("select id from RegisterEntity u where u.phonenumber= ?1 and u.password= ?2")
	Long findByPhonenumberAndPassword(String phonenumber, String password);

}
