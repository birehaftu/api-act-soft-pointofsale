package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.Customer;
import edu.act.apiactsoftpointofsale.domains.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CustomerAccountRepository CustomerAccountRepository;

    public boolean createCustomerAccount(CustomerAccount CustomerAccount) {

        try {
            CustomerAccountRepository.save(CustomerAccount);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean updateCustomerAccount(CustomerAccount CustomerAccount) {
        try {
            long id = CustomerAccount.getAccountId();
            CustomerAccount myCustomerAccount = CustomerAccountRepository.findById(id).get();
            myCustomerAccount.setAccountType(CustomerAccount.getAccountType());
            myCustomerAccount.setBalance(CustomerAccount.getBalance());
            myCustomerAccount.setStatus(CustomerAccount.getStatus());
            CustomerAccountRepository.save(myCustomerAccount);
            return true;
        }catch(Exception ex){
            return false;
        }
    }public CustomerAccount getCustomerAccount(long id) {
        try {
            return CustomerAccountRepository.findById(id).get();
        }catch(Exception ex){
            return null;
        }
    }
    public boolean deleteCustomerAccount(long id) {
        try {
            CustomerAccountRepository.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public Iterable<CustomerAccount> allCustomerAccounts() {
        return CustomerAccountRepository.findAll();
    }
}
