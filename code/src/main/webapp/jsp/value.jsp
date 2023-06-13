<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Utilisateur"%>
 <% 
      if(session.getAttribute("u") != null)
      {
        	Utilisateur u =(Utilisateur)session.getAttribute("u");
        	
%>    
<!DOCTYPE html>
<html>
<head><meta charset="utf-8">
	<title>SOA</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/justgage/1.4.1/justgage.min.js"></script>
	<link rel="stylesheet" href="../css/Accueil.css">
	<style>
		body {
			background-color: #F7F7F7;
			font-family: Arial, sans-serif;
			text-align: center;
		}
		h1 {
			margin-top: 50px;
			margin-bottom: 50px;
		}
		.gauge {
			display: inline-block;
			margin: 50px;
			width: 300px;
			height: 200px;
			position: relative;
		}
		.gauge .value {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
			font-size: 24px;
			font-weight: bold;
			color: #333;
		}
		.gauge .label {
			position: absolute;
			bottom: -20px;
			left: 50%;
			transform: translateX(-50%);
			font-size: 16px;
			color: #333;
		}
		.gauge .ticks {
			position: absolute;
			top: 80%;
			left: 50%;
			transform: translateX(-50%);
			width: 60%;
			height: 10px;
			background-color: #DDD;
		}
		.gauge .ticks .tick {
			position: absolute;
			top: -5px;
			width: 2px;
			height: 10px;
			background-color: #333;
		}
		.gauge .ticks .tick:nth-child(5n) {
			height: 15px;
			background-color: #333;
		}
		.current-data {
			margin-top: 50px;
			font-size: 24px;
			font-weight: bold;
			color: #333;
		}
		.above-normal {
			color: red;
		}
        .lamp {
            display: inline-block;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            background-color: gray;
            box-shadow: 0px 0px 20px 10px gray;
            margin: 50px;
        }
        .lamp.on {
            background-color: red;
            box-shadow: 0px 0px 20px 10px red;
            animation: blink 1s ease infinite;
        }
        @keyframes blink {
            0% { opacity: 1; }
            50% { opacity: 0; }
            100% { opacity: 1; }
        }
	</style>
</head>
<body>
     <%
          String capteur = "";
          if(request.getParameter("op") != null)
          {
        	  capteur = request.getParameter("op");
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
	<h1>Visualisation de <%=capteur %> en temps réel</h1>
	<div class="gauge" id="humidite"></div>
	<div class="current-data" id="current-humidite"></div>
    <div class="lamp" id="lamp"></div>
	<script>
        var lamp = $('#lamp');
       
        var audio = new Audio();
        audio.src = "../mp3/alarm.mp3";
		var gaugeHumidite = new JustGage({
			id: "humidite",
			value: 0,
			min: 0,
			max: 100,
			title: "",
			label: "",
			gaugeWidthScale: 0.3,
			counter: true,
			decimals: 1,
			startAnimationTime: 1000,
			refreshAnimationTime: 1000,
			valueFontColor: "#333",
			valueFontWeight: "bold",
			labelFontColor: "#333",
			levelColorsGradient: true,
			levelColors: ['#008000', '#FFFF00', '#FFA500', '#FF0000']
		});
		setInterval(function() {
			var now = new Date();
			var x = now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
			var yHumidite = Math.random() * 100;  // genere aliatoirment,etat de capteur
			gaugeHumidite.refresh(yHumidite);
			$('.gauge#humidite .value').text(yHumidite.toFixed(1) + '%');

			// Afficher les données actuelles
			$('#current-humidite').text('<%=capteur %> actuelle : ' + yHumidite.toFixed(1) + '%');

			// Vérifier si la valeur est supérieure à la normale
			if (yHumidite > 70) {   //borne de mon projet
				$('#current-humidite').addClass('above-normal');
                lamp.addClass('on');
                audio.play();
			} else {
				$('#current-humidite').removeClass('above-normal');
                lamp.removeClass('on');
                audio.pause();
                audio.currentTime = 0;
			}
		}, 2000);
	</script>
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