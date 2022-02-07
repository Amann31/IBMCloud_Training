package com.company.tester;

import com.company.model.Customer;
import com.company.model.CustomerType;

import java.io.*;
import java.util.*;

public class MyApp {

    private static Map<Integer, Customer> customerMap=null;
    static {
        customerMap = new HashMap<>();
    }

    public static void main(String[] args) {

        File file;
        BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
        int choice=0;
        String name=null;
        String address=null;
        int id;
        CustomerType customerType=null;
        do{
            System.out.print("1. Create Customer. \t");
            System.out.print("2. Display Customer. \t");
            System.out.println("3. Update details on Id.\t");
            System.out.print("4. Find with ID. \t");
            System.out.print("0. Exit. ");
            System.out.println("\nEnter your choice: ");
            try {
                choice=Integer.parseInt(B.readLine());
                switch (choice)
                {
                    case 1:
                        System.out.println("Enter Customer name: ");
                        name = B.readLine();
                        System.out.println("Enter Customer address: ");
                        address = B.readLine();
                        System.out.println("Enter Customer type: ");
                        customerType = CustomerType.valueOf(B.readLine());
                        System.out.println("Enter Customer ID: ");
                        id = Integer.parseInt(B.readLine());
                        Customer customer = new Customer(name,address,customerType);
                        customerMap.put(id,customer);
                        System.out.println("Customer added successfully.");
                        break;
                    case 2:
                        /*Collection<Customer> collection = customerMap.values();
                        Iterator<Customer> customerIterator = collection.iterator();
                        while (customerIterator.hasNext())
                        {
                            System.out.println(customerIterator.next());
                        }*/
                        Set set=customerMap.entrySet();
                        Iterator iterator= set.iterator();
                        while (iterator.hasNext())
                        {
                            System.out.println(iterator.next());
                        }
                        break;
                    case 3:
                        int id1;
                        System.out.println("Enter the ID: ");
                        id1= Integer.parseInt(B.readLine());
                        if(customerMap.containsKey(id1))
                        {
                            System.out.println("Enter updated Customer name: ");
                            name = B.readLine();
                            System.out.println("Enter updated Customer address: ");
                            address = B.readLine();
                            System.out.println("Enter updated Customer type: ");
                            customerType = CustomerType.valueOf(B.readLine());
                            Customer customer1 = new Customer(name,address,customerType);
                            customerMap.replace(id1, customer1);
                            System.out.println("Customer Details Updated Successfully.");
                        }
                       else
                        {
                            System.out.println("Customer with specified id not present.");
                        }
                        break;
                    case 4:
                        int id2=0;
                        System.out.println("Enter ID: ");
                        id2= Integer.parseInt(B.readLine());
                        if(customerMap.containsKey(id2))
                        {
                            System.out.println("Customer found with details: ");
                            Collection<Customer> collection = customerMap.values();
                            Iterator<Customer> customerIterator = collection.iterator();
                            while (customerIterator.hasNext())
                            {
                                System.out.println(customerIterator.next());
                            }
                        }
                        else{
                            System.out.println("Customer not found.");
                        }
                        break;
                    case 0:
                        System.out.println("Bye...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                        break;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }while(choice!=0);
    }
}
