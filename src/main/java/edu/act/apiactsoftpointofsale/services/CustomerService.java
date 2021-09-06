package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.Customer;
import edu.act.apiactsoftpointofsale.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository CustomerRepository;

    public Customer createCustomer(Customer customer) {

        return CustomerRepository.save(customer);
    }

    public Iterable<Customer> allCustomers() {
        return CustomerRepository.findAll();
    }
}
