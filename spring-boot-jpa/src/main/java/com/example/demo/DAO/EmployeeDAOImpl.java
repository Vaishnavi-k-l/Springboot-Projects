package com.example.demo.DAO;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.rest.EmployeeNotFoundException;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO 
{
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee()
	{
		Query query = entityManager.createQuery("FROM Employee", Employee.class);
		return query.getResultList();
	}

	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	/*
	 * @Override public Employee save(Employee employee) {
	 * 
	 * entityManager.persist(employee); return employee; }
	 */
	
	@Override
	public void save(Employee employee) 
	{
		//entityManager.getTransaction().begin();
		Employee empl =  entityManager.merge(employee);
		employee.setEmployee_id(empl.getEmployee_id());
		//entityManager.getTransaction().commit();
	}

	@Override
	public Employee getById(int id) 
	{
		Employee employee = entityManager.find(Employee.class, id);
		
		  if(employee == null) 
		  { 
			  throw new
			  EmployeeNotFoundException("Employee with id " + id + " is not found"); }
		 
		return employee;
	}

	@Override
	public Employee update(Employee employee)
	{
		save(employee);
		return employee;
	}

	@Override
	public void delete(int id)
	{
		Employee employee = entityManager.find(Employee.class, id);
		if(employee == null)
		{
			throw new EmployeeNotFoundException("Employee with id " + id + " is not found");
		}
		entityManager.remove(employee);
	}

	@Override
	public List<Employee> findByFirstname(String firstname) 
	{
		Query query = entityManager.createQuery("FROM Employee e where e.firstName=:fname");
		query.setParameter("fname", firstname);
		return query.getResultList();
	}

}
