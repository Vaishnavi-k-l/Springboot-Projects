package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeSearchRepository;

@RestController
@RefreshScope
@RequestMapping("/api")
public class EmployeeRestController 
{
	@Autowired
	EmployeeSearchRepository employeeSearchRepository;

	@RequestMapping("/employees")
	public List<Employee> findAll() 
	{
		return employeeSearchRepository.findAll();

	}
	
	@RequestMapping("/employees/{empId}")
	public Optional<Employee> findById(@PathVariable Long id)
	{
		return employeeSearchRepository.findById(id);
	}
	
}
