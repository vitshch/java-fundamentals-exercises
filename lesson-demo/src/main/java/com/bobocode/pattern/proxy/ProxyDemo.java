package com.bobocode.pattern.proxy;

public class ProxyDemo {

    public static void main(String[] args) {
        OrderService orderService = orderService();
        orderService.createOrder();

        OrderService orderServiceTx = orderServiceTx();
        orderServiceTx.createOrder();
    }

    private static OrderService orderService() {
        return new OrderService();
    }

    private static OrderService orderServiceTx() {
        return new OrderServiceTx();
    }

}
