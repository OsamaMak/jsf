package org.studyeasy.jsf.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public Connection getConnection() {
		Connection connect = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/studyeasy_db?useSSL=false", "chaand", "studyeasy");
			connect.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;

	}
	public List<User> listUsers(){
		List<User> list = new ArrayList<>();
		cn = getConnection();
		try {
			String query = "select * from users";
			st = cn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				int users_id = rs.getInt("users_id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				list.add(new User(users_id, username, email));				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
		
	}
	public void addUser(User user) {
		Connection cn = getConnection();
		PreparedStatement ps = null;
		String query = "insert into users (username, email) values (?,?)";
		try {
			ps = cn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}









