package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Posts;
import com.example.demo.service.PostsService;

@RestController
@RequestMapping("/api")
public class PostController 
{
	private PostsService postService;

	@Autowired
	public PostController(PostsService postService) {
		super();
		this.postService = postService;
	}

	@RequestMapping("/posts")
	public List<Posts> getAllPost()
	{
		return postService.getAllPosts();
	}
}
