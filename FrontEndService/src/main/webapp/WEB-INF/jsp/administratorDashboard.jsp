<%@page import="com.example.FrontEndService.model.ContactUsModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator Dash board</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Administrator Dash board</h1>
	<h2>Unanswered Queries</h2>
	<%
	ContactUsModel[] contactUsModelArray = (ContactUsModel[]) request.getAttribute("contactUsModelArray");
	%>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Query</th>
			<th>Status</th>
		</tr>
		<%
		for (int i = 0; i < contactUsModelArray.length; i++) {
			String name = contactUsModelArray[i].getName();
			String email = contactUsModelArray[i].getEmail();
			String query = contactUsModelArray[i].getQuery();
			String status = contactUsModelArray[i].isSolved() == true ? "Resolved" : "Not Resolved";
		%>
		<tr>
			<td><%=name%></td>
			<td><%=email%></td>
			<td><%=query%></td>
			<td><%=status%></td>
		</tr>
		<%}%>
	</table>

</body>
</html>