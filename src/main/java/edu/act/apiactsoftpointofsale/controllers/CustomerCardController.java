package edu.act.apiactsoftpointofsale.controllers;


import edu.act.apiactsoftpointofsale.domains.CustomerCard;
import edu.act.apiactsoftpointofsale.domains.ID;
import edu.act.apiactsoftpointofsale.services.CustomerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerCardController {

    @Autowired
    private CustomerCardService CustomerCardService;

    // For creating/inserting CustomerCard to the DB
    // call service class

    @PostMapping("/api/customerCard/create")
    public boolean createCustomerCard(@RequestBody CustomerCard CustomerCard) {
        return CustomerCardService.createCustomerCard(CustomerCard);
    }

    @PostMapping("/api/customerCard/update")
    public boolean updateCustomerCard(@RequestBody CustomerCard CustomerCard) {
        return CustomerCardService.updateCustomerCard(CustomerCard);
    }

    @PostMapping("/api/customerCard/getByID")
    public CustomerCard getCustomerCard(@RequestBody ID id) {
        return CustomerCardService.getCustomerCard(id);
    }

    @PostMapping("/api/customerCard/delete")
    public boolean deleteCustomerCard(@RequestBody ID id) {
        return CustomerCardService.deleteCustomerCard(id);
    }

    // list all CustomerCards
    @GetMapping("/api/customerCard/list")
    public Iterable<CustomerCard> listCustomerCards() {
        return CustomerCardService.allCustomerCards();
    }
}

