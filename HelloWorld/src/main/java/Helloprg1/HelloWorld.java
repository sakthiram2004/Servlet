package Helloprg1;
import java.io.*;
import javax.servlet.http.*;
 

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
public class HelloWorld extends HttpServlet{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException
	{
		res.setContentType("text/html");
		res.getWriter().println("hello");
	}

}
