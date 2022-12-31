package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.employe;
import models.employeModel;


/**
 * Servlet implementation class EmployeManagement
 */
@WebServlet(name="EMPManagemnt",urlPatterns= {"/employeManagement"})
public class EmployeManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeManagement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employe e = new employe();
		List<employeModel> listEmployes = e.list();
        request.setAttribute( "employes", listEmployes );
		request.getRequestDispatcher("admin/employeManagement.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter( "nom" );
        String prenom = request.getParameter( "prenom" );
        String username = request.getParameter( "username" );
        String password = request.getParameter( "password" );
       
        	      
        
        employeModel employe = new employeModel();
        employe.setNom(nom);
        employe.setPrenom(prenom);
        employe.setUsername(username);
        employe.setPassword(password);
        employe.setStatus("employe");
        
        request.setAttribute( "employe", employe );
        employe c= new employe();      
        c.ajouter(employe); 
        //and here we get again the list of employes to display in employesManagement.jsp
		employe e = new employe();
        List<employeModel> listEmployes = e.list();
        request.setAttribute( "employes", listEmployes );
        
		request.getRequestDispatcher("admin/employeManagement.jsp").forward(request,response);
	}

}
