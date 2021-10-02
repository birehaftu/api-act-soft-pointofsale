package edu.act.apiactsoftpointofsale.services;

import edu.act.apiactsoftpointofsale.domains.ID;
import edu.act.apiactsoftpointofsale.repositories.UserRepository;
import edu.act.apiactsoftpointofsale.domains.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public boolean createUser(Users User) {

        try {
            Encryption ecn = new Encryption();
            String rowpass=User.getPassword();
            User.setPassword(ecn.EcryptPassword(rowpass));
            UserRepository.save(User);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean updateUser(Users User) {
        try {
            String id = User.getUserName();
            Users myUser = UserRepository.findByUserName(id);
            myUser.setEmail(User.getEmail());
            myUser.setUserName(User.getUserName());
            myUser.setFullName(User.getFullName());
            if(!User.getPassword().isEmpty()) {
                Encryption ecn = new Encryption();
                String rowpass=User.getPassword();
                myUser.setPassword(ecn.EcryptPassword(rowpass));
            }
            myUser.setPhone(User.getPhone());
            myUser.setRole(User.getRole());
            myUser.setStatus(myUser.getStatus());
            UserRepository.save(myUser);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Users getUser(ID id) {
        try {
            return UserRepository.findById(id.getId()).get();
        } catch (Exception ex) {
            return null;
        }
    }public Users findByUserName(String UserName) {
        try {
            return UserRepository.findByUserName(UserName);
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean deleteUser(ID id) {
        try {
            UserRepository.deleteById(id.getId());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Iterable<Users> allUsers() {
        return UserRepository.findAll();
    }
}
