package models;


public class chefModel {
	private int ID;
	private String nom;
	private String prenom;
	private String status;
	private String username;
	private String password;
	
	public chefModel() {
		
	}
	public chefModel(int id, String nom, String prenom, String status, String username, String pwd) {
		this.ID= id;
		this.nom= nom;
		this.prenom= prenom;
		this.status = status;
		this.username= username;
		this.password= pwd;
	}
	public chefModel(String nom, String prenom, String status, String username, String pwd) {
		this.nom= nom;
		this.prenom= prenom;
		this.status=status;
		this.username= username;
		this.password= pwd;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*public static List<chef> list(){
		List<chef> chefs= new ArrayList<chef>();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "select * from chefservice";
			ResultSet rs = st.executeQuery(r);
			while (rs.next()) {
				chef c = new chef();
				c.setID(rs.getInt("ID"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("Prenom"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				chefs.add(c);
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return chefs;
	}
	
	public void ajouter() {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String r = "insert into chefservice values(null,'"+this.nom+"','"+this.prenom+"','"+this.status+"','"+this.username+"','"+this.password+"')";
			String user = "insert into users values(null,'"+this.nom+"','"+this.prenom+"','"+this.status+"','"+this.username+"','"+this.password+"')";
			st.execute(r);
			st.execute(user);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void supprimer() {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "delete from chefservice where ID='"+this.ID+"'";
			st.execute(requete);
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void affecterProc(procedure proc) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "update processus set ID='"+this.ID+"' where ID_process='"+proc.getID()+"'";
			st.execute(requete);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<procedure> getAllProcs() {
		List<procedure> procs= new ArrayList<procedure>();
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "select * from processus where ID='"+this.ID+"'";
			ResultSet rs = st.executeQuery(requete);
			while (rs.next()) {
				procedure p = new procedure();
				p.setID(rs.getInt("ID_process"));
				p.setLabel(rs.getString("label"));
				procs.add(p);
			}
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return procs;
	}
	
	public int getID() {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "select * from chefservice where username='"+this.username+"'";
			ResultSet rs = st.executeQuery(requete);
			if (rs.next()!=false) {
				this.ID = rs.getInt("ID");
			}
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.ID;
	}
	public int getStatus() {
		java.sql.Connection conn=SingletonConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			String requete = "select * from chefservice where ID='"+this.ID+"'";
			ResultSet rs = st.executeQuery(requete);
			if (rs.next()!=false) {
				this.setStatus(rs.getString("status"));
			}
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.ID;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public chef getChefById(int ID) {
		java.sql.Connection conn=SingletonConnection.getConnection();
		chef c = new chef();
		try {
			Statement st = conn.createStatement();
			String requete = "select * from chefservice where ID='"+ID+"'";
			ResultSet rs = st.executeQuery(requete);
			 while(rs.next()) {
				c.setID(rs.getInt("ID"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setStatus(rs.getString("status"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
			}
		} 
		catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return c;

	}*/
}
