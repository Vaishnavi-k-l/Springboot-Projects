package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Posts;
import com.example.demo.repository.PostsRepository;

@Service
public class PostServiceImpl implements PostsService
{
	
	private PostsRepository postRepository;
	
	@Override
	public List<Posts> getAllPosts()
	{
		return postRepository.findAll();
	}

	@Autowired
	public PostServiceImpl(PostsRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

}
