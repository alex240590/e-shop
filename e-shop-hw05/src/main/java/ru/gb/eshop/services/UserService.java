package ru.gb.eshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.eshop.repo.RoleRepository;
import ru.gb.eshop.repo.UserRepository;
import ru.gb.eshop.entities.SystemUser;
import ru.gb.eshop.entities.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repo;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository (UserRepository repo){
        this.repo = repo;
    }
    @Autowired
    public void setRoleRepository (RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }
    @Autowired
    public void setPasswordEncoder (PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll(){
        return repo.findAll();
    }

    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }


    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    @Transactional
    public boolean addUser(SystemUser systemUser) {
        User user = new User();

        if (repo.findByUsername(systemUser.getUsername()).isPresent()) {
            return false;
        }

        user.setUsername(systemUser.getUsername());
        user.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        user.setFirstName(systemUser.getFirstName());
        user.setLastName(systemUser.getLastName());
        user.setEmail(systemUser.getEmail());

        if(systemUser.getRoles() != null){
            //new company user
            user.setRoles(systemUser.getRoles());
        } else{
            //new client
            user.setRoles(Collections.singletonList(roleRepository.findByName("ROLE_CLIENT")));

        }

        repo.save(user);
        return true;
    }

    @Transactional
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}