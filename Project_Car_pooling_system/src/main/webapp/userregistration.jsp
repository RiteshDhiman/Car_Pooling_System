<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "userreg.css" type = "text/css">
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>

<body>
<div class = 'main'>
<div class = 'login'>
<h2>User Registration</h2>
<form action="insertuser" method="post" id = "register">
<label>Enter name:</label><br>
<input type="text" name="uname" required placeholder="*name compulsory" id = "name" required><br><br>

<label>Enter Password:</label><br>
<input type="password" name="password" required placeholder="*password compulsory" id = "name" required><br><br>

<label>Enter Phone No.:</label><br>
<input type="tel" name="telephone" required placeholder="*Phone-number compulsory" id = "name" required> <br><br>

<label>Enter Email ID:</label><br>
<input type="email" name="email" required placeholder="*email compulsory" id = "name" required><br><br>

<label>Enter Pickup-Location:</label><br>
<input type="text" name="location" required placeholder="*location compulsory" id = "name" required><br><br>

<input type = "submit" value = "Register" id = "submit">
</form>
</div></div>
</body>
</html>