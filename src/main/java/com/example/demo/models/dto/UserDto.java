package com.example.demo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String mail;
    private String username;
    private String password;
    private RoleDto role;
    private List<ProductDto> products;
}
