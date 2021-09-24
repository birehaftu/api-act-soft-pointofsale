package edu.act.apiactsoftpointofsale.controllers;

import edu.act.apiactsoftpointofsale.domains.ID;
import edu.act.apiactsoftpointofsale.domains.Users;
import edu.act.apiactsoftpointofsale.services.UserService;
import edu.act.apiactsoftpointofsale.services.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService UserService;

    // For creating/inserting User to the DB
    // call service class

    @PostMapping("/api/user/create")
    public boolean createUser(@RequestBody Users User) {
        return UserService.createUser(User);
    }

    @PostMapping("/api/user/update")
    public boolean updateUser(@RequestBody Users User) {
        return UserService.updateUser(User);
    }

    @PostMapping("/api/user/getByID")
    public Users getUser(@RequestBody ID id) {
        return UserService.getUser(id);
    }

    @PostMapping("/api/user/getByUserName/{userName}")
    public Users getUser(@PathVariable String userName) {
        return UserService.findByUserName(userName);
    }

    @PostMapping("/api/user/getUserLogIn/{userName}/{password}")
    public boolean getUserLogIn(@PathVariable String userName,@PathVariable String password) {
        try {
            Users us = UserService.findByUserName(userName);
            if (us!=null) {
                if (us.getRole().equals("Admin")) {
                    Encryption ency = new Encryption();
                    return ency.Validate(password, us.getPassword());
                } else {
                    return false;
                }
            }else{
                return false;
            }
        }catch(Exception exception){
            return false;
        }
    }
    @PostMapping("/api/user/getUserAgentLogIn/{userName}/{password}")
    public boolean getUserLogInAgent(@PathVariable String userName,@PathVariable String password) {
        try {
            Users us = UserService.findByUserName(userName);
            if (us!=null) {
                if (us.getRole().equals("Agent")) {
                    Encryption ency = new Encryption();
                    return ency.Validate(password, us.getPassword());
                } else {
                    return false;
                }
            }else{
                return false;
            }
        }catch(Exception exception){
            return false;
        }
    }
    @PostMapping("/api/user/logIn/{userName}/{password}")
    public Users getLogIn(@PathVariable String userName,@PathVariable String password) {
        try {
            Users us = UserService.findByUserName(userName);
            Encryption ency = new Encryption();
            if(ency.Validate(password, us.getPassword())) {
                return us;
            }else{
                return null;
            }
        }catch(Exception exception){
            return null;
        }
    }
    @PostMapping("/api/user/delete")
    public boolean deleteUser(@RequestBody ID id) {
        return UserService.deleteUser(id);
    }

    // list all Users
    @GetMapping("/api/user/list")
    public Iterable<Users> listUsers() {
        return UserService.allUsers();
    }
}

