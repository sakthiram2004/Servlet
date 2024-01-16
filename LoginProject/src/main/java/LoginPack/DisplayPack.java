package LoginPack;
import java.io.*;

import javax.servlet.http.*;
public class DisplayPack extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res)throws IOException
	{
		String name=req.getParameter("name");
		res.setContentType("text/html");
		res.getWriter().println("<h2>Login successful</h2>");
	}


}
