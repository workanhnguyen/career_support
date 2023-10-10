package com.nva.server.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nva.server.dtos.UserForAdminDTO;
import com.nva.server.dtos.UserForClientDTO;
import com.nva.server.pojos.User;
import com.nva.server.repositories.UserRepository;
import com.nva.server.services.ConfirmationTokenService;
import com.nva.server.services.UserService;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public UserForClientDTO findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        UserForClientDTO currentUser = modelMapper.map(user, UserForClientDTO.class);

        return currentUser;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public <T> T convertToDTO(User user, Class<T> dtoClass) {
        if (dtoClass.isAssignableFrom(UserForAdminDTO.class)) {
            return (T) modelMapper.map(user, UserForAdminDTO.class);
        } else if (dtoClass.isAssignableFrom(UserForClientDTO.class)) {
            return (T) modelMapper.map(user, UserForClientDTO.class);
        }

        return (T) user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllByEmailNotLike("admin@gmail.com", Sort.by(Sort.Order.desc("createdAt")));
    }

    @Override
    public List<UserForClientDTO> convertToClientDTO(List<User> list) {
        return list.stream()
                .map(item -> modelMapper.map(item, UserForClientDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserForAdminDTO> convertToAdminDTO(List<User> list) {
        return list.stream()
                .map(item -> modelMapper.map(item, UserForAdminDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new IllegalStateException("Email taken");

        userRepository.save(user);
    }

    @Override
    public boolean updateUser(User user) {
        if (user.getAvatarFile() != null && !user.getAvatarFile().isEmpty()) {
            try {
                Map response = this.cloudinary.uploader().upload(user.getAvatarFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                user.setAvatar(response.get("secure_url").toString());

                userRepository.save(user);
                return true;
            } catch (IOException e) {
                log.error(e.getMessage());
                return false;
            }
        }
        userRepository.save(user);
        return true;
    }
}
