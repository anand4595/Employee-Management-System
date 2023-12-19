<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin | Read All Employees</title>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>


<body>
	<%
	List<Map<String, Object>> employeeList = (List<Map<String, Object>>) request.getAttribute("employeeList");

	if (employeeList.size() != 0) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Salary</th>
			<th>Email</th>
			<th>Department</th>
		</tr>

		<%
		for (int i = 0; i < employeeList.size(); i++) {
		%>
		<tr>
			<td><%=employeeList.get(i).get("id")%></td>
			<td>
				<%=((Map<String, String>) employeeList.get(i).get("name")).get("first_name")%>
				<%=((Map<String, String>) employeeList.get(i).get("name")).get("middle_name")%>
				<%=((Map<String, String>) employeeList.get(i).get("name")).get("last_name")%>
			</td>
			<td><%=employeeList.get(i).get("age")%></td>
			<td><%=employeeList.get(i).get("gender")%></td>
			<td><%=employeeList.get(i).get("salary")%></td>
			<td><%=employeeList.get(i).get("email")%></td>
			<td><%=employeeList.get(i).get("department")%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else if (employeeList.size() == 0) {
	%>
	<p style="color: red">No employee added into database</p>
	<%
	}
	%>

</body>
</html>