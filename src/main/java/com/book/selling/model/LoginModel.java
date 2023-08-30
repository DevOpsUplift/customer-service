package com.book.selling.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {

	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	String password;

	public LoginModel() {
	}

	public LoginModel(@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
			@NotNull(message = "Password cannot be null") @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
