package com.emil.cicd.service;


import static org.junit.jupiter.api.Assertions.*;

import com.emil.cicd.entity.User;
import com.emil.cicd.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Arrays;

public class UserServiceTestUT {
    private UserRepository repo;
    private UserService service;
    private User user;

    @BeforeEach
    void setUp() {
        repo = Mockito.mock(UserRepository.class);
        service = new UserService(repo);
        user = new User("Alice");
    }

    @Test
    void testAddUser() {
        Mockito.when(repo.save(Mockito.any(User.class))).thenReturn(user);

        User saved = service.addUser("Alice");

        assertEquals("Alice", saved.getName());
    }

    @Test
    void testGetAllUsers() {
        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(user));

        List<User> users = service.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("Alice", users.get(0).getName());
    }

}
