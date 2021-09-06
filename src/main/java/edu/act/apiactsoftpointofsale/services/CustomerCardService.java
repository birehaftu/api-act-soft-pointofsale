package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.CustomerCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerCardService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CustomerCardRepository CustomerCardRepository;

    public CustomerCard createCustomerCard(CustomerCard customerCard) {

        return CustomerCardRepository.save(customerCard);
    }

    public Iterable<CustomerCard> allCustomerCards() {
        return CustomerCardRepository.findAll();
    }
}
