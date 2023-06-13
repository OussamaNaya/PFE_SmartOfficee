<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.Utilisateur"%>
 <% 
      if(session.getAttribute("u") != null)
      {
        	Utilisateur u =(Utilisateur)session.getAttribute("u");
        	
%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>SOA</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&display=swap" rel="stylesheet">
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
	<h1>Consulter les états</h1>
	<form action="value.jsp">
		<label for="select-etat">Sélectionner un état :</label>
		<select id="select-etat" name="etat">
			<option value="humidite" name="humidite">Humidité</option>
			<option value="gaz" name="gaz">Niveau de gaz</option>
			<option value="fumee" name="fumee">Fumée</option>
		</select>
		<button type="submit">Consulter</button>
	</form>
    <script src="test.js"></script>
	<footer>
		<div class="logo-container">
		  <img src="../image/logo PFE touhami.jpg" alt="Logo Smart Office">
		</div>
		<p>&copy; 2023 SMI S6 - Encadré par Pr Zahour Omar</p>
	  </footer>
	  <script src="../js/Accueil.js"></script>
	  

</body>
</html>
<%   }
     else
     {
    	 response.sendRedirect("connect.jsp");
     }
  %>