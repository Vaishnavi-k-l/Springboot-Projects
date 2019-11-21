package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "A")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee 
{
	private int userId;
	private String password;
}