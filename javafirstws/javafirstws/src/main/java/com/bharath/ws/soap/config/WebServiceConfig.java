package com.bharath.ws.soap.config;

import com.bharath.ws.soap.PaymentProcessorImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.util.HashMap;

@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpointImpl = new EndpointImpl(bus,new PaymentProcessorImpl());
        endpointImpl.publish("/paymentProcessor");

        HashMap<String, Object> properties = new HashMap<>();

        properties.put(ConfigurationConstants.ACTION,ConfigurationConstants.USERNAME_TOKEN);
        properties.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        properties.put(ConfigurationConstants.PW_CALLBACK_CLASS,UTPPasswordCallback.class.getName());

        WSS4JInInterceptor wss4JInInterceptor = new WSS4JInInterceptor(properties);
        endpointImpl.getInInterceptors().add(wss4JInInterceptor);

        return endpointImpl;
    }

}
