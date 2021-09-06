package edu.act.apiactsoftpointofsale.controllers;

import edu.act.apiactsoftpointofsale.domains.Customer;
import edu.act.apiactsoftpointofsale.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService CustomerService;

    // For creating/inserting Customer to the DB
    // call service class

    @PostMapping("/api/Customer/create")
    public Customer createCustomer(@RequestBody Customer Customer) {
        return CustomerService.createCustomer(Customer);
    }

    // list all Customers
    @GetMapping("/api/Customer/list")
    public Iterable<Customer> listCustomers() {
        return CustomerService.allCustomers();
    }
}

