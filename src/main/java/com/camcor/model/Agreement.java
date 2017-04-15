package com.camcor.model;

import java.math.BigDecimal;
import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.springframework.util.Assert;

import lombok.Data;

@Data
@Entity
@NamedQuery(name="Agreement.findAllAgreementByTenant", query="select a from Agreement a where a.tenant.firstName = :name")
public class Agreement  {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="TENANT_ID", nullable = false)
	private Person tenant;
	
	
	@ManyToOne
	private Property property;
	
	private Date  dateOn;
	
	private Date dateOff;
	
	private BigDecimal price;
	
	private String description;
	
	public Agreement() {
		
	}


	public Agreement(Person tenant, Property property, Date dateOn, Date dateOff, BigDecimal price,
			String description) {
		Assert.isInstanceOf(Person.class, tenant, "tenant must not be empty");
		Assert.isInstanceOf(Property.class, property, "property must not be empty");
		this.tenant = tenant;
		this.property = property;
		this.dateOn = dateOn;
		this.dateOff = dateOff;
		this.price = price;
		this.description = description;
	}
	
}
