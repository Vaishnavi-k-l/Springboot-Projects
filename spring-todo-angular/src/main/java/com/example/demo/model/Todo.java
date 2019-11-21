package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "A")
public class Todo 
{
	private ObjectId _id;
	
	//private String user;
	private String desc;
	
	public String get_id()
	{
		return _id.toHexString();
	}
}
