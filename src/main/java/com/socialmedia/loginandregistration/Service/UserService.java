package com.socialmedia.loginandregistration.Service;

import com.socialmedia.loginandregistration.model.Entity.RoleEntity;
import com.socialmedia.loginandregistration.model.Entity.UserEntity;

import java.util.List;


public interface UserService {
    UserEntity saveUser(UserEntity user);
    RoleEntity saveRole(RoleEntity role);
    void addRoleToUser(String email, String roleName);
    UserEntity getUser(String email);
    List<UserEntity> getUsers();
    Boolean existsByEmail(String email);
}
