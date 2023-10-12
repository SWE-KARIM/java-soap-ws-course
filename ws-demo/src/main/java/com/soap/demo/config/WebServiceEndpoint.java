package com.soap.demo.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.*;
import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.soap.demo.enpoint.HelloWsEndpoint;

@Configuration
public class WebServiceEndpoint {
	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new HelloWsEndpoint());
		endpoint.publish("/hello");
		
		return endpoint;
	}

}
