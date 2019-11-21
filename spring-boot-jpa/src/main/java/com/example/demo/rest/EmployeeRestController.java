package com.example.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController 
{
	private EmployeeService employeeservice;
	
	public EmployeeRestController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee()
	{
		return employeeservice.getAllEmployee();
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee)
	{
		 employee.setEmployee_id(0);
		 employeeservice.save(employee);
		 return employee;
	}
	
	@GetMapping("/employees/{theId}")
	public Employee getById(@PathVariable int theId) 
	{
		return employeeservice.getById(theId);
	}
	
	
	@GetMapping("/employeeName/{firstname}")
	public List<Employee> getByfirstName(@PathVariable String firstname)
	{
		return employeeservice.findByFirstname(firstname);
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee)
	{
		return employeeservice.update(employee);
	}
	
	@DeleteMapping("/employees/{theId}")
	public void delete(@PathVariable int theId)
	{
		 employeeservice.delete(theId);
	}
	
	
}
