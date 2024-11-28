package Booking;

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
@WebServlet("/EditBook")
public class EditBook extends HttpServlet  {

	
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
            String query = "SELECT * FROM BOOK WHERE ID=?";
    		  PreparedStatement pst = con.prepareStatement(query);
    		  pst.setInt(1, id);
    		  
      		ResultSet res= pst.executeQuery();
      		res.next();
      		pw.println("<!DOCTYPE html>\r\n"
      				+ "<html lang=\"en\">\r\n"
      				+ "<head>\r\n"
      				+ "  <title>Online Book Shop</title>\r\n"
      				+ "  <meta charset=\"utf-8\">\r\n"
      				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
      				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
      				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
      				+ "<style>\r\n"
      				+ "body{\r\n"
      				+ "background-image:url('https://distrito.me/wp-content/uploads/2022/05/10-livros-sobre-inovacao-para-ler-em-2022.jpeg');\r\n"
      				+ "background-repeat:no-repeat;\r\n"
      				+ "background-size:cover;\r\n"
      				+ "\r\n"
      				+ "}\r\n"
      				+ ".formtable{\r\n"
      				+ "margin-left:60px;\r\n"
      				+ "\r\n"
      				+ "}\r\n"
      				+ ".sub{\r\n"
      				+ "margin-right:100px;\r\n"
      				+ "}\r\n"
      				+ "</style>\r\n"
      				+ "</head>\r\n"
      				+ "<body>\r\n"
      				+ "</head>\r\n"
      				+ "<body>\r\n"
      				+ "<div class =\"container-fluid \">\r\n"
      				+ "<nav class=\"navbar navbar-expand-sm navbar-dark text-white bg-dark shadow-lg\">\r\n"
      				+ "  <div class=\"container-fluid text-white\">\r\n"
      				+ "    <a class=\"navbar-brand\" ><img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQi8hvS8hRnS_UEmIB2OmhA2gwLN23IIbGoM4vMqO7BxZCH5VuMwIvxxkZHHDnrw0d9Mkw&usqp=CAU' width=\"35px\" height=\"35px\" class=\"rounded-2\">\r\n"
      				+ "   </a>\r\n"
      				+ "    <div class=\"collapse navbar-collapse\" >\r\n"
      				+ "      <ul class=\"navbar-nav me-auto text-white\">\r\n"
      				+ "        <li class=\"nav-item\">\r\n"
      				+ "          <a class=\"nav-link\" href=\"Dashboard.html\" >Home</a>\r\n"
      				+ "        </li>\r\n"
      				+ "        <li class=\"nav-item\">\r\n"
      				+ "          <a class=\"nav-link\" href=\"BookList\" >Books</a>\r\n"
      				+ "        </li>\r\n"
      				+ "        <li class=\"nav-item\">\r\n"
      				+ "          <a class=\"nav-link\" href=\"AboutUs.html\" >About Us</a>\r\n"
      				+ "        </li>\r\n"
      				+ "         <li class=\"nav-item\">\r\n"
      				+ "          <a class=\"nav-link\" href=\"TermsandCondition.html\">Terms</a>\r\n"
      				+ "        </li>\r\n"
      				+ "         <li class=\"nav-item\">\r\n"
      				+ "          <a class=\"nav-link\" href=\"UsersServlet\">Users</a>\r\n"
      				+ "        </li><li class=\"nav-item\">\r\n"
      				+ "          <a class=\"nav-link\" href=\"Home.html\">Add Book</a>\r\n"
      				+ "        </li>\r\n"
      				+ "      </ul>\r\n"
      				+ "      <form class=\"d-flex \">\r\n"
      				+ "        <input class=\"form-control me-2 bg-light \" type=\"text\" placeholder=\"Search..\">\r\n"
      				+ "        <button class=\"btn btn-secondary shadow-lg text-bold\" type=\"button\">Search</button>\r\n"
      				+ "      </form>\r\n"
      				+ "    </div>\r\n"
      				+ "  </div>\r\n"
      				+ "</nav>\r\n"
      				+ "\r\n"
      				+ "\r\n"
      				+ "</div>\r\n"
      				+ "</div>\r\n"
      				+ "</div>\r\n"
      				+ "</div>\r\n"
      				+ "<div class=\"container row mt-2 p-2 align-item-middle\">\r\n"
      				+ "<div class=\"col-6 m-3 border-dark\">\r\n"
      				+ "<form  action='EditServlet?id="+id+"' method='post'\" class=\"form regisration text-center bg-light rounded-5 shadow-lg text-center  p-2\">\r\n"
      				+ "<h4>Edit Book</h4>\r\n"
      				+ "<br>\r\n"
      				+ "<div class=\"container justify-content-center formtable\">\r\n"
      				+ "<table>\r\n"
      				+ "<tr><td>\r\n"
      				+ " Book Name :</td><td><input type='text' name='bname' class=\"border-dark shadow-lg form-control rounded-4\" value='"+res.getString("name")+"'</td>"
      				+ "</td>\r\n"
      				+ "</tr>\r\n"
      				+ "<tr>\r\n"
      				+ "<td>\r\n"
      				+ "Edition :</td><td><input type='number' name='bedit' class=\"border-dark shadow-lg form-control rounded-4\" value='"+res.getInt("edition")+"'</td></tr>\r\n"
      				+ "<tr><td>\r\n"
      				+ "Genres :</td><td><input type=\"text\" name=\"bgenres\" class=\"border-dark shadow-lg form-control rounded-4\" value='"+res.getString("genres")+"' class=\"border-dark shadow-lg form-control rounded-4\"></td>\r\n"
      				+ "</tr><tr>\r\n"
      				+ "<td>\r\n"
      				+ "Price :</td><td><input type='number' name='bcost' class=\"border-dark shadow-lg form-control rounded-4\"  value='"+res.getFloat("price")+"'</td></tr>\r\n"
      				+ "</tr></div>\r\n"
      				+ "</table><br>\r\n"
      				+ "<button type=\"submit\" class=\"btn btn-dark sub\">Submit</button><br>\r\n"
      				+ "</form>\r\n"
      				+ "</div>\r\n"
      				+ "</div>\r\n"
      				+ "\r\n"
      				+ "<div class =\"container-fluid bg-dark fixed-bottom text-white\">\r\n"
      				+ "<div class=\"container \">\r\n"
      				+ "<h4 class=\" text-center mt-2 \">Stay Connected with us</h2>\r\n"
      				+ "<div class=\"row p-2\">\r\n"
      				+ "<div class=\"text-center  col-4\">\r\n"
      				+ "<span>email: emailus@theonlinebookshop.com</span>\r\n"
      				+ "</div>\r\n"
      				+ "\r\n"
      				+ "<div class=\"col-7 text-start\">The Online Bookshop\r\n"
      				+ "                                 Ground Floor, Online Mansion, \r\n"
      				+ "                                     Temple 403001 India\r\n"
      				+ "\r\n"
      				+ "</div>\r\n"
      				+ "<div class=\"col-1 text-start\">@2024\r\n"
      				+ "</div>\r\n"
      				+ "<hr class=\"text-bold\">\r\n"
      				+ "<div class=\"row p-1\">\r\n"
      				+ "<div class=\"col-1 text-end\"><img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQi8hvS8hRnS_UEmIB2OmhA2gwLN23IIbGoM4vMqO7BxZCH5VuMwIvxxkZHHDnrw0d9Mkw&usqp=CAU' width=\"25px\" height=\"25px\" class=\"rounded-2\">\r\n"
      				+ "   </div>\r\n"
      				+ "<div class=\"col-8 text-start \">Copyright © 2024 Online Company L.T.D. All rights reserved.</div>\r\n"
      				+ "<div class=\"col-1 text-end\"><img src=\"data:image/jpeg;base64,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\" width=\"25px\" height=\"25px\" ></div>\r\n"
      				+ "<div class=\"col-1 text-center\"><img src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMwAAADACAMAAAB/Pny7AAAAVFBMVEVHqej///9Cp+j6/f7W6vnw+P1Mq+k8pedjtOvh8Pvk8vv3+/50u+1QrelVr+qg0PKIxO/K5Pey2fWYzPF8v+7A4fe53fap1PMroOaOyPBquOzP6fmaFgHaAAAFC0lEQVR4nO3c2ZajKhQGYN2A4BCcNZr3f88DSarNoBGiBdZZ++u+qItaiX9gyxCsIEAIIYQQQgghhBBCCCGEEEIIIYQQQgghhBBC6GBAuf0Q3X/4q9Tly7Go+6qq+rwY5WyePxIRTlnd0iQNtTShbd5I/vo7cIq8XJwdgKyiLHyUxl0TPcXhpyEXri/s9QNdx2VO0/AVSSrx77WA86JNupPbjsbHwjYNF+V7lGsc2txei595cWEhs37pjc4dGe3ekmfxbBSNDWeukozVtZpa6bphkpAJmzR8nG+Wu0EW3b2aksxxw/Bev+to/gnykX3K8tjpcsdZQJb6fWlmmobL5T72onVc/ar/J9c3vmRmvw9RZ5qF6nEHwOFIA8O9AGhj9DHCYNrJqOAAXBbNb0eYRP1PNceFQRoQF7MopBRnHjV5adrkOwDZkZ/3TwaD2WJt1jCsF+PQlUmY1u7qBmRLpiuo1ioWRGnWLnFJYx2brL7kjp7ChKQdPzcONIlhL/t5QZej5nMYVThD8GlsOPWm5X9zsZxbbPNYM1dpK/nih3kflIxRi7F4jzBRRV6uIBmipUuAkVplEY4HTajfJ1pltrQKboxHf53lY4/9DbyYqYJULbNm4xSG9a9fo13urr8WZr7nJFUj3xfw5sN/mOQetjgW51pJO4zRy4drEaZbLLzfxIel1QmjVSH4Yx6LMJWXnQw4Ld+h0qSsCsmnQOY14ydMwOtPF0VYXOYZnNVimAeQGd+aPYUJ+Nr9lqQs7mp1RzibD5rewgjTKyTs4+r/CGFWOtpXSO8njC5u46WwqTT3EeU0SgAQ7esMbSNWe8iiVlutGkzOojOuBiNJ4SUMDVPa11lW2a1UVsQOtzGmMLebbZpcLruGcbySuTu9rWd2UbpeylxBvm+x3Djdx5jMrmc2Y17uzGr4N9zVs5KYbCj+RprqF8L4qf9p53xPbrfLntLsPpdRkxlfX5lzsfstwPlXmZNzvncY5xtmEwC7fcpVpPN4MENP0PbEBm+9TKex2qlcFfs9Y2KxU7GOVD4bRqfZcXnGnH6PMYdH+V6DZ3n2nEUf3Mm6ZI/WIY3vhtGH+jhk/c8Bsg0u/k/MyVFIKUXRb+5snibMD6KBXsry/hXxtobxsv3/BD6curKSeh0w76aTGtuUXtbLL3ZqGo/z5Se7NI2fjYw3EO0wo4k9LZff7LBII0eo/huebU1T+Y7wgDfb0nhcYM7gRbxhduZrs2wJNO3XjcNy/2P/MxA5/a5xSOdrr2wZBGrq/E0cP/v+ayBQc2frMSe2OrTukH7MR4xFazElYG/PzhwIqGW0xa3A7mEC13hm801H7H0LY5mqGquDpdT1wxjmVJTapv5JafxQhGPAQUWxWQyQ9pD1op+6lLZ3ZdYfZqyEB0GkkpSWsxlauD9WOi+SQp6iSG8xjVmRt9R2m4m1x7mNRWPedlXVtS2NE/OjZFOz1IfpYlrWsZAo1jl0s1Sj/73LR3AqvjwGQMrmaDN+PW356quZSxYcpfKf8PNoNbCEYVqO/JBRNBWni5lZ4RAWV+J8mHvYHM5F3dG1GxpJGe0GyQ8dRQMeZENfxmyhhQhL4jYvxmOWyhs1LQtENuRdqUcdMqVQMWhZ6T/G8M3T9t7oWU10EmNTDHne95X+n9dD0aiZQgB/8M9kXOdp0XTloP/BX0yCEEIIIYQQQgghhBBCCCGEEEIIIYQQQgghhP6//gM5UT0Rlq7HZQAAAABJRU5ErkJggg==\" width=\"25px\" height=\"25px\">\r\n"
      				+ "</div>\r\n"
      				+ "<div class=\"col-1 text-start\"><img src =\"data:image/jpeg;base64,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\" width=\"25px\" height=\"25px\">\r\n"
      				+ "</div>\r\n"
      				+ "</div>\r\n"
      				+ "\r\n"
      				+ "</div>\r\n"
      				+ "</div>\r\n"
      				+ "</body>\r\n"
      				+ "</html>");
      		
		    
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
 

}
