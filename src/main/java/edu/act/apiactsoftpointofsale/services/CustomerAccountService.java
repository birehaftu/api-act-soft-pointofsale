package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.Customer;
import edu.act.apiactsoftpointofsale.domains.CustomerAccount;
import edu.act.apiactsoftpointofsale.domains.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CustomerAccountRepository CustomerAccountRepository;

    public boolean createCustomerAccount(CustomerAccount CustomerAccount) {

        try {
            CustomerAccount acc = CustomerAccountRepository.save(CustomerAccount);
            return true;
        } catch (Exception ex) {
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
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateCustomerAccountBalance(CustomerAccount CustomerAccount) {
        try {
            long id = CustomerAccount.getAccountId();
            CustomerAccount myCustomerAccount = CustomerAccountRepository.findByAccountId(id);
            myCustomerAccount.setBalance(CustomerAccount.getBalance());
            CustomerAccountRepository.save(myCustomerAccount);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public CustomerAccount getCustomerAccount(ID id) {
        try {
            return CustomerAccountRepository.findById(id.getId()).get();
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean deleteCustomerAccount(ID id) {
        try {
            CustomerAccountRepository.deleteById(id.getId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Iterable<CustomerAccount> allCustomerAccounts() {
        return CustomerAccountRepository.findAll();
    }
}
