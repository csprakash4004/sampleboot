package org.prakash.sample22.smaple22.names;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter
	@Setter
	private long id;

	@Column(name = "name")
	@Getter
	@Setter
	@NotBlank(message = "Name connot be null")
	private String name;

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name=" + name + '}';

	}

}
