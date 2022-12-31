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

/**
 * Servlet implementation class ChefManagement1
 */
@WebServlet(name="CManagemnt1",urlPatterns= {"/chefManagement1"})
public class ChefManagement1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChefManagement1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		chef A=new chef();
		int IDC = Integer.parseInt(request.getParameter("IDC")) ;
		A.supprimer(IDC);
		List<chefModel> listChefs=A.list();
        request.setAttribute( "chefs", listChefs );
		request.getRequestDispatcher("admin/chefsManagement.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("preno");
		int IDA=Integer.parseInt(request.getParameter("IDC"));
		chefModel c = new chefModel();
		c.setNom(nom);
		c.setPrenom(prenom);
		chef chef=new chef();
		request.getRequestDispatcher("admin/chefsManagement.jsp").forward(request,response);
	}

}
