package com.example.demo.services.contract;

import com.example.demo.models.dto.RoleDto;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.entity.RoleEntity;
import com.example.demo.models.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity save(UserDto user);

    RoleEntity save(RoleDto role);

    void addRoleTo(String username, String role);

    Optional<UserEntity> get(String username);

    List<UserEntity> getUserList();
}
