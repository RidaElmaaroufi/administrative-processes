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
		<title>GestionProcs</title>
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
							<li><a href="chefManagement" >Chefs de division </a></li>
							<li><a href="employeManagement">Employés</a></li>
							<li><a href="#" style="border-bottom: 2px solid aqua; color: #FFFF; font-family: bold">Procedures</a></li>
							<li style="font-size:18px; font-family: bold; color:aqua"> ${sessionScope.nom } ${sessionScope.prenom }</li>
							<li><a href="../logout" class="button primary">Log out</a></li>
						</ul>
					</nav>
				</header>
				<section style="position:absolute; top:30%;right: 5%; background-color: gray; border-radius: 10px; width:45rem">
					<span style="font-weight:16px;font-size: 18px; color : aqua;display:block; text-align:center">Gestion Des Procedures</span>
					<div style="background-color:black">
						<table border='2' class="table table-striped">
							<thead>
							<th>ID</th>
							<th>Label </th>
							<th>Description</th>
							<th>Chef de procédure</th>
							<th>Actions</th>
							</thead>
							<tbody style="color=white; background-color:#FFFF">				    
						    <c:forEach items="${procs}" var="proc">
							    <tr>
							      <td style="color:black;font-family:bold">${proc.getID_process()} </td>
							      <td style="color:black;font-family:bold">${proc.getLabel()}</td>
							      <td style="color:black;font-family:bold">${proc.getDescription()}</td>
							      <td style="color:black;font-family:bold">${proc.getChef().getNom()}</td>
							      <td><a href="procManagement1?IDA=${proc.getID_process()}"> Supprimer</a>
									  <a href="/GRH/JSP/procUpdate.jsp?IDA=${proc.getID_process()}" style="color: aqua"> Modifier</a>
								  </td>
							   </tr>
							  </c:forEach>		
							</tbody>
						</table>
					</div>
					<div style="float: right">
						<button style="marging-top: 10rem; color : aqua"><a href="./HtmlAdd/FormProcedure.html">ajouter procedure </a></button>
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