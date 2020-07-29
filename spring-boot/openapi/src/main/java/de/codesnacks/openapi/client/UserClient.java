package de.codesnacks.openapi.client;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserClient {

	RestTemplate restTemplate;

	public User findByUsername(String username) {
		return restTemplate.getForEntity("/users/{username}", User.class, username).getBody();
	}

}
