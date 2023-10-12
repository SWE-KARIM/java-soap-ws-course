package com.ws.soap.demo.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class WebServiceEndpoint {

    @WebMethod
    public String sayHi(){
        return "Hello, Java WS Course";
    }
}
