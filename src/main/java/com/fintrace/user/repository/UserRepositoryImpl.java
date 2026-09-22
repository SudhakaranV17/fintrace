package com.fintrace.user.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.fintrace.user.adapter.UserJpaRepository;
import com.fintrace.user.entity.UserEntity;
import com.fintrace.user.mapper.UserMapper;
import com.fintrace.user.model.User;

@Repository
@Primary
@Profile("dev") // used to define the environment when the service to be run
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository, UserMapper userMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.mapToEntity(user);
        UserEntity savedUserEntity = userJpaRepository.save(userEntity);
        return userMapper.mapToDomain(savedUserEntity);
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll()
                .stream()
                .map(userMapper::mapToDomain)
                .toList();
    }

    @Override
    public User findByName(String name) {
        return userJpaRepository.findByName(name)
                .map(userMapper::mapToDomain)
                .orElse(null);
    }
}
