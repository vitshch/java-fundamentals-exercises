package com.bobocode.pattern.proxy;

public class OrderService {

    public void createOrder() {
        calculateOrder();
        setupDelivery();
        notifyUser();
    }

    private void calculateOrder() {
        System.out.println("Calculate order");
    }

    private void setupDelivery() {
        System.out.println("Setup delivery");
    }

    private void notifyUser() {
        System.out.println("Notify User");
    }
}
