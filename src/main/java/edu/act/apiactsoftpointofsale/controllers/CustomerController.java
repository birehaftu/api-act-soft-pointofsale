package edu.act.apiactsoftpointofsale.controllers;

import edu.act.apiactsoftpointofsale.domains.Customer;
import edu.act.apiactsoftpointofsale.domains.ID;
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

    @PostMapping("/api/customer/create")
    public boolean createCustomer(@RequestBody Customer Customer) {
        return CustomerService.createCustomer(Customer);
    }

    @PostMapping("/api/customer/update")
    public boolean updateCustomer(@RequestBody Customer Customer) {
        return CustomerService.updateCustomer(Customer);
    }

    @PostMapping("/api/customer/getByID")
    public Customer getCustomer(@RequestBody ID id) {
        return CustomerService.getCustomer(id);
    }

    @PostMapping("/api/customer/delete")
    public boolean deleteCustomer(@RequestBody ID id) {
        return CustomerService.deleteCustomer(id);
    }

    // list all Customers
    @GetMapping("/api/customer/list")
    public Iterable<Customer> listCustomers() {
        return CustomerService.allCustomers();
    }
}

