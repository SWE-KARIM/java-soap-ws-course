package com.example.impl;

import com.ws.kn.*;
import org.apache.cxf.feature.Features;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType {


    Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
    int currentId;

    /// TODO: init map act as db
    public void initData(){
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        order.setId(BigInteger.valueOf(1));

        Product product = new Product();
        product.setId(BigInteger.valueOf(1));
        product.setDescription("iPhone 11");
        product.setQuantity(BigInteger.valueOf(10));

        order.getProduct().add(product);

        orderList.add(order);

        customerOrders.put(BigInteger.valueOf(++currentId),orderList);
    }

    public CustomerOrdersWsImpl(){
        initData();
    }



    @Override
    public GetOrderResponse getOrders(GetOrderRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orderList = customerOrders.get(customerId);


        GetOrderResponse response = new GetOrderResponse();
        response.getOrder().addAll(orderList);

        return response;
    }

    @Override
    public CreateOrderResponse createOrders(CreateOrderRequest request) {
        BigInteger customerId = request.getCustomerId();
        Order order = request.getOrder();

        List<Order> orderList = customerOrders.get(customerId);
        orderList.add(order);

        CreateOrderResponse response = new CreateOrderResponse();
        response.setResult(true);

        return response;
    }

    @Override
    public DeleteOrderResponse deleteOrders(DeleteOrderRequest request) {
        BigInteger customerId = request.getCustomerId();
        List<Order> orderList = customerOrders.get(customerId);

        // Find the order to be deleted
        Order orderToDelete = null;
        for (Order order : orderList) {
            if (order.getId().equals(request.getCustomerId())) {
                orderToDelete = order;
                break;
            }
        }
        if (orderToDelete != null) {
            orderList.remove(orderToDelete);
        }

        DeleteOrderResponse response = new DeleteOrderResponse();
        response.setResult(true);

        return response;
    }
}
