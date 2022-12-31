package metier;

import java.util.List;

import DAO.ProcedureDAO;
import models.chefModel;
import models.procedureModel;

public class procedure {
	public List<procedureModel> list(){
		ProcedureDAO c = new  ProcedureDAO();
		return c.list();
	}
	
	public  void ajouter(procedureModel c) {
		ProcedureDAO p = new  ProcedureDAO();
		p.ajouter(c);
	}
	
	public void supprimer(int c) {
		ProcedureDAO p = new  ProcedureDAO();
		p.supprimer(c);
	}
	
	public List<procedureModel> getAllProcs(chefModel c) {
		ProcedureDAO p = new ProcedureDAO();
		List<procedureModel> getProcByChef = p.getAllProcs(c);
		return getProcByChef;
	}

}
