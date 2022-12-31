package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.procedure;
import models.procedureModel;

/**
 * Servlet implementation class procManagement1
 */
@WebServlet(name="prManagemnt",urlPatterns= {"/procManagement1"})
public class procManagement1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public procManagement1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procedure A=new procedure();
		int IDC = Integer.parseInt(request.getParameter("IDA")) ;
		A.supprimer(IDC);
		List<procedureModel> listProcs=A.list();
        request.setAttribute( "procs", listProcs );
		request.getRequestDispatcher("admin/procedureManagement.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
