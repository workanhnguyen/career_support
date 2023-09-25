package com.nva.server.services;

import com.nva.server.pojos.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addNewUser(User user);
}
