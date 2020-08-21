<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<!-- Navigation -->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"><img class="img-fluid"
				src="images/dollar-sign-icon-0.png" alt="DB Mobile"></a>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link text-secondary" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="account.jsp">Account</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="savings.jsp">Savings</a></li>
 					<li class="nav-item"><form method="post" action="./logout">
						<button class="btn btn-dark text-secondary" type="submit" name="logOut">LogOut</button></form>
					</li>
					
				</ul>
			</div>
		</div>
	</nav>
