package com.example.demo;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OfferServiceRepository;


@RestController
public class OfferServiceRestController 
{
	@Autowired
	private OfferServiceRepository offerServiceRepository;

	@RequestMapping(value = "/getCurrentOffers", method = RequestMethod.GET)
	@ResponseBody
	public List<Offers> getCurrentOffers()
	{
		return offerServiceRepository.findAll();
		
		/*
		 * List<Offers> offers = new ArrayList<Offers>(); offers.add(new
		 * Offers("Offer1", "Description1", "link1")); offers.add(new Offers("Offer2",
		 * "Description2", "link3")); offers.add(new Offers("Offer3",
		 * "Description3","link3")); return offers;
		 */
		 
	}
	
	@RequestMapping(value = "/saveOffers", method = RequestMethod.POST)
	public void saveOffers(@RequestBody Offers offers)
	{
		offerServiceRepository.save(offers);
	}
}
