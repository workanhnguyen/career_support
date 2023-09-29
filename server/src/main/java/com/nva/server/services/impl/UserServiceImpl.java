package com.nva.server.services.impl;

import com.nva.server.dtos.UserForAdminDTO;
import com.nva.server.dtos.UserForClientDTO;
import com.nva.server.pojos.User;
import com.nva.server.repositories.UserRepository;
import com.nva.server.services.ConfirmationTokenService;
import com.nva.server.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j // Create Logger
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationTokenService confirmationService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserForClientDTO findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        UserForClientDTO currentUser = modelMapper.map(user, UserForClientDTO.class);

        return currentUser;
    }

    @Override
    public List<UserForAdminDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserForAdminDTO> userForAdminDTOS = new ArrayList<>();

        users.forEach(u -> {
            UserForAdminDTO user = modelMapper.map(u, UserForAdminDTO.class);
            userForAdminDTOS.add(user);
        });
        return userForAdminDTOS;
    }

    @Override
    public void addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException("Email taken");

        userRepository.save(user);

//        // TODO: Create confirmation token
//         String token = UUID.randomUUID().toString();
//        ConfirmationToken confirmationToken = ConfirmationToken.builder()
//                .token(token)
//                .createdAt(LocalDateTime.now())
//                .expiredAt(LocalDateTime.now().plusMinutes(15))
//                .user(user).build();
//        confirmationService.saveConfirmationToken(confirmationToken);

//         TODO: Send email
    }
}
