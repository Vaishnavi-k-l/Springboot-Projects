package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public class NotificationService 
{
	private JavaMailSender javaMailSender;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender) 
	{
		super();
		this.javaMailSender = javaMailSender;
	}
	
	public void Sendnotification(User user) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("vaishnavikl799@gmail.com");
		mail.setSubject("Trial email!");
		mail.setText("Cool email notification");
		
		javaMailSender.send(mail);
	}
	

	
	
}
