

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OwnerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel = 'stylesheet' href = 'ownerlogin-1.css' type = 'text/css'");
		out.println("</head><body>");
		out.println("<div class = 'main'>");
		out.println("<div class = 'login'>");
		
		out.println("<h2>Owner Login</h2><br>");
		
		out.println("<form action = 'OwnerLogin' method = 'post' id = 'login1'>");
		
		out.println("<label>Enter Owner ID : </label><br>");
		out.println("<input type = 'text' name = 'ownerid' id = 'name' required><br><br>");
		
		out.println("<label>Enter Password : </label><br>");
		out.println("<input type = 'password' name = 'ownerpass' id = 'name' required><br><br>");
		
		
		out.println("<input type = 'submit' value = 'Login' id = 'submitbutton'></form>");
		
		out.println("<form action = 'OwnerRegister' method = 'get' id = 'register1'>");
		out.println("<input type = 'submit' value = 'Register' id = 'register'>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("ownerprofile.jsp");
		request.setAttribute("name", request.getParameter("ownerid"));
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu","root","Iw@ntGoogle#01");
			Statement st= con.createStatement();
			String query="SELECT * from ownersdata1";
			ResultSet rs= st.executeQuery(query);
			boolean flag=false;
			while(rs.next()) {
				if(rs.getString(2).equals(request.getParameter("ownerid")) && rs.getString(3).equals(request.getParameter("ownerpass"))) {
//					login successfull
					flag= true;
					rd.forward(request, response);
				}
			}
			if(!flag) {
				doGet(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
