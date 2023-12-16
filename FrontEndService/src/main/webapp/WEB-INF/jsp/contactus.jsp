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
</style>
</head>
<body>
	<h1>Contact US Foam</h1>

	<%
	String name = (String) request.getAttribute("name");
	String email = (String) request.getAttribute("email");
	%>

	<%
	if (name != null) {
	%>
	<p class="green-text">Thanks ${name}, we will soon respond to your query at
		${email}</p>
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