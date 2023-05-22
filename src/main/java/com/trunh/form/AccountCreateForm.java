package com.trunh.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AccountCreateForm {
	@NotBlank(message = "Username can not be null")
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
}
