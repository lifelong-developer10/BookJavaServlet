package Booking;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet  {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("bname");
		int edition = Integer.parseInt(request.getParameter("bedit"));
		float price = Float.parseFloat(request.getParameter("bcost"));
         String genres= request.getParameter("bgenres");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookShop?autoReconnect=true&useSSl=false","root","password");
            String query = "Update book set name=?,edition=?,price=?,genres=? where id=?";
    		  PreparedStatement pst = con.prepareStatement(query);
    		  pst.setString(1, name);
    		  pst.setInt(2, edition);
    		  pst.setFloat(3, price);
    		  pst.setString(4, genres);
    		  pst.setInt(5, id);
    		  
    		  
    		  int count = pst.executeUpdate();
    		  if(count>0) {
    			  RequestDispatcher rd = request.getRequestDispatcher("BookList");
					rd.forward(request, response);
    		  }
    		  else {
    			  pw.println("<h2>Record Not Updated</h2>");

    		  }
      		ResultSet res= pst.executeQuery();
      		res.next();

		
		}catch(Exception e) {
			e.printStackTrace();
		}
		


	}
 

}



