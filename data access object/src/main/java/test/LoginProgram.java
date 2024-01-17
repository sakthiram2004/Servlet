package test;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class LoginProgram extends HttpServlet
{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try
		{
			String name=req.getParameter("name");
			String pass=req.getParameter("pass");
			Connection con = DAOconnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from user_login where user_name = ? and password = ?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				pw.println("login successfully");
				RequestDispatcher rd = req.getRequestDispatcher("abcd2");
	            rd.forward(req, res);
			}
			else
			{
				res.getWriter().println("<h2>invalid Login</h2>");
                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.include(req, res);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	}
