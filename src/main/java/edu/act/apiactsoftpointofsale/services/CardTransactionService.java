package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.CardTransaction;
import edu.act.apiactsoftpointofsale.domains.CardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTransactionService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CardTransactionRepository CardTransactionRepository;

    public boolean createCardTransaction(CardTransaction CardTransaction) {

        try {
            CardTransactionRepository.save(CardTransaction);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean updateCardTransaction(CardTransaction CardTransaction) {
        try {
            long id = CardTransaction.getTransactionId();
            CardTransaction myCardTransaction = CardTransactionRepository.findById(id).get();
            myCardTransaction.setStatus(CardTransaction.getStatus());
            CardTransactionRepository.save(myCardTransaction);
            return true;
        }catch(Exception ex){
            return false;
        }
    }public CardTransaction getCardTransaction(long id) {
        try {
            return CardTransactionRepository.findById(id).get();
        }catch(Exception ex){
            return null;
        }
    }
    public boolean deleteCardTransaction(long id) {
        try {
            CardTransactionRepository.deleteById(id);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public Iterable<CardTransaction> allCardTransactions() {
        return CardTransactionRepository.findAll();
    }
}
