package com.emil.cicd.service;

import java.util.List;

import com.emil.cicd.entity.User;
import com.emil.cicd.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String name) {
        return userRepository.save(new User(name));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
