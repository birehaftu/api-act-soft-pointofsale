package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.CustomerCard;
import edu.act.apiactsoftpointofsale.domains.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerCardService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CustomerCardRepository CustomerCardRepository;

    public boolean createCustomerCard(CustomerCard CustomerCard) {

        try {
            CustomerCardRepository.save(CustomerCard);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean updateCustomerCard(CustomerCard CustomerCard) {
        try {
            long id = CustomerCard.getCardId();
            CustomerCard myCustomerCard = CustomerCardRepository.findById(id).get();
            myCustomerCard.setCardCode(CustomerCard.getCardCode());
            myCustomerCard.setPin(CustomerCard.getPin());
            myCustomerCard.setStatus(CustomerCard.getStatus());
            CustomerCardRepository.save(myCustomerCard);
            return true;
        }catch(Exception ex){
            return false;
        }
    }public CustomerCard getCustomerCard(ID id) {
        try {
            return CustomerCardRepository.findById(id.getId()).get();
        }catch(Exception ex){
            return null;
        }
    }
    public CustomerCard getCustomerCardByCard(String  id) {
        try {
            return CustomerCardRepository.findByCardCode(id);
        }catch(Exception ex){
            return null;
        }
    }
    public boolean deleteCustomerCard(ID id) {
        try {
            CustomerCardRepository.deleteById(id.getId());
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public Iterable<CustomerCard> allCustomerCards() {
        return CustomerCardRepository.findAll();
    }
}
