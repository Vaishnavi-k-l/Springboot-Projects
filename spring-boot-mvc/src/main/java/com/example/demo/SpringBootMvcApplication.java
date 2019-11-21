package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class SpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
		
	
	}

	//Inner class
	@Component
	class EmployeeCommandLineRunner implements CommandLineRunner
	{
		@Autowired
		private EmployeeService employeeService;
		
		@SuppressWarnings("null")
		@Override
		public void run(String... args) throws Exception
		{
			Employee employee = new Employee();
			
			employee.setFirstName("Advika");
			employee.setLastName("P");
			employee.setSalary(20000);
			employeeService.save(employee);
			
			employee.setFirstName("Shreya");
			employee.setLastName("P");
			employee.setSalary(20000);
			employeeService.save(employee);
	
			employee.setFirstName("Jhanvi");
			employee.setLastName("P");
			employee.setSalary(20000);
			employeeService.save(employee);
		}
		
	}
}


