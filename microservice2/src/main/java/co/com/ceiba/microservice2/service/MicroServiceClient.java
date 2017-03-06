package co.com.ceiba.microservice2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import co.com.ceiba.microservice2.model.Greeting;

@ConfigurationProperties(prefix="microservice")
public class MicroServiceClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(MicroServiceClient.class);
	
	private String pingUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="retrieveFallbackGreetMicroservice")
	public Greeting greetMicroService(Greeting greeting){
		
		LOGGER.debug("--> greet received");
		LOGGER.debug("--> value: {}", greeting.getValue());
		LOGGER.debug("--> ping url: {}", pingUrl);
		
		return restTemplate.postForObject(pingUrl, greeting, Greeting.class);
	}	

    public Greeting retrieveFallbackGreetMicroservice(Greeting greeting){
    	greeting.setValue("Error greet microservice. This is a fallback message");
        return greeting;
    }
}
