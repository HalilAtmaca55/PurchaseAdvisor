package com.example.demo.data;

import com.example.demo.models.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
}
