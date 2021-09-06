package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.CardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTransactionService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CardTransactionRepository CardTransactionRepository;

    public CardTransaction createCardTransaction(CardTransaction CardTransaction) {

        return CardTransactionRepository.save(CardTransaction);
    }

    public Iterable<CardTransaction> allCardTransactions() {
        return CardTransactionRepository.findAll();
    }
}