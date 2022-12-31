package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.usersDAO;
import beans.User;

/**
 * Servlet implementation class main
 */
@WebServlet(name="cs",urlPatterns= {"/main"})
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }    
    @Override
    public void init() throws ServletException { 
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		request.getRequestDispatcher("admin.jsp").forward(request,response);
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		User result = new User();
		usersDAO uDAO = new usersDAO();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		result = uDAO.connect(user);
		String destPage = "login.jsp";
		if(result==null) {
			//response.sendRedirect(request.getContextPath()+"/src/main/webapp/login.html?msg=Invalid Identifier");
			String message = "Invalid username/password";
            request.setAttribute("message", message);			
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("ID", result.getID());
			session.setAttribute("nom", result.getNom());
			session.setAttribute("prenom", result.getPrenom());
			session.setAttribute("username", result.getUsername()); 
			session.setAttribute("password", result.getPassword());
			session.setAttribute("status", result.getStatus());
			session.setAttribute("connected", true);
			if(result.getStatus().equals("admin")) {
				destPage = "admin.jsp";
				//response.sendRedirect(request.getContextPath()+"/src/main/webapp/admin/admin.jsp");
			}
		}
		System.out.println(destPage);
		request.getRequestDispatcher(destPage).forward(request,response);

		
		
		 /*ProcedureDAO proceduredao = new ProcedureDAO();
		procedureModel pm = new procedureModel();
		 List<procedure> lp = proceduredao.list();
		 pm.setprocedures(lp);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("modele", pm);
		/*PrintWriter out = response.getWriter();
		for(procedure p: pm.getProcedurs()) {
			System.out.println(p.getID());
			out.println(p.getLabel());
		}*/
		
		
		
		//request.getRequestDispatcher("admin/admin.jsp").forward(request,response);

	}

}
