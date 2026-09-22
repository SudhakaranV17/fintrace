package com.fintrace.user.service;

import java.util.List;

import com.fintrace.user.model.User;

public interface UserService {
    List<User> getUser();

    User createUser(String name, String email);
}
