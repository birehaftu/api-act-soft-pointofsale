package edu.act.apiactsoftpointofsale.controllers;

import edu.act.apiactsoftpointofsale.domains.CardTransaction;
import edu.act.apiactsoftpointofsale.services.CardTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardTransactionController {

    @Autowired
    private CardTransactionService CardTransactionService;

    // For creating/inserting CardTransaction to the DB
    // call service class

    @PostMapping("/api/CardTransaction/create")
    public boolean createCardTransaction(@RequestBody CardTransaction CardTransaction) {
        return CardTransactionService.createCardTransaction(CardTransaction);
    }

    // list all CardTransactions
    @GetMapping("/api/CardTransaction/list")
    public Iterable<CardTransaction> listCardTransactions() {
        return CardTransactionService.allCardTransactions();
    }
}

