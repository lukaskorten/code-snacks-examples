package de.codesnacks.dbcleanup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DbCleanUpService {

	UserRepository userRepository;

	void cleanUp() {
		userRepository.deleteAll();
	}
}
