package com.camcor.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(name="Property.findAllPropertiesByType", query="select p from Property p where p.propertyType.name = :name")
public class Property {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String address;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name="PROPERTYTYPE_ID")
	private PropertyType propertyType;

	private String description;
	
	public Property(){
	}

	public Property(String address, BigDecimal price, PropertyType propertyType, String description) {
		this.address = address;
		this.price = price;
		this.propertyType = propertyType;
		this.description = description;
	}
	
}
