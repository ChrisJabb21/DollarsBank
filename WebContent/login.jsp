<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Login</title>
	<style>
	button{
    display:inline-block;
}
	
	</style>
</head>
<body class="bg-light">
	<%
		if (session.getAttribute("loginFailed") != null) {
	%>
		<script type="text/javascript">
			alert("\nInvalid username or password: Please try again...");
		</script>
	<%
		}
	%>
	<jsp:include page="indexnavbar.jsp" flush="true" />
	
	<div class= "columns is-desktop is-vcentered container shadow-lg bg-white mx-auto"
		style="top: 49px; vertical-align: middle; text-align:center; margin: auto; max-width: 300px">
		<!-- Login Form -->
		
		<form class="mx-auto" method="POST" action="./login">
			<div class="form-group">
				<label class="label mx-auto font-weight-bolder text-center">LOGIN</label><br>
				<input class="mx-auto" type="text" name="user"
					placeholder="username" required><br> 
					<input class="mx-auto" style="margin-top: 5px" type="password" name="pass"
					placeholder="password" required><br>
							<div class="mx-auto" style="padding-bottom: 5px">
					
				<a href="login.jsp"><button class="button is-light" style="margin-top: 5px"
					type="submit">Log In</button></a>
					<!-- Sign Up -->
			<a href="signup.jsp"><button class="button is-primary" style="margin-top: 5px">Sign Up</button></a>
		</div>		
			</div>
		</form>
		
	</div>
</body>
	<jsp:include page="footer.jsp" flush="true" />