package Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="register",urlPatterns="/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("bname");
		int tel = Integer.parseInt(request.getParameter("btel"));
		String gender = request.getParameter("bgen");

		String email = request.getParameter("bemail");
		String pass = request.getParameter("bpass");

		Connection con;
		PrintWriter pw = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop?autoReconnect=true&&useSSL=false","root","password");
		     PreparedStatement ps ;
		     
		     String que = "Insert into register (name,contact,email,password,gender) values(?,?,?,?,?)";		     
		     ps = con.prepareStatement(que);
		     ps.setString(1, name);
		     ps.setInt(2, tel);
		     ps.setString(5, gender);
		     ps.setString(3, email);
		     ps.setString(4, pass);

		     int count = ps.executeUpdate();
		     if(count>0) { 
		    	 RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					rd.forward(request, response);
		    	 pw.println("<html> <head>\r\n"
				 		+ "    <!-- Required meta tags -->\r\n"
				 		+ "    <meta charset=\"utf-8\">\r\n"
				 		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				 		+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				 		+ "\r\n"
				 		+ "    <!-- Bootstrap CSS -->\r\n"
				 		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
				 			+ "    <title></title>\r\n"
				 		+ "  </head><body>");
				 pw.println("<div class='container m-3'> <div class=\"alert alert-success container align-item-center m-2 alert-dismissible\">\r\n"
				 		+ "    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
				 		+ "    <strong>Success!</strong> Created Account Sucessfully.\r\n"
				 		+ "  </div></div><br>");
				 
			 } else {
				 pw.println(" <div class='container m-3'><div class=\"alert alert-danger container align-item-center m-2 alert-dismissible\">\r\n"
				 		+ "    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\"></button>\r\n"
				 		+ "    <strong>Error!</strong>  Failed to create Account\r\n"
				 		+ "  </div></div><br>");

			 }
		     
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
