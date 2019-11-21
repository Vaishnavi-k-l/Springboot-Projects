package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

	private EntityManager entityManager;
	
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public Employee save(Employee employee) 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmloyee() 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee order by lastName", Employee.class);
		
	
		List<Employee> customers = theQuery.getResultList();
					
		return customers;
		
	}

	@Override
	public Employee getEmployeeById(int id) 
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		if(employee == null)
		{
			System.out.println("No employee found");
		}
		return employee;
	}

	

}
