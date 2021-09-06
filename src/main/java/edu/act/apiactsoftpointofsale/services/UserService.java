package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.repositories.UserRepository;
import edu.act.apiactsoftpointofsale.domains.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public Users createUser(Users User) {

        return UserRepository.save(User);
    }

    public Iterable<Users> allUsers() {
        return UserRepository.findAll();
    }
}
