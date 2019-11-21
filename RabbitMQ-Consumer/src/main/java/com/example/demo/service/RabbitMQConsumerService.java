package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeRepository;
import com.example.demo.model.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class RabbitMQConsumerService 
{
	private static final String QUEUE = "foo.queue";
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Employee employee) 
	{
		employeeRepository.save(employee);
		System.out.println("Employee object save dinto the database");
		System.out.println("Received Message from foo-queue Queue >>" + employee);
	}
}
