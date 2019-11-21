package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController 
{
	@GetMapping("/")
	public String home(Model theModel)
	{
		theModel.addAttribute("theDate", new Date());
		return "helloworld";
	}
}
