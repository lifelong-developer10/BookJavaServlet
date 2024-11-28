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

@WebServlet(urlPatterns="/Register")
public class Register extends HttpServlet {
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name= request.getParameter("bname");
		String edition= request.getParameter("bedit");
		float price= Float.parseFloat(request.getParameter("bcost"));
		String genres = request.getParameter("bgenres");
		String cover = request.getParameter("bcover");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookShop?autoReconnect=true&useSSl=false","root","password");
            String query = "INSERT INTO BOOK (name,edition,price,genres,book_cover) VALUES(?,?,?,?,?)";
    		  PreparedStatement pst = con.prepareStatement(query);
      		pst.setString(1,name);
    		pst.setString(2,edition);
    		pst.setFloat(3,price);
    		pst.setString(4,genres);
    		pst.setString(5,cover);
            int res = pst.executeUpdate();
		if(res>0) {
			 RequestDispatcher rd = request.getRequestDispatcher("BookList");
				rd.forward(request, response);
		}else {
			pw.println("<h2>Book is  not recorded</h2>");

		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		pw.println("<a href='Home.html'>Home</a>");

		pw.println("<a href='BookList'>Book List</a>");
	}

}
