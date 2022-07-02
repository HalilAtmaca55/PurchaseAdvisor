package com.example.demo;

import com.example.demo.models.dto.RoleDto;
import com.example.demo.models.dto.UserDto;
import com.example.demo.services.contract.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.save(UserDto.builder().username("test1").password("1234").build());

            userService.save(RoleDto.builder().name("ROLE_ADMIN").build());

            userService.save(UserDto.builder().username("jdoe").password("12234").build());

            userService.addRoleTo("jdoe", "ROLE_USER");
        };
    }

}
