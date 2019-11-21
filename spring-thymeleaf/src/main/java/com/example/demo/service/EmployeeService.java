package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService 
{
	public List<Employee> getAllEmployees();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
	public List<Employee> searchBy(String theFirstName, String theLastName, String email);
}
