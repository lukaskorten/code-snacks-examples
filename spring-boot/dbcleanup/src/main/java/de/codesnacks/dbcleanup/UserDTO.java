package de.codesnacks.dbcleanup;

import lombok.Data;

@Data
public class UserDTO {
	Long id;
	String firstName;
	String lastName;

	public UserDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
