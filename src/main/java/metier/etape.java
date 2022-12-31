package metier;

import java.util.List;

import DAO.EtapeDAO;
import models.etapeModel;

public class etape {
	
	public  List<etapeModel> list(){
		EtapeDAO et = new EtapeDAO();
		return et.list();
	}
	public void ajouter(etapeModel e) {
		EtapeDAO et = new EtapeDAO();
		et.ajouter(e);
	}

	public void supprimer(int id) {
		EtapeDAO et = new EtapeDAO();
		et.supprimer(id);
	}

	public List<etapeModel> getProcEtapes(int idProc){
		EtapeDAO et = new EtapeDAO();
		return et.getProcEtapes(idProc);
	}

	public List<etapeModel> getEmployeEtapes(int idEmploye){
		EtapeDAO et = new EtapeDAO();
		return et.getEmployeEtapes(idEmploye);
	}

}
