package com.keshavaram.InsuranceManagementSystem.domain;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String username;
	@Column
	private String password;

	private static User user;

	private User(){}

	public static User getUserInstance() {
		if (user == null) user = new User();
		return user;
	}

	public static User cloneUser(User u) {
		user.setUsername(u.getUsername());
		user.setPassword(u.getPassword());
		return user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
