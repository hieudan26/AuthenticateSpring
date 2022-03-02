package com.socialmedia.loginandregistration;

import com.socialmedia.loginandregistration.Service.UserService;
import com.socialmedia.loginandregistration.model.Entity.Role;
import com.socialmedia.loginandregistration.model.Entity.User;
import com.socialmedia.loginandregistration.repository.UserRepository;
import com.socialmedia.loginandregistration.security.DTO.AppUserDetail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
@Rollback(value = false)

public class UserReponsitoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
    public void aVoid(){

        User a = userRepository.findByUsername("hieudankaz").get();
    }


}
