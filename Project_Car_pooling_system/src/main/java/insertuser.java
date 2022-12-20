

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insertuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			RequestDispatcher rd= request.getRequestDispatcher("user.jsp");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu","root","Iw@ntGoogle#01");
			Statement st= con.createStatement();
			String insertquery=String.format("INSERT into usersdata values(6,'%s','%s','%s',0)", request.getParameter("uname"),request.getParameter("password"),request.getParameter("location"));
			int a=st.executeUpdate(insertquery);
			if(a!=0) {
				rd.forward(request, response);
			}
			else {
				out.print("Error!");
			}
		} catch (Exception e) {
			out.print(e);
		}
	}

}
