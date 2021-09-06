package edu.act.apiactsoftpointofsale.repositories;

import edu.act.apiactsoftpointofsale.domains.CardTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardTransactionRepository extends CrudRepository<CardTransaction, Long> {}
