package com.example.demo;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.RecommendationRepository;

@RestController
public class RecommendationServiceRestController 
{
	@Autowired
	private RecommendationRepository recommendationRepository;
	
	@RequestMapping(value = "/recommendations", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getCurrentOffers() 
	{
		return recommendationRepository.findAll();
		
		/*
		 * List<Product> products = new ArrayList<Product>(); products.add(new
		 * Product("Product1", "Description1", "link1")); products.add(new
		 * Product("Product2", "Description2", "link3")); products.add(new
		 * Product("Product3", "Description3", "link3")); return products;
		 * 
		 */   
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public void saveProduct(@RequestBody Product product)
	{
		recommendationRepository.save(product);
	}
}
