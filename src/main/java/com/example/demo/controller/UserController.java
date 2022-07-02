package com.example.demo.controller;

import com.example.demo.models.dto.UserDto;
import com.example.demo.models.entity.UserEntity;
import com.example.demo.models.request.AddRoleToUserRequest;
import com.example.demo.services.contract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Transactional
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity save(@RequestBody UserDto user) {
        return userService.save(user);
    }

    @PutMapping
    public void addRoles(@RequestBody AddRoleToUserRequest request) {
        userService.addRoleTo(request.getUsername(), request.getRole());
    }

    @GetMapping
    public List<UserEntity> userList(){
        return userService.getUserList();
    }

}
