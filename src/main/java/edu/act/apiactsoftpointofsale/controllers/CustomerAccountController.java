package edu.act.apiactsoftpointofsale.controllers;


import edu.act.apiactsoftpointofsale.domains.CustomerAccount;
import edu.act.apiactsoftpointofsale.domains.ID;
import edu.act.apiactsoftpointofsale.services.CustomerAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerAccountController {

    @Autowired
    private CustomerAccountService CustomerAccountService;

    // For creating/inserting CustomerAccount to the DB
    // call service class

    @PostMapping("/api/customerAccount/create")
    public boolean createCustomerAccount(@RequestBody CustomerAccount CustomerAccount) {
        return CustomerAccountService.createCustomerAccount(CustomerAccount);
    }

    @PostMapping("/api/customerAccount/update")
    public boolean updateCustomerAccount(@RequestBody CustomerAccount CustomerAccount) {
        return CustomerAccountService.updateCustomerAccount(CustomerAccount);
    }

    @PostMapping("/api/customerAccount/getByID")
    public CustomerAccount getCustomerAccount(@RequestBody ID id) {
        return CustomerAccountService.getCustomerAccount(id);
    }

    @PostMapping("/api/customerAccount/delete")
    public boolean deleteCustomerAccount(@RequestBody ID id) {
        return CustomerAccountService.deleteCustomerAccount(id);
    }

    // list all CustomerAccounts
    @GetMapping("/api/customerAccount/list")
    public Iterable<CustomerAccount> listCustomerAccounts() {
        return CustomerAccountService.allCustomerAccounts();
    }
}

