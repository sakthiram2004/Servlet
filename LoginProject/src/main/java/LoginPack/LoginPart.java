package LoginPack;
import java.io.*;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LoginPart extends HttpServlet {
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException 
	 {
	        res.setContentType("text/html");
	        String name = req.getParameter("name");
	        String password = req.getParameter("pass");
	        
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	String url = "jdbc:mysql://localhost:3306/login";

	            Connection con = DriverManager.getConnection(url, "root", "Secure@54321");
	            PreparedStatement ps = con.prepareStatement("select * from  user_info where user_name = ? and password = ?");
	            ps.setString(1, name);
	            ps.setString(2, password);
	            

	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                
	                RequestDispatcher rd = req.getRequestDispatcher("abcd1");
	                rd.forward(req, res);
	            } else {
	            	res.getWriter().println("<h2>invalid Login</h2>");
	                RequestDispatcher rd = req.getRequestDispatcher("index.html");
	                rd.include(req, res);
	            }

	        } catch (Exception e) {
	        	
	            e.printStackTrace(); // Handle the exception properly in a real application
	        }
	    }
	}