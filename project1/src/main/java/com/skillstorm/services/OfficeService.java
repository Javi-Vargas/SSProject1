package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Office;
import com.skillstorm.repositories.OfficeRepository;

@Service
public class OfficeService {
	@Autowired
	private OfficeRepository repo;

	//find all offices
	public Iterable<Office> getAllOffices() {
		return repo.findAll();
	}
	
	//find an office by its ID
	public Office getOfficeById(int id) {
		if(!repo.existsById(id))
			return null;			//i think i should just go ahead and add the logger first time around		
		return repo.findById(id).get();
	}
	
	//create/add an office
	public Office createOffice(Office office) {
		if(repo.existsById(office.getOfficeId()))
			return null;
		return repo.save(office);
	}
}
