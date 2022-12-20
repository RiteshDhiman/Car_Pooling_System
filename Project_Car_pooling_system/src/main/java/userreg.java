

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

public class userreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			RequestDispatcher rd= request.getRequestDispatcher("user.jsp");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu","root","Iw@ntGoogle#01");
			Statement st= con.createStatement();
			String q= String.format("INSERT into usersdata values(%d,'%s','%s','%s')",6,request.getParameter("name"),request.getParameter("password"),request.getParameter("location"));
			int a=st.executeUpdate(q);
			if(a!=0) {
				out.print("REGISTRATION SUCCESSFULL!");
			}
		} catch (Exception e) {
			out.print("Exception hai bete!: "+e);
		}
	}
}
