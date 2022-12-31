<%@page import="models.chefModel"%>
<%@page import="models.procedureModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="DAO.ChefDAO"%>
    <%@page import="metier.chef"%>
    
    <%@page import="java.util.*"%>
    
    

<!DOCTYPE HTML>

<html>
	<head>
		<title>GestionChefs</title>
		<meta charset="utf-8" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="admin/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="admin/assets/css/noscript.css" type="text/css"/></noscript>
		
	</head>
	<body class="is-preload landing">
	
	<%if((boolean)session.getAttribute("connected")==false) {
			response.sendRedirect(request.getContextPath()+"/login.html");
			}
		%>
		<div id="page-wrapper">

				<header id="header">
					<h1 id="logo"><a href="main">Retour</a></h1>
					<nav id="nav">
						<ul>
							<li><a href="main">Acceuil</a></li>
							<li><a href="#" style="border-bottom: 2px solid aqua; color: #FFFF; font-family: bold">Chefs de division </a></li>
							<li><a href="employeManagement">Employés</a></li>
							<li><a href="procedureManagement">Procedures</a></li>
							<li style="font-size:18px; font-family: bold; color:aqua"> ${sessionScope.nom } ${sessionScope.prenom }</li>

							<li><a href="../logout" class="button primary">Log out</a></li>

						</ul>
					</nav>
				</header>
				<section style="position:absolute; top:30%;right: 5%; background-color: gray; border-radius: 10px; width:45rem">
					<span style="font-weight:16px;font-size: 18px; color : aqua;display:block; text-align:center">Gestion Des chefs de divisions</span>
					<div style="background-color:black">
						<table border='2' class="table table-striped">
							<thead>
							<th>ID</th>
							<th>Nom </th>
							<th>Prénom</th>
							<th>Username</th>
							<th>Password</th>
							<th>Actions</th>
						
							</thead>
						
							<tbody style="color=white">
													    
						    <c:forEach items="${chefs}" var="chef">
							    <tr>
							      <td style="color:#FFFF;font-family:bold">${chef.getID()} </td>
							      <td style="color:#FFFF;font-family:bold">${chef.getNom()}</td>
							      <td style="color:#FFFF;font-family:bold">${chef.getPrenom()}</td>
							      <td style="color:#FFFF;font-family:bold">${chef.getUsername()}</td>
							      <td style="color:#FFFF;font-family:bold">${chef.getPassword()}</td>
							      <td><a href="/atelier1/chefManagment1?IDA=${chef.getID()}"> Supprimer</a>
									  <a href="/GRH/JSP/AnnonceUpdate.jsp?IDA=${annonce.IDA}" style="color: aqua"> Modifier</a>
								  </td>
							   </tr>
							   
							  </c:forEach>		
							</tbody>
						</table>
					</div>
					<div style="float: right">
						<button style="marging-top: 10rem; color : aqua"><a href="./HtmlAdd/FormChef.html">ajouter chef </a></button>
					</div>
					
				</section>

		

		

		</div>

			<script src="admin/assets/js/jquery.min.js"></script>
			<script src="admin/assets/js/browser.min.js"></script>
			<script src="admin/assets/js/breakpoints.min.js"></script>
			<script src="admin/assets/js/util.js"></script>
			<script src="admin/assets/js/main.js"></script>

	</body>
</html>