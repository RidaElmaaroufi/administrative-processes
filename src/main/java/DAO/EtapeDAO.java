package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.etape;
import models.etapeModel;

public class EtapeDAO {
	
	
	public  List<etapeModel> list(){
		List<etapeModel> etapes= new ArrayList<etapeModel>();
		java.sql.Connection con=SingletonConnection.getConnection();
		try (Statement st1 = con.createStatement()){
			String r = "select * from etape";
			ResultSet rs = st1.executeQuery(r);
			while (rs.next()) {
				etapeModel etape = new etapeModel();
				etape.setID(rs.getInt("ID_etape"));
				etape.setLabel(rs.getString("label"));
				etape.setDescription(rs.getString("description"));
				etape.setID_employe(rs.getInt("ID_employe"));
				etape.setID_process(rs.getInt("ID_process"));
				etape.setState(rs.getInt("state"));

				etapes.add(etape);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return etapes;
	}
	
	public void ajouter(etapeModel et) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try (Statement st2 = conn.createStatement();){
			String r = "insert into etape(ID_etape, label, ID_process, description, ID_employe, state) values(null,'"+et.getLabel()+"','"+et.getID_process()+"','"+et.getDescription()+"','"+et.getID_employe()+"','"+et.getState()+"')";
			st2.execute(r);
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(" adding error");
			}
		}
	}
	
	public void supprimer(int id) {
		java.sql.Connection connect=SingletonConnection.getConnection();
		try (Statement st3 = connect.createStatement()){
			String requete = "delete from etape where ID_etape='"+id+"'";
			st3.execute(requete);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				System.out.println("delete error");
			}
		}
	}
	
	public List<etapeModel> getProcEtapes(int idProc){
		List<etapeModel> etapes= new ArrayList<etapeModel>();
		java.sql.Connection connecti=SingletonConnection.getConnection();
		try (Statement st4 = connecti.createStatement()){
			String r = "select * from etape where ID_process='"+idProc+"'";
			ResultSet rs = st4.executeQuery(r);
			while (rs.next()) {
				etapeModel etape = new etapeModel();
				etape.setID(rs.getInt("ID_etape"));
				etape.setLabel(rs.getString("label"));
				etape.setDescription(rs.getString("description"));
				etape.setID_employe(rs.getInt("ID_employe"));
				etape.setState(rs.getInt("state"));
				etapes.add(etape);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return etapes;
	}
	
	public List<etapeModel> getEmployeEtapes(int idEmploye){
		List<etapeModel> etapes= new ArrayList<etapeModel>();
		java.sql.Connection connecti=SingletonConnection.getConnection();
		try (Statement st4 = connecti.createStatement()){
			String r = "select * from etape where ID_process='"+idEmploye+"'";
			ResultSet rs = st4.executeQuery(r);
			while (rs.next()) {
				etapeModel etape = new etapeModel();
				etape.setID(rs.getInt("ID_etape"));
				etape.setLabel(rs.getString("label"));
				etape.setDescription(rs.getString("description"));
				etape.setID_process(rs.getInt("ID_process"));
				etape.setState(rs.getInt("state"));
				etapes.add(etape);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return etapes;
	}

}
