package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.EmployeeDAO;
import com.example.demo.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{

	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	public List<Employee> getAllEmployee()
	{
		
		return employeeDAO.getAllEmployee();
	}

	/*
	 * @Override public Employee save(Employee employee) {
	 * 
	 * return employeeDAO.save(employee); }
	 */
	
	@Override
	public void save(Employee employee) {
		
		employeeDAO.save(employee);
	}

	@Override
	public Employee getById(int id) 
	{
		return employeeDAO.getById(id);
	}

	@Override
	public Employee update(Employee employee)
	{
		return employeeDAO.update(employee);
	}

	@Override
	public void delete(int id) 
	{
		 employeeDAO.delete(id);
	}

	@Override
	public List<Employee> findByFirstname(String firstname) 
	{
		return employeeDAO.findByFirstname(firstname);
	}



}
