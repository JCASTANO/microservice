package co.com.ceiba.microservice2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.microservice2.model.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping("microservice2/")
public class MicroService2Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(MicroService2Controller.class);

    
    @RequestMapping(method=RequestMethod.POST, value="greet/")
    @ApiOperation(value = "greet", nickname = "greet", response = Greeting.class)
    public Greeting ping(@ApiParam(value = "greeting", required = true) 
    					 @RequestBody(required=true) Greeting greeting) {
    	
    	LOGGER.debug("--> greet received");
		LOGGER.debug("--> value: {}", greeting.getValue());
    	
    	return greeting;
    }
}