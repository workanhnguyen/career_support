package com.nva.server.services;

import com.nva.server.dtos.UserForAdminDTO;
import com.nva.server.dtos.UserForClientDTO;
import com.nva.server.pojos.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserForClientDTO findByEmail(String email);
    Optional<User> findById(Long userId);
    <T> T convertToDTO(User user, Class<T> dtoClass);
    List<User> findAll();
    List<UserForAdminDTO> convertToAdminDTO(List<User> users);
    List<UserForClientDTO> convertToClientDTO(List<User> users);
    void addNewUser(User user);
    boolean updateUser(User user);
}
