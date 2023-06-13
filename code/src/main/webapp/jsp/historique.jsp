<%@page import="Model.*"%>
<%@page import="DAO.DAOUtilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.Utilisateur"%>
<%@ page import="java.util.List" %>
  
 <%!
      DAOUtilisateur daoU = new DAOUtilisateur();
 %>   
 <% 
      if(session.getAttribute("u") != null)
      {
        	Utilisateur u =(Utilisateur)session.getAttribute("u");
        	
%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SOA</title>
  <link rel="stylesheet" href="../css/historique.css">
</head>
<body>
  <header>
    <div class="logo-container">
      <a href="Accueil.jsp" id="home-link"><img src="../image/logo PFE touhami.jpg"   alt="Logo Smart Office"></a>
      <p><%=u.getLogin() %></p>   
     </div>
    <nav>
      <ul>
        <li><a href="InfoCompte.jsp" id="account-link">Infos Compte</a></li>
        <li><a href="historique.jsp" id="historique-link">Historique des États</a></li>
	        <% if(u.getRole().equalsIgnoreCase("admin"))
	        	{
	        %>
	        <li><a href="greeCompte.jsp" id="historique-link">Gere Comptes</a></li>
	        <%} %>
	   <li><a href="../Connect?op=disconnect" id="historique-link">disconnect</a></li>
      </ul>
    </nav>
  </header>
  
  <main>
    <section class="states">
      <h1>Historique des États</h1>
      <div class="filters">
        <form action="">
            <label for="gas-filter">Date 1 :</label>
                <input type="date" value="2002-07-29" name="d1">
            <label for="smoke-filter">Date 2 :</label>
                <input type="date" value="2023-06-19" name="d2"> 
            <input type="submit"  name="op" value="Chercher"> 
            <input type="reset" value="Annule"> 
        </form>
      </div>
      <% 
          String op = request.getParameter("op");
          List<Historique> l;
          if(op != null)
          {
        	  if(op.equalsIgnoreCase("Chercher"))
        	  {
        		  String d1 =request.getParameter("d1");
        		  String d2 =request.getParameter("d2");
        		  l = daoU.Historique(u,d1,d2);
        	  }
        	  else
        	  {
        		  l = daoU.AllHistorique(u);
        	  }
          }
          else
          {
        	  l = daoU.AllHistorique(u);
          }  
      %>
      <table>
        <thead>
          <tr>
            <th>Date</th>
            <th>Gaz</th>
            <th>statu Gaz</th>
            <th>Fumée</th>
            <th>statu Fumee</th>
            <th>Humidité</th>
            <th>statu Humidite</th>
          </tr>
        </thead>
        <tbody>
             <%  
                 for(Historique h : l)
                 {

              %>
                    <tr>
                        <td><%=h.getDate()%></td><td><%=h.getValeurGaz()%></td><td><%=h.getStatuGaz() %></td><td><%=h.getValeurFumee()%></td><td><%=h.getStatuFumee() %></td><td><%=h.getValeurHumidite()%></td><td><%=h.getStatuHumidite() %></td>
                    </tr>                   
              <%
                 }
              %>  
        </tbody>
      </table>     	  
    </section>
  </main>

  <footer>
    <div class="logo-container">
      <img src="../image/logo PFE touhami.jpg" alt="Logo Smart Office">
    </div>
    <p>&copy; 2023 SMI S6 - Encadré par Pr Zahour Omar</p>
  </footer>
  <script src="../js/Accueil.js"></script>
</body>
</html>
<%  }
     else
     {
    	 response.sendRedirect("connect.jsp");
     }
  %>