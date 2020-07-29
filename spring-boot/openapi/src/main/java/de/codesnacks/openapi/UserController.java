package de.codesnacks.openapi;

import de.codesnacks.openapi.client.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping(value = "/users/{username}")
	public User findUserByUsername(@PathVariable String username) {
		return User.builder()
				   .id(42L)
				   .firstName("John")
				   .username("john-doe")
				   .build();
	}
}
