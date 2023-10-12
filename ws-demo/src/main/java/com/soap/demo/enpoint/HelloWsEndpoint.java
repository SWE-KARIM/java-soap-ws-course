package com.soap.demo.enpoint;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class HelloWsEndpoint {
	
	@WebMethod
	public String sayHi() {
		return "Hello, Java WS Course";
	}

}
