<%@page import="com.dollarsbank.model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.dollarsbank.dao.TransactionsDAOImpl"%>
<%@page import="com.dollarsbank.dao.AccountDAOImpl"%>
<%@page import="com.dollarsbank.dao.AccountDAO"%>
<%@page import="com.dollarsbank.model.Transaction"%>
<%@page import="com.dollarsbank.dao.TransactionsDAO"%>
<%@page import="com.dollarsbank.model.Account"%>
<%@page import="com.dollarsbank.model.SavingsAccount"%>
<%@page import="com.dollarsbank.dao.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Savings</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		AccountDAO<Account> acctDAO = new AccountDAOImpl();
		TransactionsDAO<Transaction> transDAO = new TransactionsDAOImpl();
		Customer c = (Customer)session.getAttribute("customer");
		Account acc = acctDAO.get(c.getId());
		List<Transaction> trans = transDAO.getAll(c.getId());
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="container" style="margin-top:75px">
					<table class="table table-borderless">
						<tr><td><%=c.getFirstName() %>'s Savings Account</td><td>Account ID: <%=acc.getId() %></td><td>Current Balance: <%=fmt.format(acc.getBalance()) %></td></tr>
					</table>
					<div class="mx-auto">
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="saveDeposit"><input class="btn btn-info" type="submit" value="Deposit">
						</form>
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="saveWithdraw"><input class="btn btn-danger" type="submit" value="Withdraw">
						</form>
						<!-- <form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="saveTransfer"><input class="btn btn-info" type="submit" value="Transfer">
						</form> -->
					</div>
					<table class="table table-borderless">
						<%
							for(int i = 0; i < trans.size();i++) {
								Transaction t = trans.get(i);
								%>
									<tr><td><%=t.getTimestamp() %></td><td><%=fmt.format(t.getInitialBalance()) %></td><td><%= fmt.format(t.getAmount()) %></td><td></td><td><%=fmt.format(t.getRemainingBalance()) %></td></tr>
								<%
							}
						%>
					</table>
				</div>
			</body>
	<% }else {
		response.sendRedirect("login.jsp");
	}
%>
</html>