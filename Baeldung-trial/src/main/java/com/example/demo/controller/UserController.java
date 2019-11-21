package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController
{
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	
	@GetMapping("/users")
	public List<User> getallUser()
	{
		return (List<User>) userRepository.findAll();
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user)
	{
		userRepository.save(user);
	}
}
