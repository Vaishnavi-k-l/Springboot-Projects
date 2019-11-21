package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.Employee;
import com.example.demo.dao.EmployeeDAO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService 
{
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) 
	{
		super();
		this.employeeDAO = employeeDAO;
	}

	@Override
	public Employee save(Employee employee)
	{
		
		return employeeDAO.save(employee);
	}

	@Override
	public List<Employee> getAllEmloyee()
	{
		
		return employeeDAO.getAllEmloyee();
	}

	@Override
	public Employee getEmployeeById(int id) 
	{
		
		return employeeDAO.getEmployeeById(id);
	}

}
