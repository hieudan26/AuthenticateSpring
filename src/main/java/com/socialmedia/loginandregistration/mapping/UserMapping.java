package com.socialmedia.loginandregistration.mapping;

import com.socialmedia.loginandregistration.model.Entity.UserEntity;
import com.socialmedia.loginandregistration.model.payload.request.RegisterRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapping {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private RegisterRequest registerRequest;
    private UserEntity userEntity;

    public UserMapping(RegisterRequest registerRequest) {
        this.registerRequest = registerRequest;
        this.registerRequest.setPassword(passwordEncoder.encode(this.registerRequest.getPassword()));
    }

    public UserMapping(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        this.registerToEntity();
        return userEntity;
    }

    private void registerToEntity(){
        this.userEntity = new UserEntity();
        this.userEntity.setEmail(this.registerRequest.getEmail());
        this.userEntity.setPassword(this.registerRequest.getPassword());
        this.userEntity.setFirstName(this.registerRequest.getFirstName());
        this.userEntity.setLastName(this.registerRequest.getLastName());
        this.userEntity.setStatus("UnActive");
    }
}
