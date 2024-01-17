package test;
import java.sql.*;
public class DAOconnection {
public static Connection con =null;
static {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dao","root","Secure@54321");
		
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}

static Connection getCon()
{
	return con;
}
}
