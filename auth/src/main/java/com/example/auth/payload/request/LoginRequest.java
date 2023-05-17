package com.example.auth.payload.request;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotBlank;
@CrossOrigin(origins = "*")
public class LoginRequest {
	@NotBlank
  private String username;

	@NotBlank
	private String password;

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
