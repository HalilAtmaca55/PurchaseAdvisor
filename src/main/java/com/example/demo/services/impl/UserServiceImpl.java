package com.example.demo.services.impl;


import com.example.demo.data.RoleRepository;
import com.example.demo.data.UserRepository;
import com.example.demo.models.entity.Role;
import com.example.demo.models.entity.User;
import com.example.demo.services.contract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addRoleTo(String username, String roleName) {
        User user = userRepository.findByUserName(username);
        Role role = roleRepository.findByName(roleName);
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public User get(String username) {
        return userRepository.findByUserName(username);
    }

}
