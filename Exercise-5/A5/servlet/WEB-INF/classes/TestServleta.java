import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class TestServleta extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("fname");
		String username=req.getParameter("user");
		String email=req.getParameter("em");
		String d=req.getParameter("dob");
		String additional=req.getParameter("exp");
		out.print("<h1>Your Details</h1><br>");
		out.print("<h3><table><tr><td>Name:</td><td>"+name+"</td></tr><tr><td>User Name:</td><td>"+username+"</td></tr><tr><td>E-Mail:</td><td>"+email+"</td></tr><tr><td>DOB:</td><td>"+d+"</td></tr><tr><td>Additional Expertise:</td><td>"+additional+"</td></tr></table></h3>");
		out.close();
	}
}
