package com.example.demo.services.contract;

import com.example.demo.models.entity.User;

public interface UserService {

    User save(User user);

    void addRoleTo(String username, String role);

    User get(String username);

}
