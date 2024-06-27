package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;

import com.skillstorm.models.Office;

public interface OfficeRepository extends CrudRepository<Office, Integer>{
	Iterable<Office> findAll();
	
	//custom methods for queries go here
}
