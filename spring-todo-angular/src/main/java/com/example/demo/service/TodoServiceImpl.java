package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService 
{

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public List<Todo> getAlltodos() 
	{
		return todoRepository.findAll();
	}

	@Override
	public Todo saveTodo(Todo todo)
	{
		return todoRepository.save(todo);
	}

	@Override
	public Optional<Todo> findById(int id) 
	{
		return todoRepository.findById(id);
	}

}
