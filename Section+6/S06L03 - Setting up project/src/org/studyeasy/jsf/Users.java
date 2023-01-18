package org.studyeasy.jsf;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Users {
    List<User> usersList = new ArrayList<>();
	public Users() {
		usersList.add(new User(1, "username", "email"));
    	usersList.add(new User(2, "username2", "email2"));
    }
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> users) {
		this.usersList = users;
	}
	
	
    

}
