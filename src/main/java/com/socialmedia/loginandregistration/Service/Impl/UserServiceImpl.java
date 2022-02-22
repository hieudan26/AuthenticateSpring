package com.socialmedia.loginandregistration.Service.Impl;

import com.socialmedia.loginandregistration.Service.UserService;
import com.socialmedia.loginandregistration.model.Entity.RoleEntity;
import com.socialmedia.loginandregistration.model.Entity.UserEntity;
import com.socialmedia.loginandregistration.repository.RoleRepositoty;
import com.socialmedia.loginandregistration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final RoleRepositoty roleRepository;
    @Override
    public UserEntity saveUser(UserEntity user) {

        log.info("Saving user {} to database",user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        log.info("Saving Role {} to database",role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding Role {} to user {}", roleName, email);
        Optional<RoleEntity> role = roleRepository.findByRoleName(roleName);
        Optional<UserEntity> user = userRepository.findByEmail(email);

        if(user.get().getRoles() == null){
            Set<RoleEntity> roleEntitySet = new HashSet<>();
            roleEntitySet.add(role.get());
            user.get().setRoles(roleEntitySet);
        }
        else{
            user.get().getRoles().add(role.get());
        }


        if (user.get().getRoles() == null) {
            Set<RoleEntity> roleEntitySet = new HashSet<>();
            roleEntitySet.add(role.get());
            user.get().setRoles(roleEntitySet);
        }
    }

    @Override
    public UserEntity getUser(String email) {
        log.info("Fetching user {}",email);
        return userRepository.findByEmail(email).get();
    }

    @Override
    public List<UserEntity> getUsers() {
        log.info("Fetching all users ");
        return userRepository.findAll();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
