package org.studyeasy.jsf.beans;

import javax.faces.bean.ManagedBean;

import org.studyeasy.jsf.model.DBHelper;
import org.studyeasy.jsf.model.User;



@ManagedBean(name="usersOpt")
public class UsersOperations {
    String username,email;
    
	public UsersOperations() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String addUser() {
		// System.out.println(username);
		// System.out.println(email);
		User user = new User(username, email);
		new DBHelper().addUser(user);
		return "index";
	}
	public String updateUser() {
		return "index";
	}
	public void loadUserData(int users_id) {
		User user = new DBHelper().getUser(users_id);
		setUsername(user.getUsername());
		setEmail(user.getEmail());
	}
	
	
}
