<%@page import="com.example.FrontEndService.model.DepartmentListModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin | Create</title>
</head>

<body>
	<div>
		<%
		Map<String, String> responce = (Map<String, String>) request.getAttribute("responce");
		if (responce != null) {
		%>
		<p style="color: green">
			<%=responce.get("message")%></p>
		<%
		}
		%>
	</div>
	<h1>Create New Employee</h1>
	<form action="/createEmployee" , method="post">
		<fieldset>
			<legend>Create New Employee</legend>
			<fieldset>
				<legend>Personal Details</legend>
				<fieldset>
					<legend>Name</legend>
					<p>
						First Name: <input type="text" name="firstName">
					</p>
					<p>
						Middle Name: <input type="text" name="middleName">
					</p>
					<p>
						Last Name: <input type="text" name="lastName">
					</p>
				</fieldset>
				<p>
					Email: <input type="email" name="email">
				</p>
				<p>Gender</p>
				<p>
					<input type="radio" name="gender" value="male" checked>male
				</p>
				<p>
					<input type="radio" name="gender" value="female">female
				</p>
				<p>
					<input type="radio" name="gender" value="others">others
				</p>

				<p>
					Age: <input type="number" name="age">
				</p>

			</fieldset>
			<fieldset>
				<legend>Company Details</legend>
				<p>
					Salary: <input type="number" name="salary">
				</p>
				<p>Department:</p>
				<!-- jsp code for deparment -->
				<%
				List<DepartmentListModel> departmentListModelList = (List<DepartmentListModel>) request
						.getAttribute("departmentListModelList");
				%>
				<%
				if (departmentListModelList.size() == 0) {
				%>
				<p>No departments Add departments in Administrator dash board</p>
				<%
				}
				%>
				<select name="department">
					<%
					for (int i = 0; i < departmentListModelList.size(); i++) {
					%>
					<option value="<%=departmentListModelList.get(i).getName()%>">
						<%=departmentListModelList.get(i).getName()%>
					</option>
					<%
					}
					%>
				</select>
				<p>Role:</p>
				<p>
					<input type="radio" name="role" value="Employee" checked>Employee
				</p>
				<p>
					<input type="radio" name="role" value="Admin">Admin
				</p>
				<p>
					Password (Taken name if not given): <input type="password"
						name="password">
				</p>
			</fieldset>
			<br> <input type="submit" value="Create Employee"> <input
				type="reset" value="Reset Foam">
		</fieldset>
	</form>
</body>

</html>