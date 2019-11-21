package com.example.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.demo.commands.ProductForm;
import com.example.demo.domain.Product;

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product>
{

	@Override
	public Product convert(ProductForm productForm)
	{
		Product product = new Product();
		if(productForm.getId() != null && !StringUtils.isEmpty(productForm.getId()))
		{
			product.setId(new Long(productForm.getId()));
		}
		product.setDescription(productForm.getDescription());
		product.setImageUrl(productForm.getImageUrl());
		product.setPrice(productForm.getPrice());
		return product;
	}
	
}
