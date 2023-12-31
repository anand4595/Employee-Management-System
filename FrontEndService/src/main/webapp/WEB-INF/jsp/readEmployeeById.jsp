<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.example.FrontEndService.model.EmployeeModel"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Read Employee By Id</h1>
	<form action="readEmployeeById" method="post">
		<p>
			Enter ID: <input type="number" name="employeeId">
		</p>
		<input type="submit" value="Read Employee">
	</form>
	<div>
		<%
		Map<String, Object> responce = (Map<String, Object>) request.getAttribute("responce");

		if (responce != null && responce.get("status").equals("success")) {
			Map<String, Object> employeeModel = (Map<String, Object>) responce.get("employeeModel");
		%>
		<p>
			Name:
			<%=((Map<String, String>) employeeModel.get("name")).get("first_name")%>
			<%=((Map<String, String>) employeeModel.get("name")).get("middle_name")%>
			<%=((Map<String, String>) employeeModel.get("name")).get("last_name")%>
		</p>
		<p>
			Salary:
			<%=employeeModel.get("salary") %>
		</p>
		<p>
			Email:
			<%=employeeModel.get("email") %>
		</p>
		<p>
			Gender:
			<%=employeeModel.get("gender") %>
		</p>
		<p>
			Age:
			<%=employeeModel.get("age") %>
		</p>
		<p>
			Gender:
			<%=employeeModel.get("gender") %>
		</p>

		<p>
			department:
			<%=employeeModel.get("department") %>
		</p>
		<%
		} else if (responce != null && responce.get("status").equals("fail")) {
		%>
		<p style="color: red">No employee exists with the given ID</p>
		<%
		}
		%>
	</div>
</body>
</html>