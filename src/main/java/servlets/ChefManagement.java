package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.chef;
import models.chefModel;



@WebServlet(name="cManagemnt",urlPatterns= {"/chefManagement"})
public class ChefManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ChefManagement() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		chef chef = new chef();
		List<chefModel> listChefs = chef.list();
        request.setAttribute( "chefs", listChefs );
		request.getRequestDispatcher("admin/chefsManagement.jsp").forward(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		 String nom = request.getParameter( "nom" );
	        String prenom = request.getParameter( "prenom" );
	        String username = request.getParameter( "username" );
	        String password = request.getParameter( "password" );
  
	        chefModel chef = new chefModel();
	        chef.setNom(nom);
	        chef.setPrenom(prenom);
	        chef.setUsername(username);
	        chef.setPassword(password);
	        chef.setStatus("chef");
	        
	        request.setAttribute( "chef", chef );
	        chef c= new chef();
	        
	        c.ajouter(chef);
	        chef chef2 = new chef();
	        List<chefModel> listChefs = chef2.list();
	        request.setAttribute( "chefs", listChefs ); 
			request.getRequestDispatcher("admin/chefsManagement.jsp").forward(request,response);
	}

}
