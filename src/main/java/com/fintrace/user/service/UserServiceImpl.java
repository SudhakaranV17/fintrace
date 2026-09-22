package com.fintrace.user.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.fintrace.user.model.User;
import com.fintrace.user.repository.UserRepository;

@Service("UserService/v1")
@Primary
@Profile("dev") // used to define the environment when the service to be run
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    };

    @Override
    public User createUser(String name, String email) {
        User user = User.createUser(name, email);
        return userRepository.save(user);
    }
}
