package edu.act.apiactsoftpointofsale.repositories;

import edu.act.apiactsoftpointofsale.domains.CustomerCard;
import edu.act.apiactsoftpointofsale.domains.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerCardRepository extends CrudRepository<CustomerCard, Long> {
    CustomerCard findByCardCode(String cardCode);
}



