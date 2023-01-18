package org.studyeasy.jsf;

import javax.faces.bean.ManagedBean;

/*
 * 1. Add @ManagedBean for the class
 * 2. Public getters and setters
 * 3. no args constructor
 */

@ManagedBean
public class LoginUser {
	private String email;
	private String password;
	
	
	public LoginUser() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return "password is hidden";
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
