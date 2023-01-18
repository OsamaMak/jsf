package org.studyeasy.jsf;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="usersBean")
public class UsersBean {
    List<User> usersList = new ArrayList<>();
	public UsersBean() {
		usersList = new DBHelper().listUsers();
    }
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> users) {
		this.usersList = users;
	}
	
	
    

}
