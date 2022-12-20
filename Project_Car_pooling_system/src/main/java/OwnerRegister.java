

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OwnerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><head>");
		out.println("<link rel = 'stylesheet' href = 'ownerreg.css ' type ='text/css'>");
		out.println("</head><body>");
		
		out.println("<div class = 'main'>");
		out.println("<div class = 'register'>");
		out.println("<form method = 'post' action = 'OwnerRegister' id = 'register'>");
		out.println("<h1>Owner Registration</h1>");
		
		out.println("<label>Enter name:</label><br>");
		out.println("<input type = 'text' id = 'name' name = 'ownername' required><br><br>");
		
		out.println("<label>Enter UserID:</label><br>");
		out.println("<input type = 'text' id = 'name' name = 'uid' required><br><br>");
		
		out.println("<label>Enter password:</label><br>");
		out.println("<input type = 'password' id = 'name' name = 'password' required><br><br>");
		
		out.println("<label>Enter Phone Number:</label><br>");
		out.println("<input type = 'tel' id = 'name' name = 'pno' required><br><br>");
		
		out.println("<label>Enter Email ID:</label><br>");
		out.println("<input type = 'text' id = 'name' name = 'email' required><br><br>");
		
		out.println("<label>Enter License Number:</label><br>");
		out.println("<input type = 'text' id = 'name' name = 'licenseno' required><br><br>");
		
		out.println("<label>Enter Car Registration Number:</label><br>");
		out.println("<input type = 'text' id = 'name' name = 'carno' required><br><br>");
		
		out.println("<label>Enter Source Address:</label><br>");
		out.println("<input type = 'text' id = 'name' name = 'srcadd' required><br><br>");
		
		out.println("<label for='fare'>Choose Fare:</label><br>\r\n"
				+ "\r\n"
				+ "<select name=\"fare\" id=\"fare\" required>\r\n"
				+ "  <option>10</option>\r\n"
				+ "  <option>12</option>\r\n"
				+ "  <option>15</option>\r\n"
				+ "  <option>17</option>\r\n"
				+ "  <option>20</option>\r\n"
				+ "  <option>25</option>\r\n"
				+ "</select><br><br>");
		
		out.println("<label for='cars'>Choose Car Brand:</label><br>\r\n"
				+ "\r\n"
				+ "<select name=\"cars\" id=\"cars\" required>\r\n"
				+ "  <option value=\"suzuki\">Maruti Suzuki</option>\r\n"
				+ "  <option value=\"ford\">Ford</option>\r\n"
				+ "  <option value=\"tata\">Tata</option>\r\n"
				+ "  <option value=\"mahindra\">Mahindra</option>\r\n"
				+ "  <option value=\"hyundai\">Hyundai</option>\r\n"
				+ "  <option value=\"honda\">Honda</option>\r\n"
				+ "  <option value=\"toyota\">Toyota</option>\r\n"
				+ "  <option value=\"kia\">Kia</option>\r\n"
				+ "  <option value=\"volkswagen\">Volkswagen</option>\r\n"
				+ "  <option value=\"nissan\">Nissan</option>\r\n"
				+ "  <option value=\"renault\">Renault</option>\r\n"
				+ "  <option value=\"citroen\">Citroen</option>\r\n"
				+ "  <option value=\"other\">Other...</option>\r\n"
				+ "</select><br><br>");
		
		out.println("<label>Enter Car Name:</label><br>");
		out.println("<input type = 'text' id = 'name' name = 'carname' required><br><br>");
		
		out.println("<label for = 'cmodel'>Choose Car Model </label><br>\r\n"
				+"\r\n"
				+"<select name = 'cmodel' id = 'cmodel' required>\r\n"
				+"<option value = '2022'>2022</option>\r\n"
				+"<option value = '2021'>2021</option>\r\n"
				+"<option value = '2020'>2020</option>\r\n"
				+"<option value = '2019'>2019</option>\r\n"
				+"<option value = '2018'>2018</option>\r\n"
				+"<option value = '2017'>2017</option>\r\n"
				+"<option value = '2016'>2016</option>\r\n"
				+"<option value = '2015'>2015</option>\r\n"
				+"<option value = '2014'>2014</option>\r\n"
				+"<option value = '2013'>2013</option>\r\n"
				+"<option value = '2012'>2012</option>\r\n"
				+"<option value = '2011'>2011</option>\r\n"
				+"<option value = '2010'>2010</option>\r\n"
				+"<option value = '2009'>2009</option>\r\n"
				+"<option value = '2008'>2008</option>\r\n"
				+"<option value = 'older'>Older</option>\r\n"
				
				
				+ "</select><br><br>");
		
		
		out.println("<label for = 'seats'>Choose Seating Capacity </label><br>\r\n"
				+"\r\n"
				+"<select name = 'seats' id = 'seats' required>\r\n"
				+"<option value = '4'>4</option>\r\n"
				+"<option value = '5'>5</option>\r\n"
				+"<option value = '7'>7</option>\r\n"
				+ "</select><br><br>");
		
		out.println("<input type = 'submit' id = 'submit' value = 'Register'>");
		out.println("</form>");
		out.println("</div></div>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu","root","Iw@ntGoogle#01");
			
			String name = request.getParameter("ownername");
			String userid = request.getParameter("uid");
			String pass = request.getParameter("password");
//			int pno = Integer.parseInt(request.getParameter("pno"));
			String email = request.getParameter("email");
			String licenseno = request.getParameter("licenseno");
			String carregno = request.getParameter("carno");
			String srcadd = request.getParameter("srcadd");
			int fare = Integer.parseInt(request.getParameter("fare")); 
			String carbrand = request.getParameter("cars");
			String carname = request.getParameter("carname");
			int carmodel = Integer.parseInt(request.getParameter("cmodel"));
			int seats = Integer.parseInt(request.getParameter("seats"));
			
			String query = "insert into ownersdata1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1,name);
			pstm.setString(2,userid);
			pstm.setString(3,pass);
//			pstm.setInt(4,pno);
			pstm.setInt(4, 0);
			pstm.setString(5,email);
			pstm.setString(6,licenseno);
			pstm.setString(7,carregno);
			pstm.setString(8,srcadd);
			pstm.setInt(9,fare);
			pstm.setString(10,carbrand);
			pstm.setString(11,carname);
			pstm.setInt(12,carmodel);
			pstm.setInt(13,seats);
			pstm.setString(14,"ritesh");

			int x = pstm.executeUpdate();
			
			out.println("<html>");
			out.println("<body>");
			if(x!=0) {
				out.println("<h2>Registration Successful<h2>");
			}
			else {
				out.println("<h2>Registration Failed<h2>");
			}
			out.println("</body></html>");
			con.close();
					
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		doGet(request, response);
		
		
		
	}

}
