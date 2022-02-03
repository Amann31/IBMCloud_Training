package com.example;

import java.util.UUID;

public class Order {
    private String orderId;
    private String orderName;
    private static String vendorName;

    {
        orderId= UUID.randomUUID().toString();
        orderName="Order-1";
    }

    static {
        vendorName="Vendor-1";
        System.out.println("Within static block: "+vendorName);
    }

    @Override
    public String toString() {
        return "orderId=" + orderId +
                "orderName= " + orderName+ "Vendor name:" +vendorName;
    }
    public static void main(String[] args){
    System.out.println("within main");
    Order order = new Order();
    System.out.println(order);
    }
}

