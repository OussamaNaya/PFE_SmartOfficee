<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Utilisateur"%>
<%@page import="DAO.DAOUtilisateur"%>
    
 <% 
      if(session.getAttribute("u") != null)
      {
        	Utilisateur u =(Utilisateur)session.getAttribute("u");
        	
%>
<%! DAOUtilisateur daoU = new DAOUtilisateur(); %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>SOA</title>
	<link rel="stylesheet" href="../css/Consulte.css">
	<link rel="stylesheet" href="../css/Accueil.css">

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
		<h1>Informations du compte</h1>
		<p>Voici les informations de votre compte :</p>
		<ul class="info">
			<li><b>Id Utilisateur :</b> <%=u.getIdU() %> </li>
			<li><b>Id Admin : </b> <%=u.getIdAdmin() %> </li>
			<% if(u.getIdAdmin() != 0)
			   { 
			%>
			<li><b>Login Admin : </b><%=daoU.getAdmin(u).getLogin() %></li>
			<li><b>Tele Admin : </b><%=daoU.getAdmin(u).getTele() %></li>
			<%
			   }
			%>
			<li><b>Login : </b> <%=u.getLogin() %> </li>
			<li><b>Mot de passe : </b> <%=u.getPassword() %></li>
			<li><b>Role : </b> <%=u.getRole() %></li>
			<li><b>Tele : </b> <%=u.getTele() %></li>
			<li><b>ID Bureau : </b> <%=u.getB().getIdB() %></li>
			<li><b>Localisation Bureau : </b> <%=u.getB().getLoc() %></li>	
			<li><b>URL Humidite : </b> <%=u.getB().getCapteurHumidite().getUrl()%></li>
			<li><b>URL Gaz : </b> <%=u.getB().getCapteurGaz().getUrl()%></li>
			<li><b>URL Fumee : </b> <%=u.getB().getCapteurFumee().getUrl()%></li>
			<li><b>Borne Min d'Humidite :</b> <%=u.getB().getCapteurHumidite().getSssc().getBorneMaxHumidite()%></li>
			<li><b>Borne Max d'Humidite :</b> <%=u.getB().getCapteurHumidite().getSssc().getBorneMinHumidite()%></li>
			<li><b>Borne Min de Gaz :</b> <%=u.getB().getCapteurGaz().getSssc().getBorneMinGaz()%></li>
			<li><b>Borne Max de Gaz :</b> <%=u.getB().getCapteurGaz().getSssc().getBorneMaxGaz()%></li>
			<li><b>Borne Min de Fumee :</b> <%=u.getB().getCapteurFumee().getSssc().getBorneMinFumee()%></li>
			<li><b>Borne Max de Fumee :</b> <%=u.getB().getCapteurFumee().getSssc().getBorneMaxFumee()%></li>
			<li><b>URL Pompuse :</b> <%=u.getB().getCapteurFumee().getSssc().getSurg().getUrlPompuse()%>,au cas ou le systeme detecte une erreur dans Fumee </li>
			<li><b>Email :</b> au cas detecte une erreur dans Humidite ou Gaz </li>
		</ul>
	</main>

	<footer>
		<div class="logo-container">
			<img src="../image/logo PFE touhami.jpg" alt="Logo Smart Office">
		</div>
		<p>&copy; 2023 SMI S6 - Encadré par Pr Zahour Omar</p>
	</footer>
	<script src="acceuil.js"></script>
</body>
</html>
<%   }
     else
     {
    	 response.sendRedirect("connect.jsp");
     }
  %>