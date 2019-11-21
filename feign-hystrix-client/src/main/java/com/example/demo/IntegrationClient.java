package com.example.demo;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {

	@Autowired
	private OffersServiceClient offersClient;

	@Autowired
	private RecommendationServiceClient recommnedationClient;

	//Fallback
	public Collection<Product> getRecommendationFallback() {
		System.out.println("=======getRecommendationFallback=========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getRecommendationFallback")
	public Collection<Product> getRecommendations() {
		return this.recommnedationClient.getRecommendations();
	}

	//Fallback
	public Collection<Offers> getOffersFallback() {
		System.out.println("===========getOffersFallback===========");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getOffersFallback")
	public Collection<Offers> getOffers() {
		return this.offersClient.getCurrentOffers();
	}
	
	//Fallback
	public void saveOfferFallback(Offers offers)
	{
		System.out.println("Cannot save data");
	}
	
	@HystrixCommand(fallbackMethod = "saveOfferFallback")
	public void saveOffer(Offers offers)
	{
		this.offersClient.saveOffers(offers);
	}
	
	//Fallback
	public void saveProductFallback(Product product)
	{
		System.out.println("Cannot save data");
	}
	
	@HystrixCommand(fallbackMethod = "saveProductFallback")
	public void saveProduct(Product product)
	{
		this.recommnedationClient.saveProduct(product);
	}
	
}
