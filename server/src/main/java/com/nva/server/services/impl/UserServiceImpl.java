package com.nva.server.services.impl;

import com.nva.server.dtos.UserForAdminDTO;
import com.nva.server.dtos.UserForClientDTO;
import com.nva.server.pojos.User;
import com.nva.server.repositories.UserRepository;
import com.nva.server.services.ConfirmationTokenService;
import com.nva.server.services.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j // Create Logger
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConfirmationTokenService confirmationService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserForClientDTO findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        UserForClientDTO currentUser = modelMapper.map(user, UserForClientDTO.class);

        return currentUser;
    }

    @Override
    public List<UserForAdminDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserForAdminDTO> userForAdminDTOs = new ArrayList<>();

        users.forEach(u -> userForAdminDTOs.add(modelMapper.map(u, UserForAdminDTO.class)));
        return userForAdminDTOs;
    }

    @Override
    public void addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException("Email taken");

        userRepository.save(user);
    }
}
