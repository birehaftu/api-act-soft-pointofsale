package edu.act.apiactsoftpointofsale.controllers;


import edu.act.apiactsoftpointofsale.domains.CustomerCard;
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

    @PostMapping("/api/CustomerCard/create")
    public boolean createCustomerCard(@RequestBody CustomerCard CustomerCard) {
        return CustomerCardService.createCustomerCard(CustomerCard);
    }

    // list all CustomerCards
    @GetMapping("/api/CustomerCard/list")
    public Iterable<CustomerCard> listCustomerCards() {
        return CustomerCardService.allCustomerCards();
    }
}

