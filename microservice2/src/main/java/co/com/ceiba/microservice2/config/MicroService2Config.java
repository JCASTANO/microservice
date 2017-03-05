package co.com.ceiba.microservice2.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import co.com.ceiba.microservice2.service.MicroServiceClient;

@Configuration
public class MicroService2Config {

	@Bean 
	public MicroServiceClient sadrClient(){
		
		return new MicroServiceClient();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		
		return new RestTemplate();
	}
	
}
