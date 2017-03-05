package co.com.ceiba.microservice2.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
		"co.com.ceiba.microservice2.config",
		"co.com.ceiba.microservice2.controller",
		"co.com.ceiba.microservice2.service"
})
public class Application {
	
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
	
}
