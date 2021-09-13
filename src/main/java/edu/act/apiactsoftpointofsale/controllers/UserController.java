package edu.act.apiactsoftpointofsale.controllers;

import edu.act.apiactsoftpointofsale.domains.ID;
import edu.act.apiactsoftpointofsale.domains.Users;
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
    public boolean createUser(@RequestBody Users User) {
        return UserService.createUser(User);
    }

    @PostMapping("/api/User/update")
    public boolean updateUser(@RequestBody Users User) {
        return UserService.updateUser(User);
    }

    @PostMapping("/api/User/getByID")
    public Users getUser(@RequestBody ID id) {
        return UserService.getUser(id);
    }

    @PostMapping("/api/User/delete")
    public boolean deleteUser(@RequestBody ID id) {
        return UserService.deleteUser(id);
    }

    // list all Users
    @GetMapping("/api/User/list")
    public Iterable<Users> listUsers() {
        return UserService.allUsers();
    }
}

