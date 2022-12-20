<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = 'stylesheet' href = 'usercss.css' type = 'text/css'>

<title>user</title>
</head>
<body>
<div class = 'main'>
<div class = 'login'>
<form action="confirmation" method="post" id = "register">

<h2>User Login/Register</h2>
<label>Enter Name:</label><br>
<input type="text" name="name" id="name" required><br><br>

<label>Enter Password:</label><br>
<input type="password" name="password" id = "name" required><br><br>

<input type="submit" value="Login" id = "submit"></form>
<form action="userregistration.jsp" method="get">

<input type="submit" value="New User? Register" id = "submit1">
</form>
</div></div>
</body>
</html>