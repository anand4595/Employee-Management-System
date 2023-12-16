<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact US</title>
<style type="text/css">
body {
	font-family: sans-serif;
}

.green-text {
	color: green;
}

.red-text {
    color: red;
}
</style>
</head>
<body>
	<h1>Contact US Foam</h1>

	<%
	String status = (String) request.getAttribute("status");
	String  message = (String) request.getAttribute("message");
	%>

	<%
	if (status != null && status.equals("success")) {
	%>
	<p class="green-text"> ${message} </p>
	<%
	} else if (status != null) {
	%>
    <p class="red-text">${message}</p>
    <%
    }
    %>

	<form action="contactus" method="post">
		<p>
			Name: <input type="text" name="name">
		</p>
		<p>
			Email: <input type="email" name="email">
		</p>
		Query: <br>
		<textarea rows="30" cols="30" name="query"></textarea>
		<br> <input type="submit" value="Submit Me">
	</form>

</body>
</html>