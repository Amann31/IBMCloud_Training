package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String displayAllCustomers(Model theModel) {
        theModel.addAttribute("customers", customerRepository.getAllCustomer());
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer using our service
        customerRepository.createCustomer(theCustomer);


        return "redirect:/";
    }
}