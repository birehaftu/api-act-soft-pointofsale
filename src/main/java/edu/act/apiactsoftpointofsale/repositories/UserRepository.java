package edu.act.apiactsoftpointofsale.repositories;
import edu.act.apiactsoftpointofsale.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {}
