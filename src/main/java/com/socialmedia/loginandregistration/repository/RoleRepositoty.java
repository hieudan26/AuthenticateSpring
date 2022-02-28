package com.socialmedia.loginandregistration.repository;

import com.socialmedia.loginandregistration.model.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositoty extends JpaRepository<RoleEntity,Integer> {
    Optional<RoleEntity> findByRoleName(String roleName);
}
