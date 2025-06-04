package org.rtbdd.repository;

import org.junit.jupiter.api.Test;
import org.rtbdd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    void baseTest() {
        User user = new User();
        user.setUsername("123");
        user.setPassword_hash("asdfasdf");
        user.setEmail("12345@gmail.com");
        User insertedUser = userRepository.save(user);

        assertThat(insertedUser).isEqualTo(user);
    }

}