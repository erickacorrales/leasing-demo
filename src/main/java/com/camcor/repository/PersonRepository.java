package com.camcor.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.camcor.model.Person;

@RepositoryRestResource(path="people", collectionResourceRel="people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
	List<Person> findByLastName(String lastName);
	List<Person> findByPhone(String phone);
}
