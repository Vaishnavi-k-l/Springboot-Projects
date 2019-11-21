package com.example.demo.dao;

import java.util.List;

import com.example.demo.Employee;

public interface EmployeeDAO 
{
	public Employee save(Employee employee);
	public List<Employee> getAllEmloyee();
	public Employee getEmployeeById(int id);
}
