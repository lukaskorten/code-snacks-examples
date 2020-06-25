package de.codesnacks.dbcleanup;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

	UserRepository userRepository;

	public void saveUser(UserDTO user) {
		userRepository.save(toEntity(user));
	}

	public Long count() {
		return userRepository.count();
	}

	private User toEntity(UserDTO user) {
		return new User(user.getFirstName(), user.getLastName());
	}

}
