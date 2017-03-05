package co.com.ceiba.microservice2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.com.ceiba.microservice2.model.Greeting;

@Service
public class HelloClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloClient.class);
	
	public static final String HELLO_URL = "http://SADR-SERVICE/hello/greet";
	
	@Autowired
	private RestTemplate restTemplate;

	public Greeting helloMicroService1(Greeting greeting){
		
		LOGGER.debug("--> greet received");
		LOGGER.debug("--> value: {}", greeting.getValue());
		
		return restTemplate.postForObject(HELLO_URL, greeting, Greeting.class);
	}
	
}
