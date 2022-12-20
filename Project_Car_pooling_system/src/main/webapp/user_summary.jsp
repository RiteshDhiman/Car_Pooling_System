<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "summarycss.css" type = "text/css">
<meta charset="ISO-8859-1">
<title>Summary</title>
</head>
<body>
<div class = "main">
<div class = "box">
<label id = "lb1">Thank You for using our Services!!!</label></div>
<div class = "summary">




<div class = "form">
<label id = lb2><b>SUMMARY</b></label><br><br>
<label id = lb3>Driver's Name: </label>
<label id = lb4><%out.print(request.getAttribute("Drivername")); %></label><br><br>

<label id = lb3>Pickup Location: </label>
<label id = lb4><%out.print(request.getAttribute("pickup")); %></label><br><br>

<label id = lb3>Destination: </label>
<label id = lb4><%out.print(request.getParameter("destination")); %></label><br><br>

<label id = lb3>Car: </label>
<label id = lb4><%out.print(request.getAttribute("carname")); %></label><br><br>

<label id = lb3>Car Number: </label>
<label id = lb4><%out.print(request.getAttribute("nameplate")); %></label><br><br>

<label id = lb3>Fare: </label>
<label id = lb4><%out.print(request.getAttribute("fare")); %></label><br><br>

<br>
<label id = lb5>Have a safe journey........</label>
</div>
</div></div>
</body>
</html>