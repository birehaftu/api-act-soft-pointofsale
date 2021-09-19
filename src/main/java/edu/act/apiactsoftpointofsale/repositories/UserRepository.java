package edu.act.apiactsoftpointofsale.repositories;
import edu.act.apiactsoftpointofsale.domains.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>  {
    Users findByUserName(String username);
}
