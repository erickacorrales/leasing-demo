package com.camcor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.util.Assert;

import lombok.Data;

@Data
@Entity
public class Person {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(unique = true)
	private String dni;
	
	private String phone;
	private String address;
	
	public Person(){
		
	}
	
	public Person(String firstName, String lastName, String dni, String phone, String address) {

		Assert.hasLength(dni, "Dni must not be empty");
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.phone = phone;
		this.address = address;
	}
	
	public Person(String firstName, String lastName, String dni) {
		Assert.hasLength(dni, "Dni must not be empty");
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		
	}
}
