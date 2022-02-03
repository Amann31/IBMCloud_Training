package com.example;

import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
	// write your code here
        //primitive datatype
       // int a =100;
        //boxing
       // Integer x=new Integer(100);

        //auto-boxing
        //Integer y=100;

        //unboxing
       // int b=x.intValue();

        //auto-unboxing
        //int result=x;

        Beer myBeer= new Beer();
        String[] str = UUID.randomUUID().toString().split("-");
        myBeer.setBeerId(str[3]);
        System.out.println("Enter beer name: ");
        String name=s.next();
        myBeer.setBeerName(name);
        System.out.println("Enter cost per unit: ");
        double cost =s.nextDouble();
        myBeer.setCostPerUnit(cost);
        System.out.println("Enter Stock: ");
        int stock = s.nextInt();
        myBeer.setUnitInStock(stock);
        System.out.println(myBeer);
    }
}
