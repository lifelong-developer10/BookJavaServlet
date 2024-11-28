package Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet  {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookShop?autoReconnect=true&useSSl=false","root","password");
            String query = "Delete  from book where id=?";
    		  PreparedStatement pst = con.prepareStatement(query);
    		 
    		  pst.setInt(1, id);
    		  
    		  int count = pst.executeUpdate();
    		  if(count>0) {
    			  RequestDispatcher rd = request.getRequestDispatcher("BookList");
  				rd.forward(request, response);
    		  }
    		  else {
    			  pw.println("<h2>Record Not Deleted</h2>");

    		  }
      		ResultSet res= pst.executeQuery();
      		res.next();

		
		}catch(Exception e) {
			e.printStackTrace();
		}
		pw.println("<a href='Home.html'>Home</a>");
		pw.println("<a href='BookList'>BookList</a>");


	}
  

}
