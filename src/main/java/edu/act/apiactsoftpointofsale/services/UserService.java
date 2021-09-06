package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.repositories.UserRepository;
import edu.act.apiactsoftpointofsale.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User createUser(User User) {

        return UserRepository.save(User);
    }

    public Iterable<User> allUsers() {
        return UserRepository.findAll();
    }
}
