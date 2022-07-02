package com.example.demo.services.impl;


import com.example.demo.data.RoleRepository;
import com.example.demo.data.UserRepository;
import com.example.demo.models.dto.RoleDto;
import com.example.demo.models.dto.UserDto;
import com.example.demo.models.entity.RoleEntity;
import com.example.demo.models.entity.UserEntity;
import com.example.demo.services.contract.UserService;
import com.example.demo.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.build.Plugin;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserEntity save(UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(userMapper.toUserEntity(user));
    }

    @Override
    public RoleEntity save(RoleDto role) {
        return roleRepository.save(userMapper.toRoleEntity(role));
    }

    public List<UserEntity> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public void addRoleTo(String username, String roleName) {
        UserEntity user = userRepository.findByUserName(username);
        RoleEntity role = roleRepository.findByName(roleName);
        user.setRole(role);
        userRepository.save(user);
    }

    public Optional<UserEntity> get(String username) {
        return Optional.ofNullable(userRepository.findByUserName(username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("username not found");
            }
        List<SimpleGrantedAuthority> authority = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));

        return new User(user.getUserName(), user.getPassword(), authority);

    }
}
