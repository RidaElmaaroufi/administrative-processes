package metier;

import java.util.List;

import DAO.EmployeDAO;
import models.employeModel;

public class employe {
	public List<employeModel> list(){
		EmployeDAO c = new  EmployeDAO();
		return c.list();
	}
	
	public  void ajouter(employeModel c) {
		EmployeDAO citoyen = new  EmployeDAO();
		citoyen.ajouter(c);
	}
	
	public void supprimer(employeModel c) {
		EmployeDAO employe = new  EmployeDAO();
		employe.supprimer(c.getID());
	}
	
}
