 package test;
 import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class DisplayServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try
		{
			String name=req.getParameter("name");
			String pass=req.getParameter("pass");
			Connection con = DAOconnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from user_details where user_name = ? and password = ?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				pw.println("<h1>--------USER DETAILS------------</h1>");
				pw.println("<h1>-name=</h1> " + rs.getString(1));
				pw.println("<h1>-Email ID=</h1> " + rs.getString(2));
				pw.println("<h1>-Phone=</h1> " + rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

}


}
