<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String msg = ""; %>
<% if(request.getParameter("msg") != null)
	{
	  msg = request.getParameter("msg");
	}
%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8" />
  <title>SOA</title>
  <link rel="stylesheet" href="../css/connect.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
</head>
<body>
  <h2><%=msg %></h2>
  <div class="container" id="container">
    <div class="form-container sign-up-container">
      <form action="../Connect" method="POST">
        <h1>Créer un compte</h1>
        <input type="number" placeholder="idAdmin 1122" readonly="readonly" name="idA"/>
        <input type="number" placeholder="idBureau 12"  readonly="readonly" name="idB"/>
        <input type="email" placeholder="Votre Email"  name="email"/>
        <input type="tel" placeholder="Numero Tele"  name="tele"/>
        <input type="text" placeholder="Login" name="login"/>
        <input type="password" placeholder="Mot de passe" name="password"/>
        <button type="submit" name="btn" value="cree">Créer le compte</button>
      </form>
    </div>
    <div class="form-container sign-in-container">
      <form action="../Connect" method="POST">
        <h1>Se connecter</h1>
        <input type="text" placeholder="Login" name="login"/>
        <input type="password" placeholder="Mot de passe" name="password"/>
        <button type="submit" name="btn" value="connect">Se connecter</button>
      </form>
    </div>
    <div class="overlay-container">
      <div class="overlay">
        <div class="overlay-panel overlay-left">
          <h1>Bienvenue !</h1>
          <p>Entrez vos informations personnelles.</p>
          <button class="ghost" id="signIn">Se connecter</button>
        </div>
        <div class="overlay-panel overlay-right">
          <h1>Bienvenue !</h1>
          <p>Nouveau utilisateur .</p>
          <button class="ghost" id="signUp">Créer un compte</button>
        </div>
      </div>
    </div>
    <footer>
      <p>&copy; 2023 SMI S6 - Encadré par Pr Zahour Omar</p>
    </footer>
  </div>

  <script src="../js/connect.js"></script>
</body>
</html>