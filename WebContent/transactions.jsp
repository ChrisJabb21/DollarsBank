<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.dollarsbank.dao.TransactionsDAOImpl"%>
<%@page import="com.dollarsbank.dao.AccountDAOImpl"%>
<%@page import="com.dollarsbank.dao.AccountDAO"%>
<%@page import="com.dollarsbank.model.Transaction"%>
<%@page import="com.dollarsbank.dao.TransactionsDAO"%>
<%@page import="com.dollarsbank.model.Account"%>
<%@page import="com.dollarsbank.dao.AccountDAO"%>
<%@page import="com.dollarsbank.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		AccountDAO<Account> AccountDAOImpl = new AccountDAOImpl();
		Customer c = (Customer)session.getAttribute("customer");
		Account saveAcc = AccountDAOImpl.get(c.getId());
		TransactionsDAO<Transaction> trans = new TransactionsDAOImpl();
		List<Transaction> transactions = trans.getAll(c.getId());
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="container" style="margin-top:75px">
					<form method="post" action="./transactions">
						<h3 class="mx-auto"><%=c.getFirstName()+" "+c.getLastName() %> Transactions</h3>
						<table class="table table-borderless">
							<% if(request.getParameter("saveDeposit")!=null) {
								%>
								<tr>
									<td>Savings Deposit</td><td>Current Balance: <%=fmt.format(saveAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" name="saveDeposit" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Deposit"></td>
								</tr>
								<%
							} else if(request.getParameter("saveWithdraw")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getBalance() %>" name="saveWithdraw" value="0.00"></td>
									<td><input class="btn btn-danger" type="submit" value="Withdraw"></td>
								</tr>
								<%
							} else if(request.getParameter("saveTransfer")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getBalance()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getBalance() %>" name="saveTrans" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Transfer"></td>
								</tr>
								<%
							} else {
								for(int i = 0; i < transactions.size(); i++) {
									Transaction t = transactions.get(i);
							%>
								<tr><td><%=t.getTimestamp() %></td><td><%=fmt.format(t.getInitialBalance()) %></td><td><%=fmt.format(t.getAmount()) %></td><td><%=fmt.format(t.getRemainingBalance()) %></td><td><%=t.getType().toString().toLowerCase() %></td></tr>
							<%  }
							} %>
						</table>
					</form>
				</div>
			</body>
	<% }else {
		response.sendRedirect("login.jsp");
	}
%>
</html>