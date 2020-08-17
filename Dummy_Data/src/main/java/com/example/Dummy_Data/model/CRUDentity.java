package com.example.Dummy_Data.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CRUDentity {

	private Long id;
	
	private String name;
	private Integer age;
	private String detectedcity;
	private String detectedstate;
	private String date;
	private String currentstatus;
	

}
