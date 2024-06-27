package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Employee;
import com.skillstorm.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Autowired 
	private OfficeService officeService; 	//not sure if this is sound in professional development, but I used this to be able to access Office attributes for PUT map
	
	//find every employee
	public Iterable<Employee> getAllEmployees() {
		return repo.findAll();
	}
	
	//find an employee by ID
	public Employee findEmployeeById(int id) {
		if(!repo.existsById(id))
			return null;
		return repo.findById(id).get();
	}
	
	//create an employee
	public Employee createEmployee(Employee employee) {
		if(repo.existsById(employee.getEmployeeId()))
			return null;
		return repo.save(employee);
	}

	public void deleteEmployee(int id) {
		if(!repo.existsById(id))
			return;								//use the logger here to get an actual good message that can't delete this person because they don't exist
		repo.deleteById(id);
	}
		
	public Employee updateEmployee(int empId, String firstName, String lastName, int officeId) {
		if(!repo.existsById(empId))
			return null;
		Employee emp = repo.findById(empId).get();
		emp.setEmployeeFirstname(firstName);
		emp.setEmployeeLastname(lastName);		
		emp.setOffice(officeService.getOfficeById(officeId));
//		repo.findById(empId).get().setEmployeeFirstname(firstName);
//		repo.findById(empId).get().setEmployeeLastname(lastName);
//		repo.findById(empId).get().setOffice(officeService.getOfficeById(officeId));	//i used new emp obj for easy reading, but these commented repos might be better in that they store/create a new emp obj
		return repo.save(emp);
	}
	
	public int getCountOfEmployees() {
		return repo.countEmployees();
	}
}
