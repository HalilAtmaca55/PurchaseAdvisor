package com.example.demo.models.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddRoleToUserRequest {
    private String username;
    private String role;
}