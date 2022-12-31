package models;

public class etapeModel {
	int ID;
	String label;
	String description;
	int state;
	int ID_process;
	int ID_employe;
	int Numero;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getID_process() {
		return ID_process;
	}
	public void setID_process(int iD_process) {
		ID_process = iD_process;
	}
	public int getID_employe() {
		return ID_employe;
	}
	public void setID_employe(int iD_employe) {
		ID_employe = iD_employe;
	}
	public int getNumero() {
		return Numero;
	}
	public void setNumero(int numero) {
		Numero = numero;
	}
	
	
}
