package metier;

import java.util.List;

import DAO.CitoyenDAO;
import models.citoyenModel;

public class Citoyen {
	
	public List<citoyenModel> list(){
		CitoyenDAO c = new  CitoyenDAO();
		return c.list();
	}
	
	public  void ajouter(citoyenModel c) {
		CitoyenDAO citoyen = new  CitoyenDAO();
		citoyen.ajouter(c);
	}
	
	public void supprimer(citoyenModel c) {
		CitoyenDAO citoyen = new  CitoyenDAO();
		citoyen.supprimer(c);
	}
}
