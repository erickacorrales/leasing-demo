package com.camcor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="PROPERTYTYPE")
public class PropertyType {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	public PropertyType(){
	}

	public PropertyType(String name) {
		this.name = name;
	}

}
