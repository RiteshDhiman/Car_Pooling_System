<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "ownerprocss.css" type = "text/css">
<meta charset="ISO-8859-1">
<title>Owner Profile</title>
</head>
<body>

 <div class="card">
  <img src="https://media.istockphoto.com/id/526947869/vector/man-silhouette-profile-picture.jpg?s=612x612&w=0&k=20&c=5I7Vgx_U6UPJe9U2sA2_8JFF4grkP7bNmDnsLXTYlSc=">
  <%
  	String name=null,password=null,car=null,carnum=null;
  	try{
  		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu","root","Iw@ntGoogle#01");
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("SELECT * from ownersdata1");
		
		while(rs.next()){
			if(rs.getString(2).equals(request.getAttribute("ownerid"))){
				name= rs.getString(1);
				password= rs.getString(3);
				car=rs.getString(11);
				carnum= rs.getString(7);
				break;
			}
		}
  	}
	catch(Exception e){
		out.print(e);
	}
        out.print("Name: Shiv Kumar"); 
		  out.print("<p>Password: shiv@123</p>"); 
		  out.print("<p>Car: Wagon-R</p>");
		  out.print("<p>Car Number: "+carnum+"</p>"); 
		  out.print("<p>Status :BUSY</p>");
  	
  %>
  
</div>
</body>
</html>