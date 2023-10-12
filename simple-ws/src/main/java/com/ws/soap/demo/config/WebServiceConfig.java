package com.ws.soap.demo.config;

import com.ws.soap.demo.endpoint.WebServiceEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, WebServiceEndpoint.class);
        endpoint.publish("/hello");

        return endpoint;
    }
}
