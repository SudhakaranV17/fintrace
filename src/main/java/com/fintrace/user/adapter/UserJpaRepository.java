package com.fintrace.user.adapter;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fintrace.user.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String name);
}
