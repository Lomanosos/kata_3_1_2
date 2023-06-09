package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getListUsers(){
        return userRepository.findAll();
    }
    public User getById(Long id) {
        return userRepository.getOne(id);
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    public void edit(User user) {
        userRepository.save(user);
    }

}
