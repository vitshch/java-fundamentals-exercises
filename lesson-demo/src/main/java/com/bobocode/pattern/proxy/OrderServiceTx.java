package com.bobocode.pattern.proxy;

public class OrderServiceTx extends OrderService {

    @Override
    public void createOrder() {
        System.out.println("Begin transaction");
        try {
            super.createOrder();
            System.out.println("Commit transaction");
        } catch (RuntimeException exception) {
            System.out.println("Rollback transaction");
        }
    }

}
