package com.example.demo.DAO;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO 
{
	public List<Employee> getAllEmployee();
	//public Employee save(Employee employee);
	public void save(Employee employee);
	public Employee getById(int id);
	
	public Employee update(Employee employee);
	public void delete(int id);
	
	public List<Employee> findByFirstname(String firstname) ;
}
