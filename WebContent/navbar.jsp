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
<!-- User Navigation bar-->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">
			<img class="img-fluid"
				src="images/dollar-sign-icon-0.png" alt="DB Mobile" style="max-height: 3.75rem;" >DollarsBank</a>
 			<div class="form-inline" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link text-secondary" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="account.jsp">Account</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="savings.jsp">Savings</a></li>
					<!-- <li class="nav-item"><a class="nav-link text-secondary" href="checkings.jsp">Savings</a></li> -->
					<!-- <li class="nav-item"><a class="nav-link text-secondary" href="transferfunds.jsp">Transfer funds</a></li> -->
 					<li class="nav-item"><form method="post" action="./logout">
						<button class="btn btn-dark text-secondary" style="max-width:45%;" type="submit" name="logOut">LogOut</button></form>
					</li>
					
				</ul>
			</div>
		 </div> 
	</nav>
