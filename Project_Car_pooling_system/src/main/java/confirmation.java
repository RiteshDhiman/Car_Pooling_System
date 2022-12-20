

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

public class confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		checking for user details.
		PrintWriter out= response.getWriter();
		try {
			RequestDispatcher rd= request.getRequestDispatcher("user.jsp");
			RequestDispatcher rd1= request.getRequestDispatcher("userride.jsp");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu","root","Iw@ntGoogle#01");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery("SELECT * from usersdata");
			boolean flag=false;
			while(rs.next()){
				if(rs.getString(2).equals(request.getParameter("name")) && rs.getString(3).equals(request.getParameter("password"))) {	
					rd1.forward(request, response);
					flag= true;
				}
			}
			if(flag==false) rd.forward(request, response);
		} catch (Exception e) {
			out.print("Exception hai bete!: "+e);
		}
	}
}
