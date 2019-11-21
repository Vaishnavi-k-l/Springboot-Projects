package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmployeeService 
{

	public Employee createEmployee(String name, String empId) 
	{
		System.out.println("Current system time:" + System.currentTimeMillis());

		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	
	}

	public void deleteEmployee(String empId) {
		
	}
}
