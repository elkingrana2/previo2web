<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Giro de Italia lista de paises</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" 
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark">
			<div>
				<a href="#" class="navbar-brand"> Gestión de Paises</a>
			</div>
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath() %>/list" calss="nav-link">Paises</a></li>
			</ul>
		
		</nav>
	</header>
	<br>
	
	<div class="row">
				
				<div class="container">
					<h3 class="text.center">Listado de Paises</h3>
					<hr>
					<div class="container text-left">
					
						<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar nuevo País</a>
					</div>
					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Nombre</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="country" items="${listCountrys}">
							
								<tr>
									<td>
										<c:out value="${country.id}">
									</td>
								</tr>
						</tbody>
					
					</table>
					
				
				</div>
	
	</div>
</body>
</html>