package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.ProductRabbitMq1Application;
import com.example.demo.commands.ProductForm;
import com.example.demo.converter.ProductFormToProduct;
import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	 private ProductRepository productRepository;
	 private ProductFormToProduct productFormToProduct;
	 private RabbitTemplate rabbitTemplate;
	
	public ProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct,
			RabbitTemplate rabbitTemplate) 
	{
		super();
		this.productRepository = productRepository;
		this.productFormToProduct = productFormToProduct;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public List<Product> listAll() 
	{
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product getById(Long id) 
	{
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product saveOrUpdate(Product product) 
	{
		productRepository.save(product);
		return product;
	}

	@Override
	public void delete(Long id)
	{
		productRepository.deleteById(id);
	}

	@Override
	public Product saveOrUpdateProductForm(ProductForm productForm)
	{
		 Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));
	     System.out.println("Saved Product Id: " + savedProduct.getId());
	     return savedProduct;
	}

	@Override
	public void sendProductMessage(String id) 
	{
		Map<String, String> actionmap = new HashMap<>();
        actionmap.put("id", id);
        log.info("Sending the index request through queue message");
        rabbitTemplate.convertAndSend(ProductRabbitMq1Application.SFG_MESSAGE_QUEUE, actionmap);
	}

}
