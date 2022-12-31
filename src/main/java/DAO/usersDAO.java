package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.User;
import metier.SingletonConnection;

public class usersDAO {
	
	public User connect(User u) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "select * from users where username='"+u.getUsername()+"'";
			ResultSet rs = st.executeQuery(r);
			if(rs.next()==false) {
				return null;
			}
			else {
				if(rs.getString("password").equals(u.getPassword())) {
					User user = new User();
					user.setID(rs.getInt("ID"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setStatus(rs.getString("status"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					
					return user;
				}
				else {
					return null;
				}
			}
		} catch (SQLException exception) {
			System.out.println("befre");
			System.out.println(exception.getMessage());
			System.out.println("aftr");
		}
		return null;
	}
}