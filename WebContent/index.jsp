<%@page import="com.dollarsbank.model.Customer"%>
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

<% 
	if(session.getAttribute("customer")!=null) {
		Customer c = (Customer)session.getAttribute("customer");
		String name = new String(c.getFirstName()+" "+c.getLastName());
		%>
			<jsp:include page="navbar.jsp"  />
			
				<div class="mx-auto container" style="margin-top: 351px;">
					<h3 class="mx-auto">Welcome <%=name%>!</h3>
					<p>Thank you for choosing Dollars Bank today! To see your recent transaction history, make deposits or withdrawals, 
					go to your checking or savings accounts.</p>
				</div>
			</body>
		<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>
<jsp:include page="footer.jsp" flush="true" />
