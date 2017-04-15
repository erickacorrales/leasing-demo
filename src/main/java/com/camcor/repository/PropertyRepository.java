package com.camcor.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.camcor.model.Property;

public interface PropertyRepository extends PagingAndSortingRepository<Property, Long> {
	List<Property> findAllPropertiesByType(@Param("name") String name);
}
