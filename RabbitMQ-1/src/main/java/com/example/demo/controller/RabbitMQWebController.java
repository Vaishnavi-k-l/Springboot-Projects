package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.RabbitMQSender;


//@RestController
@Controller
@RequestMapping(value = "/java-rabbitmq/")
public class RabbitMQWebController 
{

	@Autowired
	private RabbitMQSender rabbitMQSender;
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/showForm")
	public String showForm(Model theModel)
	{
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "empForm";
	}
	
	
	@PostMapping(value = "/producer")
	public String producer(@ModelAttribute("employee") Employee theEmployee) 
	{
		Employee emp = new Employee();
		emp.setEmpId(theEmployee.getEmpId());
		emp.setEmpName(theEmployee.getEmpName());
		//employeeService.save(emp);
		rabbitMQSender.send(emp);
		return "success";
	}

	
	/*
	 * @GetMapping(value = "/producer") public String
	 * producer(@RequestParam("empName") String empName, @RequestParam("empId")
	 * String empId) {
	 * 
	 * Employee emp = new Employee(); emp.setEmpId(empId); emp.setEmpName(empName);
	 * //employeeService.save(emp); rabbitMQSender.send(emp); return
	 * "Message sent to the RabbitMQ  Successfully"; }
	 */

}
