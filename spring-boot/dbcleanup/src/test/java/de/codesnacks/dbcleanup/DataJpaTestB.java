package de.codesnacks.dbcleanup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DataJpaTestB {

	@Autowired
	UserRepository userRepository;


	@Test
	void saveUser() {
		userRepository.save(new User("John", "Doe"));
		assertThat(userRepository.findAll()).hasSize(1);
	}
}
