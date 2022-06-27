package com.example.demo.controller.contract;

import com.example.demo.models.entity.User;
import com.example.demo.services.contract.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public void addRoles(@RequestBody AddRoleToUserRequest request) {
        userService.addRoleTo(request.getUsername(), request.getRole());
    }

    @Data
     class AddRoleToUserRequest {
        private String username;
        private String role;
    }

}
