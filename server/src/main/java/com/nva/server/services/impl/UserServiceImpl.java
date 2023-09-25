package com.nva.server.services.impl;

import com.nva.server.pojos.User;
import com.nva.server.repositories.UserRepository;
import com.nva.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addNewUser(User user) {
        if (userRepository.findUserByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException("Email taken");
        userRepository.save(user);
    }
}
