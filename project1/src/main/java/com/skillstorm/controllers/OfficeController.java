package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Office;
import com.skillstorm.services.OfficeService;

@RestController
@RequestMapping("/office")
@CrossOrigin(origins = "*")
public class OfficeController {
	
	@Autowired
	private OfficeService service;
	
	@GetMapping		//c R u d
	public Iterable<Office> getAllOffices() {
		return service.getAllOffices();
	}
	
	@GetMapping("/{id}") 	//c R u d
	public Office getOfficeById(@PathVariable int id) {
		return service.getOfficeById(id);
	}
	
	@PostMapping	//C r u d
	public Office addOffice(@RequestBody Office office) {
		return service.createOffice(office);
	}
	
}
