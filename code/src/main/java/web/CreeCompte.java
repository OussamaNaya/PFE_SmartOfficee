package web;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOAdmin;
import DAO.DAOUtilisateur;
import Model.Utilisateur;


@WebServlet("/CreeCompte")
public class CreeCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAdmin daoA;
	DAOUtilisateur daoU;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		daoA = new DAOAdmin();
		daoU = new DAOUtilisateur();
	}
    public CreeCompte() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        response.setContentType("text/hrml");
        
        out.print("Assalamo alikom Everybody");	
        String op = request.getParameter("op");
        out.print(", l'operation = "+op+"<br/>");
       // String nb = request.getParameter("idU");
        int idU = Integer.parseInt(request.getParameter("idU"));
        out.print(", idU = "+idU);
        
        if(op != null)
        {
        	if(op.equalsIgnoreCase("Ajouter"))
        	{
        		 int idA = Integer.parseInt(request.getParameter("idA"));
        		 int idB = Integer.parseInt(request.getParameter("idB"));
        		 String login = request.getParameter("log");
        		 String password = request.getParameter("pass");
        		 String role = request.getParameter("rol");
        		 String email = request.getParameter("email");
        		 String tele = request.getParameter("tele");
        		 boolean etat;
        		 int valeurEtat = Integer.parseInt(request.getParameter("etat"));
        		 if(valeurEtat == 0)
        		 {
        			 etat = false;
        		 }
        		 else
        		 {
        			 etat = true;
        		 }
        		 Utilisateur u = new Utilisateur(idU, idA, idB, email, login, password,etat, role, tele);
        		 try {
					daoA.CreeCompte(u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		 response.sendRedirect("jsp/greeCompte.jsp");
        	}
            if(op.equalsIgnoreCase("valide"))
            {
            	try {
    				daoA.VerifieCompte(idU);
    			} catch (ClassNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	response.sendRedirect("jsp/greeCompte.jsp");
            }
            if(op.equalsIgnoreCase("supprime"))
            {
            	try {
					daoA.supprime(idU);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	response.sendRedirect("jsp/greeCompte.jsp");
            }
            if(op.equalsIgnoreCase("save"))
            {
            	out.print("----> la partie de modification:   ");
            	int idA = Integer.parseInt(request.getParameter("idA"));
            	int idB = Integer.parseInt(request.getParameter("idB"));
            	String log = request.getParameter("log");
            	String pass = request.getParameter("pass");
            	boolean etat = Boolean.parseBoolean(request.getParameter("etat"));
            	String rol = request.getParameter("rol");
            	String email = request.getParameter("email");
            	String tele = request.getParameter("tele");
            	Utilisateur u = new Utilisateur(idU, idA, idB, email, log, pass,etat,rol,tele);
            	out.print(u);
            	try {
					daoA.ModifierCompte(idU, u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	response.sendRedirect("jsp/greeCompte.jsp");
             }
            if(op.equalsIgnoreCase("ModifierUt"))
            {
            	int idA = Integer.parseInt(request.getParameter("idA"));
            	int idB = Integer.parseInt(request.getParameter("idB"));
            	String log = request.getParameter("log");
            	String pass = request.getParameter("pass");
            	boolean etat = Boolean.parseBoolean(request.getParameter("etat"));
            	String rol = request.getParameter("rol");
            	String email = request.getParameter("email");
            	String tele = request.getParameter("tele");
            	Utilisateur u = new Utilisateur(idU, idA, idB,email, log, pass,etat,rol,tele);
            	int nbr = 0;
            	try {
					nbr = daoU.ModifierCompte(idU, u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	String smg;
            	if(nbr != 0)
            	{
            		smg = "Votre modification est bien terminer ";
            	}
            	else
            	{
            		smg = "il ya une erreur dans votre modification ";
            	}
            	response.sendRedirect("jsp/modofieUtilisateur.jsp?msg="+smg);
            }
            if(op.equalsIgnoreCase("supprimeUt"))
            {
            	int nb = 0;
                try {
					nb = daoU.supprime(idU);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                String msg;
                if(nb != 0)
                {
                	msg = "Votre compte est bien suppime";
                	response.sendRedirect("jsp/connect.jsp?msg="+msg);
                }
                else
                {
                	msg = "Erreur dans la supprision de votre compte";
                	response.sendRedirect("jsp/Accueil.jsp?op=supprimeUt&msg="+msg);
                }
                
            }
//            if(op.equalsIgnoreCase("historique"))
//            {
//            	String d1 = request.getParameter("d1");
//            	String d2 = request.getParameter("d2");
//            	List<String> l = null;
//            	try {
//					 l = daoU.Historique(d1,d2);
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//            	HttpSession ses = request.getSession();
//            	ses.setAttribute("l", l);
//            	response.sendRedirect("jsp/historique.jsp");
//            }
            
            
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
