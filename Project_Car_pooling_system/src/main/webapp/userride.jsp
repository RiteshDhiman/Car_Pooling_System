<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "userridecss.css" type = "text/css">
<meta charset="ISO-8859-1">
<title>Enter Destination</title>
</head>
<body>
<div class = "main">
<div class = "userridding">
<form action="ride" method="post" id = "ridding">
<label id = "lb1"><h3>Hello <%=request.getParameter("name")%> !</h3>Where would you like to go today?</label>
<br><br>
<label>Choose a car:</label><br>


	<select name="destinations" required>
		<option value="suzuki">Maruti Suzuki</option>
		<option value="ford">Ford</option>
		<option value="tata">Tata</option>
		<option value="mahindra">Mahindra</option>
		<option value="hyundai">Hyundai</option>
		<option value="honda">Honda</option>
		<option value="toyota">Toyota</option>
		<option value="kia">Kia</option>
		<option value="volkswagen">Volkswagen</option>
	</select>
<br><br>
<label>Choose Destination</label><br>
	<select name="destination" required>
		<option value="Manipal Hospital, Sector-2, Palam-Vihar, Gurgaon, Haryana">Manipal Hospital, Sector-2, Palam-Vihar, Gurgaon, Haryana</option>
		<option value="Vegas Mall, Sector-14, Dwarka, New-Delhi">Vegas Mall, Sector-14, Dwarka, New-Delhi</option>
		<option value="D-21, Metro Station, Sector-21, Dwarka, New-Delhi">D-21, Metro Station, Sector-21, Dwarka, New-Delhi</option>
		<option value="Indira Gandhi Airport, near mahipalpur, New-Delhi">Indira Gandhi Airport, near mahipalpur, New-Delhi</option>
		<option value="Cyber Hub, DLF, Phase-2, Gurgaon, Haryana ">Cyber Hub, DLF, Phase-2, Gurgaon, Haryana </option>
	</select>
	<br><br>
	<input type="hidden" name="uname" value='<%=request.getParameter("name") %>' />
	<input type="submit" value="Ride Now!" id = "ridenow">
	
</form>
</div></div>
</body>
</html>