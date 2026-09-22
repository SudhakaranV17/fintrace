package com.fintrace.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fintrace.user.model.User;

@Repository
public interface UserRepository {
    User save(User user);

    List<User> findAll();

    User findByName(String name);
}
