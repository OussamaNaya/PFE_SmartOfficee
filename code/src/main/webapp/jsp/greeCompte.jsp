<%@page import="DAO.DAOAdmin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Utilisateur"%>
<%@ page import="DAO.DAOAdmin"%>
<%@ page import="java.util.List" %>
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
  <link rel="stylesheet" href="../css/greeCompte.css">
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
	        <% 
	            } 	        
	        %>
	   <li><a href="../Connect?op=disconnect" id="historique-link">disconnect</a></li>
      </ul>
    </nav>
  </header>
  
  <main>
    <section>
          <form action="../CreeCompte" class="ajt">
              <caption>Ajouter Utilisateur : </caption>
              <table>
	       	     <tr>
	       	       <th>IdU : </th><td><input type="number" value="00" readonly="readonly" name="idU"></td>
	       	     </tr>
	       	     <tr>  
	       	       <th>IdA :  </th><td><input type="number" value="1122" readonly="readonly" name="idA"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>IdB : </th><td><input type="number" value="12" readonly="readonly" name="idB"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Email : </th><td><input type="email" value="aa@gmail.com"  name="email"/></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Login : </th><td><input type="text" value="lg" name="log"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Password : </th><td><input type="text" value="***" name="pass"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Role : </th><td><input type="text" value="utilisateur"  name="rol"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Tele : </th><td><input type="tele" value="06" name="tele"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Etat : </th><td><input type="number" value="etat"  name="etat"></td>
	       	     </tr>
	       	     <tr>
	       	       <td><input type="submit" value="Ajouter" name="op"></td>
	       	       <td><input type="reset" value="Annuler" ></td>
	       	    </tr>
	       	 </table>
	     </form>
    </section>
    <section>
    	<%!
    		DAOAdmin daoA;
    	%>
       	<%
	    boolean etat = false;
	    int indice = 0;
	    String op = "";
	    String et;
       		daoA = new DAOAdmin();
       		List<Utilisateur> l = daoA.AllUtilisateur(u);
       		if(request.getParameter("op") != null)
       		{
       			op = request.getParameter("op");
       			if(op.equalsIgnoreCase("modifier"))
       			{
           			etat = true;
           			indice = Integer.parseInt(request.getParameter("idU"));	
       			}
       		}
       	%>
       	   <table class="table">
       	       <caption>Les Utilisateurs qui je suis Adminer :</caption>
       	       <tr><th>idUtilisateur</th><th>idAdmin</th><th>idBureau</th><th>Email</th><th>Login</th><th>Password</th><th>Role</th><th>Tele</th><th>Etat</th></tr>
       	      <%
	       		for(Utilisateur ut : l)
	       		{
	       			if(etat==true & ut.getIdU()==indice)
	       			{
	       	  %>
	       	            <form action="../CreeCompte">
	       	                 <tr>
	       	                    <td><input type="number" value="<%=ut.getIdU()%>" readonly="readonly" name="idU"></td>
	       	                    <td><input type="number" value="<%=ut.getIdAdmin()%>" readonly="readonly" name="idA"></td>
	       	                    <td><input type="number" value="<%=ut.getIdB()%>" name="idB"></td>
	       	                    <td><input type="email" value="<%=ut.getEmail()%>" name="email"></td>
	       	                    <td><input type="text" value="<%=ut.getLogin()%>" name="log"></td>
	       	                    <td><input type="text" value="<%=ut.getPassword()%>" name="pass"></td>
	       	                    <td><input type="text" value="<%=ut.getRole()%>" name="rol"></td>
	       	                    <td><input type="tele" value="<%=ut.getTele()%>" name="tele"></td>
	       	                    <%	       	                        
	       	                        if(ut.isEtat())
	       	                    	{
	       	                    	    et = "recrute";
	       	                    	}else
	       	                    	{
	       	                    		et = "en Attente";
	       	                    	}
	       	                    %>
	       	                    <td><input type="number" value="<%=et%>"  name="etat"></td>
	       	                    <td><input type="submit" value="save" name="op"></td>
	       	                    <td><input type="reset"><a href="greeCompte.jsp">Annuler</a></td>
	       	                 </tr>
	       	            </form>
	       	  <% 
	       			}
	       			else
	       			{
       	      %> 
	       	          <tr>
	       	              <td><%=ut.getIdU()%></td>
	       	              <td><%=ut.getIdAdmin()%></td>
	       	              <td><%=ut.getIdB()%></td>
	       	              <td><%=ut.getEmail() %></td>
	       	              <td><%=ut.getLogin()%></td>
	       	              <td><%=ut.getPassword()%></td>
	       	              <td><%=ut.getRole()%></td>
	       	              <td><%=ut.getTele()%></td>
	       	              <%
	       	                 
	       	                 if(ut.isEtat())
	       	                 {
	       	                    %>
	       	                     <td>recrute</td>
	       	                    <% 
	       	                 }
	       	                 else
	       	                 {
	       	                    %>
	       	                     <td><a href="../CreeCompte?op=valide&idU=<%=ut.getIdU()%>">en Attente</a></td>
	       	                    <% 
	       	                 }
	       	              %>
	       	             
	       	              <td><a href="?op=modifier&idU=<%=ut.getIdU()%>">Modifier</a></td>
	       	              <td><a href="../CreeCompte?op=supprime&idU=<%=ut.getIdU()%>">Supprime</a></td>      	              
	       	          </tr>
	       	   <%
	       			}
	       	  %>
       	      <%
       		    }
           	  %>
       	   </table>
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