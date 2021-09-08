package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.Customer;
import edu.act.apiactsoftpointofsale.domains.Customer;
import edu.act.apiactsoftpointofsale.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CustomerRepository customerRepository;

    public boolean createCustomer(Customer customer) {

        try {
            customerRepository.save(customer);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean updateCustomer(Customer Customer) {
        try {
            long id = Customer.getCustomerId();
            Customer myCustomer = customerRepository.findById(id).get();
            myCustomer.setEmail(Customer.getEmail());
            myCustomer.setDOB(Customer.getDOB());
            myCustomer.setFullName(Customer.getFullName());
            myCustomer.setMeritalStatus(Customer.getMeritalStatus());
            myCustomer.setPhone(Customer.getPhone());
            myCustomer.setAddress(Customer.getAddress());
            customerRepository.save(myCustomer);
            return true;
        }catch(Exception ex){
            return false;
        }
    }public Customer getCustomer(long id) {
        try {
            return customerRepository.findById(id).get();
        }catch(Exception ex){
            return null;
        }
    }
    public boolean deleteCustomer(long id) {
        try {
            customerRepository.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public Iterable<Customer> allCustomers() {
        return customerRepository.findAll();
    }
}
