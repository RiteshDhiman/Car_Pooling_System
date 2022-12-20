

import java.awt.Taskbar.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ride extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			RequestDispatcher rd= request.getRequestDispatcher("user_summary.jsp");
			int fare=1;
			String nameplate=null,pickup=null,destination=null,Drivername=null,carname=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu","root","Iw@ntGoogle#01");
			Statement st= con.createStatement();
			ResultSet rs1= st.executeQuery("SELECT * from ownersdata1");
			while(rs1.next()) {
				if(rs1.getString(14).equals(request.getParameter("uname"))) {
					Drivername= rs1.getString(1);
					carname= rs1.getString(11);
					nameplate= rs1.getString(7);
					fare=fare*rs1.getInt(9);
				}
			}
			ResultSet rs2= st.executeQuery("SELECT * from usersdata");
			while(rs2.next()) {
				if(rs2.getString(2).equals(request.getParameter("uname"))) {
					pickup= rs2.getString(4);
				}
			}
			destination= request.getParameter("destination");
//			if already present....
			String name= request.getParameter("uname");
			boolean flag=false;
			ResultSet rs= st.executeQuery("SELECT * from rides");
			request.setAttribute("Drivername", Drivername);
			request.setAttribute("carname", carname);
			request.setAttribute("nameplate", nameplate);
			request.setAttribute("fare", fare);
			request.setAttribute("pickup", pickup);
			request.setAttribute("destination", destination);

			
			
			while(rs.next()) {
				if(rs.getString(1).equals(name)) {
//					update
					String updatequery= String.format("UPDATE rides SET destination='%s', fare=%d where name='%s'",request.getParameter("destination"),fare,name );
					int i=st.executeUpdate(updatequery);
					flag=true;
					if(i!=0){
//						successfully updated
						rd.forward(request, response);
					}
					else {
						out.print("Error Occured!");
					}
				}
			}
			
//			if not present
			if(!flag){
//				INSERT QUERY
				String insertquery=String.format("INSERT into rides values('%s','%s','%s','%s','%s',%d)", name, pickup, destination, Drivername, nameplate, fare );
				int a= st.executeUpdate(insertquery);
				if(a!=0) {
//					Successfully inserted
					rd.forward(request, response);
				}
				else {
//					error
					out.print("Error Occured!");
				}
			}
		}
		catch(Exception e){
			out.print("Exception hai bete!: "+e.getMessage());
		}
	}

}
