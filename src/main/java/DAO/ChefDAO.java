package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import models.chefModel;
import models.procedureModel;

public class ChefDAO {
	
	public static int id=2;
	
	public ChefDAO() {
		super();
	}
	
	public List<chefModel> list(){
		List<chefModel> chefs= new ArrayList<chefModel>();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "select * from chefservice";
			ResultSet rs = st.executeQuery(r);
			while (rs.next()) {
				chefModel c = new chefModel();
				c.setID(rs.getInt("ID"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				chefs.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return chefs;
	}
	
	public  void ajouter(chefModel c) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		Statement ps = null;
		Statement psUsers = null;

		try {
			//int id = c.getID();
			String nom=c.getNom();
			String prenom =c.getPrenom();
			String status=c.getStatus();
			String username =c.getUsername();
			String password=c.getPassword();
			ps = conn.createStatement();
			ps.execute("INSERT INTO chefservice (ID,nom,prenom,username,password) VALUES (null,'"+nom+"','"+prenom+"','"+username+"','"+password+"')");
			//ps=conn.prepareStatement( "INSERT INTO chefservice (ID,nom,prenom,username,password) VALUES (null,?,?,?,?,?)");
			//ps.setInt(1, id);
			//ps.setString(2,nom);
			//ps.setString(3,prenom);
			//ps.setString(4,username);
			//ps.setString(5,password);
			//ps.executeUpdate();	
			
			psUsers = conn.createStatement();
			psUsers.execute("INSERT INTO users (ID,nom,prenom,username,password,status) VALUES (null,'"+nom+"','"+prenom+"','"+username+"','"+password+"','"+status+"')");
			//psUsers.setInt(1, id);
			//psUsers.setString(2,nom);
			//psUsers.setString(3,prenom);
			//psUsers.setString(4,status);
			//psUsers.setString(5,username);
			//psUsers.setString(6,password);
			//ChefDAO.id++;
			//psUsers.executeUpdate();	
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void supprimer(int chef) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "delete from chefservice where ID='"+chef+"'";
			st.execute(requete);
			//delete from users
			st.execute("delete from users where ID='"+chef+"'");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void affecterProc(chefModel chf  ,procedureModel proc) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "update processus set id_Chef='"+chf.getID()+"' where ID_process='"+proc.getID_process()+"'";
			st.execute(requete);
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public chefModel getChefById(int id) {
		chefModel chefs= new chefModel();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "select * from chefservice where ID='"+id+"'";
			ResultSet rs = st.executeQuery(r);
			if(rs.next()) {
				chefs.setID(rs.getInt("ID"));
				chefs.setNom(rs.getString("nom"));
				chefs.setPrenom(rs.getString("Prenom"));
				chefs.setUsername(rs.getString("username"));
				chefs.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return chefs;
	}
	
	

}
