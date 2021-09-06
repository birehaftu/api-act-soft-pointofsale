package edu.act.apiactsoftpointofsale.repositories;

import edu.act.apiactsoftpointofsale.domains.CustomerAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {}

