package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOUtilisateur;
import Model.Utilisateur;


@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOUtilisateur daoU;
       
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	daoU = new DAOUtilisateur();
    }
    public Connect() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Assalamo Alikom doGet");
		String op = request.getParameter("op");
		if(op != null)
		{
			if(op.equalsIgnoreCase("disconnect"))
			{
				HttpSession ses = request.getSession();
				ses.removeAttribute("u");
				ses.invalidate();
			    Cookie[] cookies = request.getCookies();
			    if (cookies != null) {
			        for (Cookie cookie : cookies) {
			            if (cookie.getName().equals("JSESSIONID")) {
			                cookie.setMaxAge(0); // Suppression du cookie en définissant son expiration à 0
			                cookie.setPath("/"); // Définition du chemin du cookie pour qu'il s'applique à toutes les pages du site
			                cookie.setSecure(true); // Définition de l'attribut Secure pour transmettre le cookie uniquement via HTTPS
			                cookie.setHttpOnly(true); // Définition de l'attribut HttpOnly pour empêcher l'accès côté client
			                response.addCookie(cookie); // Ajout du cookie à la réponse
			                break;
			            }
			        }
			    }
				response.sendRedirect("jsp/connect.jsp");
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("Assalamo Alikom doPost<br>");
		
		String btn = request.getParameter("btn");
		out.print("Le mode "+btn+" :<br/>");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		out.print("login = "+login+", password = "+password+"<br>");
		
		if(btn.equals("connect"))
		{
			//out.print("<br> Connect");
			Utilisateur u = null;
			try {
			    u = daoU.authentifie(login, password);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(u == null)
            {
//            	out.print("<br>Error");
//            	RequestDispatcher dis = request.getRequestDispatcher("html/Connect.html");
//            	dis.forward(request, response);
            	String msg = "Il semble y avoir eu une erreur lors de la creation de votre compte. Veuillez reessayer ou contacter l'administrateur pour obtenir de l'aide.";
            	response.sendRedirect("jsp/connect.jsp?msg="+msg);
//            	response.sendRedirect("html/Connect.html?msg"+msg);
            }
            else
            {
            	//out.print("<br>existe => login = "+u.getLogin()+", password = "+u.getPassword());
            	HttpSession ses = request.getSession();
        		ses.setAttribute("u", u);
        		response.sendRedirect("jsp/Accueil.jsp");
            }
		}
		if(btn.equals("cree"))
		{
			//out.print("<br> cree");
//			int idA = Integer.parseInt(request.getParameter("idA"));
//			int idB = Integer.parseInt(request.getParameter("idB"));
			String email = request.getParameter("email");
			String tele = request.getParameter("tele");
			out.print(", tele = "+tele);
			Utilisateur u = new Utilisateur(0, 1122, 12,email,login, password, false,"utilisateur",tele);
			boolean nb = false;
			try {
				nb = daoU.CreeCompte(u);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String msg;
			if(nb)
			{
				msg = "Votre compte a ete cree avec succes. Il est en attente de verification par l'administrateur.";
        		response.sendRedirect("jsp/connect.jsp?msg="+msg);

			}
			else
			{
				msg = "Il semble y avoir eu une erreur lors de la creation de votre compte. Veuillez reessayer ou contacter l'administrateur pour obtenir de l'aide.";
        		response.sendRedirect("jsp/connect.jsp?msg="+msg);
			}
		}
	}

}
