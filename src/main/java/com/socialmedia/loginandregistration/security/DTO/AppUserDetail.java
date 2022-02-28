package com.socialmedia.loginandregistration.security.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.socialmedia.loginandregistration.common.AppUserRole;
import com.socialmedia.loginandregistration.model.Entity.RoleEntity;
import com.socialmedia.loginandregistration.model.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AppUserDetail implements UserDetails {
    private Integer id;
    private String email;

    @JsonIgnore
    private String password;

    private String firstName;
    private String lastName;

    private Set<String> roleName;
    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    public AppUserDetail(Integer id, String email, String password, String firstName, String lastName, Set<String> roleName,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleName = roleName;
        this.authorities = authorities;
    }

    public static AppUserDetail build(UserEntity user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<String> roleNames = new HashSet<>();

        for(RoleEntity role : user.getRoles()){
            roleNames.add(role.getRoleName());
            for(AppUserRole item : AppUserRole.values()){
                if(role.getRoleName().equals(item.name())){
                    authorities.addAll(item.getGrantedAuthorities());
                }
            }
        }

        return new AppUserDetail(
                user.getUserId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                roleNames,
                authorities);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<String> getRoleName() {
        return roleName;
    }

    public void setRoleName(Set<String> roleName) {
        this.roleName = roleName;
    }

}
