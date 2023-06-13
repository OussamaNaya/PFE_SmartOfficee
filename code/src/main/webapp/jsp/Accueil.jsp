<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Model.Utilisateur"%>
<%@page import="java.util.List"%>
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
        <li><a href="InfoCompte.jsp" >Infos Compte</a></li>
        <li><a href="historique.jsp" >Historique des États</a></li>
	        <% if(u.getRole().equalsIgnoreCase("admin"))
	        	{
	        %>
	        <li><a href="greeCompte.jsp" >Gere Comptes</a></li>
	        <%} %>
	   <li><a href="../Connect?op=disconnect" >disconnect</a></li>
      </ul>
    </nav>
  </header>
  
  <main>
    <section class="hero">
      <h1>Bienvenue <%=u.getLogin() %> sur votre Smart Office Application SOA</h1>
      <p>Avec notre application, vous pouvez facilement surveiller les niveaux de fumée, de gaz et d'humidité dans votre bureau intelligent en temps réel, pour garantir un environnement sûr et confortable</p>
    </section>
    
    <section>
       <% 
            String msg = "";
            String op = request.getParameter("op");
            if(op != null)
            {
            	if(op.equalsIgnoreCase("supprimeUt"))
            	{
            		msg = request.getParameter("msg");
            	}
            }
       %>
       <h3><%=msg %></h3>
    </section>
    <section class="features">
      <h2>Nos services</h2>
      <ul>
		  <li><a href="modofieUtilisateur.jsp">Modifier Compte</a></li>
		  <li>
		    Contrôle de niveau de
		    <select id="select-etat" name="etat" onchange="redirectToLink(this.value)">
		      <option value="humidite">Humidité</option>
		      <option value="gaz">Niveau de gaz</option>
		      <option value="fumee">Fumée</option>
		    </select>
		  </li>
		  <li><a href="../CreeCompte?op=supprimeUt&idU=<%=u.getIdU() %>">Supprime Compte</a></li>
	  </ul>
	<script>
	  function redirectToLink(value) {
	    if (value === "humidite") {
	      window.location.href = "value.jsp?op=humidite";
	    } else if (value === "gaz") {
	      window.location.href = "value.jsp?op=gaz"; // Insérez le lien pour le niveau de gaz
	    } else if (value === "fumee") {
	      window.location.href = "value.jsp?op=fumee"; // Insérez le lien pour la fumée
	    }
	  }
	</script>
    </section>
    
    
  </main>
  
  <footer>
    <div class="logo-container">
      <img src="../image/logo PFE touhami.jpg" alt="Logo Smart Office">
    </div>
    <p>&copy; 2023 SMI S6 - Encadré par Pr Zahour Omar</p>
  </footer>
  <script src="../js/Acceuil.js"></script>
</body>
</html>
<%   }
     else
     {
    	 response.sendRedirect("connect.jsp");
     }
  %>