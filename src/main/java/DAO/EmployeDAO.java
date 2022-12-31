package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import models.employeModel;

public class EmployeDAO {
	
	public static int ID= 0;
	public List<employeModel> list(){
		List<employeModel> employes= new ArrayList<employeModel>();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "select * from employe";
			ResultSet rs = st.executeQuery(r);
			while (rs.next()) {
				employeModel p = new employeModel();
				p.setID(rs.getInt("ID"));
				p.setNom(rs.getString("nom"));
				p.setPrenom(rs.getString("prenom"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				employes.add(p);
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return employes;
	}
	
	public void ajouter(employeModel e) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		Statement ps = null;
		Statement psUsers = null;
		try {
			
			String nom=e.getNom();
			String prenom =e.getPrenom();
			String username =e.getUsername();
			String password=e.getPassword();
			String status = e.getStatus();
			ps = conn.createStatement();
			ps.execute("INSERT INTO employe (ID,nom,prenom,username,password) VALUES (null,'"+nom+"','"+prenom+"','"+username+"','"+password+"')");			//ps.setInt(1, (Integer) null);
			//ps.setString(1,nom);
			//ps.setString(2,prenom);
			//ps.setString(3,username);
			//ps.setString(5,password);
			//ps.executeUpdate();	
			
			psUsers = conn.createStatement();
			psUsers.execute("INSERT INTO users (ID,nom,prenom,username,password,status) VALUES (null,'"+nom+"','"+prenom+"','"+username+"','"+password+"','"+status+"')");			//psUsers.setInt(1, (Integer) null);
			//psUsers.setString(1,nom);
			//psUsers.setString(2,prenom);
			//psUsers.setString(3,status);
			//psUsers.setString(4,username);
			//psUsers.setString(5,password);
			//ps.executeUpdate();	
		} catch (SQLException exception) {
			exception.printStackTrace();
		}finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	        } catch (SQLException e2) {
	        }
	    }
	}
	
	public void supprimer(int id) {
		java.sql.Connection connect=SingletonConnection.getConnection();
		try {
			Statement st = connect.createStatement();
			String requete = "delete from employe where ID='"+id+"'";
			st.execute(requete);
			
			//for users
			st.execute("delete from users where ID='"+id+"'");
			connect.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
