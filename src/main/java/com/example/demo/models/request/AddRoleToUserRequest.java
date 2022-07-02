package com.example.demo.models.request;

import lombok.Data;

@Data
public class AddRoleToUserRequest {
    private String username;
    private String role;
}