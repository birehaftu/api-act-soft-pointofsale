package edu.act.apiactsoftpointofsale.repositories;

import edu.act.apiactsoftpointofsale.domains.CustomerAccount;
import edu.act.apiactsoftpointofsale.domains.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {

    CustomerAccount findByAccountId(long id);
}

