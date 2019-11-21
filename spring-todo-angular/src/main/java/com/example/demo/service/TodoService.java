package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Todo;

public interface TodoService
{
	public List<Todo> getAlltodos();
	public Todo saveTodo(Todo todo);
	public Optional<Todo> findById(int id) ;
}