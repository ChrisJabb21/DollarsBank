<%@page import="com.dollarsbank.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		Customer c = (Customer)session.getAttribute("customer");
		%>
			<body>
			<jsp:include page="navbar.jsp" flush="true" />
			
				<div class="container" style="margin-top: 351px;">
					<form method="post" action="./edit">
						<table class="table table-borderless">
							<tr><td>First Name</td><td><input type="text" name="firstName" value="<%=c.getFirstName() %>" required></td></tr>
							<tr><td>Last Name</td><td><input type="text" name="lastName" value="<%=c.getLastName() %>" required></td></tr>
							<tr><td>Username</td><td><input type="text" name="username" value="<%=c.getUserName() %>" required></td></tr>
							<tr><td>Password</td><td><input type="password" min="8" pattern="^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" name="password" value="<%=c.getPassword() %>" required></td></tr>
							<tr><td>Address</td><td><input type="text" name="address" value="<%=c.getAddress() %>" required></td></tr>
							<tr><td>Phone Number</td><td><input type="tel" name="mobile" value="<%=c.getContactNumber() %>" required></td></tr>
							<tr><td>Customer Since</td><td><%=c.getDate() %></td></tr>
							<tr><td></td><td><input class="btn btn-info" type="submit" value="Edit"></td></tr>
						</table>
					</form>
				</div>
			</body>
		<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>
<jsp:include page="footer.jsp" flush="true" />