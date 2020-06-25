package de.codesnacks.dbcleanup;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(DbCleanUp.class)
@SpringBootTest
public class IntegrationTestA {

	@Autowired
	private UserService userService;

	@Test
	void saveUser() {
		userService.saveUser(new UserDTO("John", "Doe"));
		assertThat(userService.count()).isEqualTo(1);
	}
}
