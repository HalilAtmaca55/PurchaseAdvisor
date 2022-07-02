package com.example.demo.services.mapper;

import com.example.demo.models.dto.RoleDto;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.entity.RoleEntity;
import com.example.demo.models.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

	UserEntity toUserEntity(UserDto user);

	RoleEntity toRoleEntity(RoleDto role);
}
