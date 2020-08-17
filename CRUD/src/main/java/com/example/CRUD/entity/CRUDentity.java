package com.example.CRUD.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CRUD")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CRUDentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Integer age;
	private String detectedcity;
	private String detectedstate;
	private String date;
	private String currentstatus;
	

}
