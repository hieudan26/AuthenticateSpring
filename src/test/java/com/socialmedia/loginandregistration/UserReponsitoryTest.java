package com.socialmedia.loginandregistration;

import com.socialmedia.loginandregistration.model.Entity.RoleEntity;
import com.socialmedia.loginandregistration.model.Entity.UserEntity;
import com.socialmedia.loginandregistration.repository.RoleRepositoty;
import com.socialmedia.loginandregistration.repository.UserRepository;
import com.socialmedia.loginandregistration.security.DTO.AppUserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserReponsitoryTest {
    @Autowired
    private TestEntityManager managerEntity;
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepositoty roleRepositoty;
    @Test
    public void testUserrepo(){
        UserEntity user =repository.findByEmail("hieudankaz@gmail.com").get();
        AppUserDetail x = AppUserDetail.build(user);
        for(RoleEntity role :user.getRoles())
        {
            System.out.println(role.getRoleName());
        }

    }

    @Test
    public void findByEmail(){

        UserEntity savedUser = repository.findByEmail("hieudankaz").get();
        System.out.print(savedUser);
    }

}
