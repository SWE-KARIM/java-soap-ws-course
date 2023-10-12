package com.ws.soap.client.wsjavaclient;

import com.example.impl.CustomerOrdersWsImplService;
import com.ws.kn.*;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerOrdersWsClient {
    public static void main(String[] args) throws MalformedURLException {
        CustomerOrdersWsImplService customerOrdersWsImplService =
                new CustomerOrdersWsImplService(new URL("http://localhost:8080/wsdlfirst/customerorderservice?wsdl"));
        CustomerOrdersPortType customerOrdersWsImplPort = customerOrdersWsImplService.getCustomerOrdersWsImplPort();

        GetOrderRequest request = new GetOrderRequest();
        request.setCustomerId(BigInteger.valueOf(1));

        GetOrderResponse response = customerOrdersWsImplPort.getOrders(request);
        List<Order> orders = response.getOrder();

        System.out.println("Number of orders are: " +orders.size());

        ///-----------------------------------------------------------

//        CreateOrderRequest orderRequest = new CreateOrderRequest();
//        Order order = new Order();
//        orderRequest.setCustomerId(BigInteger.valueOf(2));
//        orderRequest.setOrder();

    }
}
