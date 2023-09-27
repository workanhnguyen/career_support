package com.nva.server.services;

import com.nva.server.dtos.UserForAdminDTO;
import com.nva.server.dtos.UserForClientDTO;
import com.nva.server.pojos.User;

import java.util.List;

public interface UserService {
    UserForClientDTO findByEmail(String email);
    List<UserForAdminDTO> getUsers();
    void addNewUser(User user);
}
