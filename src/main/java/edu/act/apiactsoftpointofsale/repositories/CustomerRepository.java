package edu.act.apiactsoftpointofsale.repositories;

import edu.act.apiactsoftpointofsale.domains.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {}
