package metier;

import java.util.List;

import DAO.ChefDAO;
import models.chefModel;
public class chef {
	
	public List<chefModel> list(){
		ChefDAO c = new  ChefDAO();
		return c.list();
	}
	
	public  void ajouter(chefModel c) {
		ChefDAO citoyen = new  ChefDAO();
		citoyen.ajouter(c);
	}
	
	public void supprimer(int c) {
		ChefDAO citoyen = new  ChefDAO();
		citoyen.supprimer(c);
	}
	
}
