<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.*" %>
 <% 
      if(session.getAttribute("u") != null)
      {
        	Utilisateur u =(Utilisateur)session.getAttribute("u");
        	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SOA</title>
  <link rel="stylesheet" href="../css/Accueil.css">
  <link rel="stylesheet" href="../css/greeCompte.css">
</head>
<body>
        <%
             String msg = "";
             if(request.getParameter("msg") != null)
             {
            	 msg = request.getParameter("msg");
             }
        %>
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
         <section>
              <%=msg %>
         </section>
         <section>
          <form action="../CreeCompte" class="ajt">
              <caption>Modifier votre compte : </caption>
              <table>
	       	     <tr>
	       	       <th>IdU : </th><td><input type="number" value="<%=u.getIdU() %>" readonly="readonly" name="idU"></td>
	       	     </tr>
	       	     <tr>  
	       	       <th>IdA :  </th><td><input type="number" value="<%=u.getIdAdmin() %>" readonly="readonly" name="idA"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>IdB : </th><td><input type="number" value="<%=u.getIdB() %>" readonly="readonly" name="idB"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Role : </th><td><input type="text" value="<%=u.getRole() %>" readonly="readonly" name="rol"></td>
	       	     </tr>	       	        
	       	     <tr>
	       	       <th>Email : </th><td><input type="email" value="<%=u.getEmail() %>"  name="email"/></td>
	       	     </tr>
	       	     <tr>   
	       	     <tr>
	       	       <th>Login : </th><td><input type="text" value="<%=u.getLogin() %>" name="log"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Password : </th><td><input type="text" value="<%=u.getPassword() %>" name="pass"></td>
	       	     </tr>
	       	     <tr>
	       	       <th>Tele : </th><td><input type="tele" value="<%=u.getTele() %>" name="tele"></td>
	       	     </tr>
	       	<!--  
	       	     <tr>	       	     
	       	       <th>Etat : </th><td><input type="number" value="<%=u.isEtat() %>"  name="etat"></td>
	       	     </tr>
	       	-->     
	       	     <tr>
	       	       <td><input type="submit" value="ModifierUt" name="op"></td>
	       	       <td><input type="reset" value="Annuler" ></td>
	       	    </tr>
	       	  </table>
	        </form>
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