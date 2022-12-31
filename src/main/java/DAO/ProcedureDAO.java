package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import models.chefModel;
import models.procedureModel;

public class ProcedureDAO {
	
	
	public  List<procedureModel> list(){
		List<procedureModel> procs= new ArrayList<procedureModel>();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "select * from processus";
			ResultSet rs = st.executeQuery(r);
			while (rs.next()) {
				procedureModel p = new procedureModel();
				p.setID_process(rs.getInt("ID_process"));
				p.setLabel(rs.getString("label"));
				p.setDescription(rs.getString("description"));
				p.setChefID(rs.getInt("id_Chef"));
				p.setState(rs.getInt("state"));
				ChefDAO cheff = new ChefDAO();
				chefModel chef = new chefModel();
				chef = cheff.getChefById(rs.getInt("id_Chef"));
				p.setChef(chef);
				procs.add(p);
			}
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
		return procs;
	}
	
	public void ajouter(procedureModel p) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "insert into processus(ID_process,label, description,id_Chef,state) values(null,'"+p.getLabel()+"','"+p.getDescription()+"','"+p.getChefID()+"','"+p.getState()+"')";
			st.execute(r);
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
	}
	
	public void supprimer(int id) {
		java.sql.Connection connect=SingletonConnection.getConnection();
		try (Statement st=connect.createStatement()){
			String requete = "delete from processus where ID_process='"+id+"'";
			st.execute(requete);
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
	}
	public List<procedureModel> getAllProcs(chefModel c) {
		List<procedureModel> procs= new ArrayList<procedureModel>();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "select * from processus where id_Chef='"+c.getID()+"'";
			ResultSet rs = st.executeQuery(requete);
			while (rs.next()) {
				procedureModel p = new procedureModel();
				p.setID_process(rs.getInt("ID_process"));
				p.setLabel(rs.getString("label"));
				p.setChefID(rs.getInt("id_Chef"));
				p.setDescription(rs.getString("description"));
				p.setState(rs.getInt("state"));
				procs.add(p);

			}
			conn.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return procs;
	}

}

