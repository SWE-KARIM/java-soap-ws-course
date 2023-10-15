package com.mtom.demo;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(){
        Endpoint endpoint = new EndpointImpl(bus, new FileMtomWsImpl());
        endpoint.publish("/fileWs");

        SOAPBinding soapBinding = (SOAPBinding) endpoint.getBinding();
        soapBinding.setMTOMEnabled(true);

        return endpoint;

    }


}
