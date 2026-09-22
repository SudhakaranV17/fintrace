package com.fintrace.user.mapper;

import org.mapstruct.Mapper;

import com.fintrace.shared.adapters.BaseMapper;
import com.fintrace.user.entity.UserEntity;
import com.fintrace.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserEntity> {

}
