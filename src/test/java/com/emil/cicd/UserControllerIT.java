package com.emil.cicd;

import com.emil.cicd.entity.User;
import com.emil.cicd.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UserControllerIT {

	@Autowired
	private UserService userService;

	@Test
	void testAddAndRetrieveUsers() {
		userService.addUser("Charlie");
		userService.addUser("Dave");

		List<User> users = userService.getAllUsers();
		assertThat(users).extracting(User::getName).contains("Charlie", "Dave");
	}



}
