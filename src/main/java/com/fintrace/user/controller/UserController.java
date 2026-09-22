package com.fintrace.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintrace.user.model.User;
import com.fintrace.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // the qualifier is used to tell which service to be used
    public UserController(@Qualifier("UserService/v1") UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user.getName(), user.getEmail());
        return ResponseEntity.ok(createdUser);
    }
}
