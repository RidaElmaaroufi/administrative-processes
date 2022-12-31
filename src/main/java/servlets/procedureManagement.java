package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.chef;
import metier.procedure;
import models.chefModel;
import models.procedureModel;

/**
 * Servlet implementation class procedureManagement
 */
@WebServlet(name="pManagemnt",urlPatterns= {"/procedureManagement"})
public class procedureManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public procedureManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procedure proced = new procedure();
		List<procedureModel> listProcs = proced.list();
        request.setAttribute( "procs", listProcs );
        chef chef1 = new chef();
        List<chefModel> chefs = chef1.list();
        request.setAttribute("chefs", chefs);
		request.getRequestDispatcher("admin/procedureManagement.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libele = request.getParameter("libele");
		String description = request.getParameter("description");
		int ID_chef = Integer.parseInt(request.getParameter("ID_chef"));
		System.out.println(ID_chef);
		procedureModel proc = new procedureModel();
		proc.setLabel(libele);
		proc.setDescription(description);
		proc.setChefID(ID_chef);
		proc.setState(0);
		
		procedure p = new procedure();
		p.ajouter(proc);
		
		procedure procs = new procedure();
        List<procedureModel> listProcs = procs.list();
        request.setAttribute( "procs", listProcs ); 
		request.getRequestDispatcher("admin/procedureManagement.jsp").forward(request,response);
	}

}
