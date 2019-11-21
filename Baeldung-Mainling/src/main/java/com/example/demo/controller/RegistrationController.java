package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.NotificationService;


@RestController
public class RegistrationController 
{
	private Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/signup")
	public String signup()
	{
		return "Please sign up for our service";
	}
	
	@RequestMapping("/signup-success")
	public String signupSuccess()
	{
		User user = new User();
		user.setFirstName("Sonali");
		user.setLastName("jsahj");
		user.setEmail("sonalikarkera212@gmail.com");
		
		try
		{
			notificationService.Sendnotification(user);
		}
		catch(MailException e)
		{
			logger.info("Error sending email" + e.getMessage());
		}
		
		return "Thank you for registering";
	}
}
