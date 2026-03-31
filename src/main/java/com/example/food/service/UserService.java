package com.example.food.service;

import org.springframework.stereotype.Service;

import com.example.food.model.User;
import com.example.food.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}