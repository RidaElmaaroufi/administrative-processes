package metier;

public class Admin {
	
	private int ID;
	private String Nom;
	private String Prenom;
	private String username;
	private String passwprd;
	private String status;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getUsrename() {
		return username;
	}
	public void setUsrename(String username) {
		this.username = username;
	}
	public String getPasswprd() {
		return passwprd;
	}
	public void setPasswprd(String passwprd) {
		this.passwprd = passwprd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
