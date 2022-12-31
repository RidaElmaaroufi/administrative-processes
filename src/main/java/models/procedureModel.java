package models;

import java.util.ArrayList;
import java.util.List;

import metier.procedure;

public class procedureModel {
	
	private int ID_process;
	private String label;
	private int chefID;
	private String description;
	private chefModel chef;
	private int state;// 0(none) or 1(en cours) Or 2(terminée)
	private List<etapeModel> etapes;
	public chefModel getChef() {
		return chef;
	}

	public void setChef(chefModel chef) {
		this.chef = chef;
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

	public List<etapeModel> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<etapeModel> etapes) {
		this.etapes = etapes;
	}
	public int getChefID() {
		return chefID;
	}

	public void setChefID(int chefID) {
		this.chefID = chefID;
	}	
	
	
	public int getID_process() {
		return ID_process;
	}

	public void setID_process(int iD_process) {
		ID_process = iD_process;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	
	
	procedure procedure = new procedure();
	
	List<procedure> procedures = new ArrayList<procedure>();
	
	
	public List<procedure> getProcedurs(){
		return procedures;
	}
	
	public void setprocedures(List<procedure> procedure) {
		this.procedures = procedure;
	}
	
	public procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(procedure procedure) {
		this.procedure = procedure;
	}

}
