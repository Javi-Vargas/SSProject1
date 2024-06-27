package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Employee;
import com.skillstorm.models.Office;
import com.skillstorm.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping		//c R u d
	public Iterable<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")	//c R u d
	public Employee findEmployeeById(@PathVariable int id) {
		return service.findEmployeeById(id);
	}
	
	@PostMapping		//C r u d
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@DeleteMapping("/{id}")		//c r u D
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
	}
		
	@PutMapping		//c r U d
	public Employee updateEmployee(@RequestParam int empId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam int officeId) {
		return service.updateEmployee(empId, firstName, lastName, officeId);
	}
	
	@GetMapping("/count")
	public int getCountOfEmployees() {
		return service.getCountOfEmployees();
	}
}
