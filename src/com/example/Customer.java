package com.example;

import java.util.UUID;

public class Customer {
    private final String customerId;

    public Customer(){
        customerId = createId();
    }

    private String createId(){
        return UUID.randomUUID().toString();
    }

    public String getCustomerId() {
        return customerId;
    }

    public static void main(String[] args){

        Customer customer = new Customer();
        System.out.println(customer.getCustomerId());
    }
}
