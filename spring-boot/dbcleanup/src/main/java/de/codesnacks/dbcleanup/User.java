package de.codesnacks.dbcleanup;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String firstName;
	String lastName;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
