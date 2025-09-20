package com.emil.cicd.repository;

import com.emil.cicd.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // pornește doar JPA și încarcă H2 în memorie
class UserRepositoryIT {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void cleanDb() {
        userRepository.deleteAll(); // curăță baza înainte de fiecare test
    }

    @Test
    void testSaveAndFindAll() {
        // given
        User user = new User();
        user.setName("Alice");

        // when
        userRepository.save(user);
        List<User> users = userRepository.findAll();

        // then
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getName()).isEqualTo("Alice");
    }

    @Test
    void testAddMultipleUsers() {
        User user1 = new User();
        user1.setName("Bob");

        User user2 = new User();
        user2.setName("Charlie");

        userRepository.saveAll(List.of(user1, user2));

        List<User> users = userRepository.findAll();

        assertThat(users).hasSize(2);
        assertThat(users).extracting(User::getName)
                .containsExactlyInAnyOrder("Bob", "Charlie");
    }
}
