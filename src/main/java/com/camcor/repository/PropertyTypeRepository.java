package com.camcor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.camcor.model.PropertyType;


public interface PropertyTypeRepository extends CrudRepository<PropertyType, Long> {
	List<PropertyType> findByNameIsNull();
}
