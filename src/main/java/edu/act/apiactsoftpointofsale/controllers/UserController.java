package edu.act.apiactsoftpointofsale.controllers;

import edu.act.apiactsoftpointofsale.domains.User;
import edu.act.apiactsoftpointofsale.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService UserService;

    // For creating/inserting User to the DB
    // call service class

    @PostMapping("/api/User/create")
    public User createUser(@RequestBody User User) {
        return UserService.createUser(User);
    }

    // list all Users
    @GetMapping("/api/User/list")
    public Iterable<User> listUsers() {
        return UserService.allUsers();
    }
}

