<%@page import="java.util.Map"%>
<%@page import="com.example.FrontEndService.model.DepartmentListModel"%>
<%@page import="java.util.List"%>
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

	<h2>departments</h2>
	<h3>Department List</h3>

	<%
	Map<String, String> addDeparmentNameResponce = (Map<String, String>) request.getAttribute("addDeparmentNameResponce");
	%>
	<%
	if (addDeparmentNameResponce != null && addDeparmentNameResponce.get("status").equals("fail")) {
	%>
	<p style="color:red"><%=addDeparmentNameResponce.get("message")%>
	</p>
	<%
	} else if (addDeparmentNameResponce != null && addDeparmentNameResponce.get("status").equals("success")) {
	%>
	<p style="color:green"><%=addDeparmentNameResponce.get("message")%>
	</p>
	<%
	}
	%>

	<form action="createDepartment" method="post">
		<p>Make New Department:</p>
		<input type="text" name="departmentName"> <input type="submit"
			value="Add department">
	</form>
	<br>
	<%
	List<DepartmentListModel> departmentList = (List<DepartmentListModel>) request.getAttribute("departmentListModel");
	%>
	<table>
		<tr>
			<th>Department Name</th>
		</tr>
		<%
		for (int i = 0; i < departmentList.size(); i++) {
		%>
		<tr>
			<td><%=departmentList.get(i).getName()%></td>
		</tr>
		<%}%>
	</table>

	<hr>
	<h2>Unanswered Queries</h2>
	<%
	List<ContactUsModel> contactUsModelList = (List<ContactUsModel>) request.getAttribute("contactUsModelList");
	%>
	<%
	if (contactUsModelList.size() != 0) {
	%>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Query</th>
			<th>Status</th>
		</tr>
		<%
		for (int i = 0; i < contactUsModelList.size(); i++) {
			String name = contactUsModelList.get(i).getName();
			String email = contactUsModelList.get(i).getEmail();
			String query = contactUsModelList.get(i).getQuery();
			String status = contactUsModelList.get(i).isSolved() == true ? "Resolved" : "Not Resolved";
		%>
		<tr>
			<td><%=name%></td>
			<td><%=email%></td>
			<td><%=query%></td>
			<td><%=status%></td>
		</tr>
		<%}%>
	</table>
	<%
	} else {
	%>
	<p>All query solved</p>
	<%
	}
	%>
</body>
</html>