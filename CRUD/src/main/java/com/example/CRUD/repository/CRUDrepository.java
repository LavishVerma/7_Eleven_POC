package com.example.CRUD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.entity.CRUDentity;

@Repository
public interface CRUDrepository extends CrudRepository<CRUDentity, Long> {

	@Query("select c from CRUDentity c")
	List<CRUDentity> getallData();

}
