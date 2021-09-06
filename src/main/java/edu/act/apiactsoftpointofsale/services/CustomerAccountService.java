package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CustomerAccountRepository CustomerAccountRepository;

    public CustomerAccount createCustomerAccount(CustomerAccount CustomerAccount) {

        return CustomerAccountRepository.save(CustomerAccount);
    }

    public Iterable<CustomerAccount> allCustomerAccounts() {
        return CustomerAccountRepository.findAll();
    }
}
