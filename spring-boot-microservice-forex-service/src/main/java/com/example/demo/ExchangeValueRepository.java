package com.example.demo;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExchangeValueRepository extends MongoRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);

}

/*public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);

}*/
