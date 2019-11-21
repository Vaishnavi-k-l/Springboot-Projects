package com.example.demo.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class HomeController
{
	private EmployeeService employeeService;
	
	public HomeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "show-form";
	}
	
	//Once form is submitted
	@RequestMapping("/processForm")
	public String processFor(@ModelAttribute("employee") Employee employee, Model theModel)
	{
		Employee theEmployee = employeeService.save(employee);
		theModel.addAttribute("employee", theEmployee);
		return "process-employee";
	}
	
	//To display all employees
	@RequestMapping("/displayEmployee")
	public String displayEmployee(Model theModel)
	{
		List<Employee> emplist = employeeService.getAllEmloyee();
		theModel.addAttribute("employeelist", emplist);
		return "employee-list";
	}
	
	//Displays the form to take the Employee ID
	@RequestMapping("/displayOneEmployee")
	public String showAnEmployee(Model model)
	{
		model.addAttribute("employee", new Employee());
		return "show-id-form";
	}
	
	
	//To display an employee with a given id
	@RequestMapping("/getOneEmployee")
	public String getEmployeebyId(@ModelAttribute("employee") Employee employee, @RequestBody int id, Model theModel)
	{
		Employee emp = employeeService.getEmployeeById(id);
		theModel.addAttribute("employee", emp);
		return "employee-by-Id";
	}
	
	

	
}
