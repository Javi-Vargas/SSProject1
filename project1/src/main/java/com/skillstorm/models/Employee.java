package com.skillstorm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int employeeId;
	
	@Column(name="emp_firstname")
	private String employeeFirstname;
	
	@Column(name="emp_lastname")
	private String employeeLastname;
	
	@ManyToOne
	@JoinColumn(name = "office_id", referencedColumnName = "office_id")
	@JsonIgnoreProperties("employee")
	private Office office;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeFirstname, String employeeLastname, Office office) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstname = employeeFirstname;
		this.employeeLastname = employeeLastname;
		this.office = office;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstname() {
		return employeeFirstname;
	}

	public void setEmployeeFirstname(String employeeFirstname) {
		this.employeeFirstname = employeeFirstname;
	}

	public String getEmployeeLastname() {
		return employeeLastname;
	}

	public void setEmployeeLastname(String employeeLastname) {
		this.employeeLastname = employeeLastname;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	

}
