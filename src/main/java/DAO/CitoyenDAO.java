package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import models.citoyenModel;

public class CitoyenDAO {
	
	public CitoyenDAO() {
		super();
	}
	
	public List<citoyenModel> list(){
		List<citoyenModel> citoyens= new ArrayList<citoyenModel>();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "select * from citoyen";
			ResultSet rs = st.executeQuery(r);
			while (rs.next()) {
				citoyenModel c = new citoyenModel();
				c.setID(rs.getInt("ID"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				citoyens.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return citoyens;
	}
	
	public  void ajouter(citoyenModel c) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		PreparedStatement ps = null;
		PreparedStatement psUsers = null;

		try {
			
			int id = c.getID();
			String nom=c.getNom();
			String prenom =c.getPrenom();
			String status=c.getStatus();
			String username =c.getUsername();
			String password=c.getPassword();
			ps=conn.prepareStatement( "INSERT INTO citoyen (ID,nom,prenom,username,password) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,nom);
			ps.setString(3,prenom);
			ps.setString(4,username);
			ps.setString(5,password);
			ps.executeUpdate();	
			
			psUsers =conn.prepareStatement( "INSERT INTO users (ID,nom,prenom,status,username,password) VALUES (?,?,?,?,?,?)");
			psUsers.setInt(1, id);
			psUsers.setString(2,nom);
			psUsers.setString(3,prenom);
			psUsers.setString(4,status);
			psUsers.setString(5,username);
			psUsers.setString(6,password);
			ChefDAO.id++;
			psUsers.executeUpdate();	
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void supprimer(citoyenModel c) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "delete from citoyen where ID='"+c.getID()+"'";
			st.execute(requete);
			//delete from users
			st.execute("delete from users where ID='"+c.getID()+"'");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
