package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("/api")
public class TodoController 
{
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/Todo")
	public List<Todo> getAlltodos()
	{
		return todoService.getAlltodos();
	}
	
	@PostMapping("/Todo")
	public Todo saveTodo(@RequestBody Todo todo)
	{
		return todoService.saveTodo(todo);
	}
	
	/*@GetMapping("/findById/{theId}")
	public Todo findById(@PathVariable int theId)
	{
		return todoService.findById(theId);
	}*/
}