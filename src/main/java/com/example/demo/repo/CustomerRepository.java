package com.example.demo.repo;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> getAllCustomer();
    public Customer createCustomer(Customer customer);
}
