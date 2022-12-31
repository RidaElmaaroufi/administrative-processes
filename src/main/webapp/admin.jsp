<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
 <%
	String U = (String) request.getAttribute("username");
	String P = (String) request.getAttribute("password");
	
%>

<!DOCTYPE HTML>

<html>
	<head>
		<title>Acceuil</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="admin/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="admin/assets/css/noscript.css" type="text/css"/></noscript>
		
		
	</head>
	<body class="is-preload landing">
		<%if((boolean) session.getAttribute("connected")==false) {
			response.sendRedirect(request.getContextPath()+"/login.html");
			}
		%>
		<div id="page-wrapper">

				<header id="header">
					<h1 id="logo"><a href="#">Menu</a></h1>
					<nav id="nav">
						<ul>
							<li><a href="index.html" style="border-bottom: 2px solid aqua; color: #FFFF; font-family: bold">Acceuil</a></li>
							<li><a href="chefManagement" style="color:#FFFF;font-family: bold;">Chefs de division </a></li>
							<li><a href="employeManagement" style="color:#FFFF;font-family: bold;">Employés</a></li>
							<li><a href="procedureManagement" id="head" style="color:#FFFF;font-family: bold;">Procedures</a></li>
							<li style="font-size:18px; font-family: bold; color:aqua;"> ${sessionScope.nom } ${sessionScope.prenom }</li>

							<li><a href="logout" class="button primary">Log out</a></li>

						</ul>
					</nav>
				</header>

			
				<section id="banner">
					<div class="content">
						<header>
							<h2>Acceuil </h2>
							<p>Vous êtes sur votre plateforme <span style="font-family: bold ; color: aqua; font-size:18">Idarati</span> </p>
							<p>Qui permet la gestion des processus administratifs</p> 
							<p>Et qui vous facilite le suivie de vos demandes administratives </p> 
							
						  
						</header>
						<span class="image"><img src="admin/images/logo.jpg" alt="" /></span>
					</div>
					<h3>hello admin  : <% out.print(U); %></h3>
					<h3>Votre password est : <%=P %></h3>
					
					<c:forEach items="${modele.getProcedurs()}" var="p">
						<tr>
							<td>${p.getID()}</td>
							<td>${p.getLabel()}</td>
							<td>2</td>
						</tr>
					</c:forEach>
					
				</section>

		

		

		</div>

			<script src="admin/assets/js/jquery.min.js"></script>
			<script src="admin/assets/js/browser.min.js"></script>
			<script src="admin/assets/js/breakpoints.min.js"></script>
			<script src="admin/assets/js/util.js"></script>
			<script src="admin/assets/js/main.js"></script>

	</body>
</html>