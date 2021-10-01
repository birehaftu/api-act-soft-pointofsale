package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.*;
import edu.act.apiactsoftpointofsale.domains.CardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardTransactionService {
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CardTransactionRepository CardTransactionRepository;
    @Autowired
    private edu.act.apiactsoftpointofsale.repositories.CustomerAccountRepository CustomerAccountRepository;
    public CustomerAccount getCustomerAccount2(long id) {
        try {
            CustomerAccount account = CustomerAccountRepository.findByAccountId(id);
            return account;
        } catch (Exception ex) {
            return null;
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
    public boolean createCardTransaction(CardTransaction ct) {

        try {
            ct.setDateofTransaction (LocalDateTime.now());
            double bala=ct.getTransaction_card().getCustomer_account().getBalance()-ct.getAmount();
            long accountId=ct.getTransaction_card().getCustomer_account().getAccountId();
            CustomerAccount account=getCustomerAccount2(accountId);
            if (account!=null){
                account.setBalance(bala);
                updateCustomerAccount(account);
            }
            CardTransaction cardTransaction=CardTransactionRepository.save(ct);
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
    }public CardTransaction getCardTransaction(ID id) {
        try {
            return CardTransactionRepository.findById(id.getId()).get();
        }catch(Exception ex){
            return null;
        }
    }
    public boolean deleteCardTransaction(ID id) {
        try {
            CardTransactionRepository.deleteById(id.getId());
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public Iterable<CardTransaction> allCardTransactions() {
        Iterable<CardTransaction> tnx= CardTransactionRepository.findAll();
        return tnx;
    }
}
