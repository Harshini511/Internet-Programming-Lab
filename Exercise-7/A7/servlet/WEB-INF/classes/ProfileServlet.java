import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class ProfileServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String n=req.getParameter("uname");
		String p=req.getParameter("psw");
		Connection conn=null;
		try{
			String url="jdbc:mysql://localhost:3306/sample";
			String user="root";
			String password="Life.123#";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			HttpSession session=req.getSession(false);  
			if(session!=null){  
				String name=(String)session.getAttribute("name");  
				out.print("<h3>Welcome "+name+" to the Profile Page!</h3><br>"); 
				String msg="select * from admindb where name=?";
				PreparedStatement ss=conn.prepareStatement(msg);
				ss.setString(1,name);
				ResultSet ress=ss.executeQuery(); 
				out.println("<html><body>");  
				out.println("<table border=1>");  
				out.println("<tr><th>Name</th><th>Password</th><th>Gender</th><th>DOB</th><th>Phone.No</th><th>Address</th><tr>");  
				String s1,s2,s3,s4,s5,s6;
				if(ress.next())
				{
					s1=ress.getString(1);
					s2=ress.getString(2);
					s3=ress.getString(3);
					s4=ress.getString(4);
					s5=ress.getString(5);
					s6=ress.getString(6);
					out.print("<tr><td>" + s1 + "</td><td>" + s2 + "</td><td>" + s3 + "</td><td>" + s4 + "</td><td>" + s5 + "</td><td>" + s6 + "</td></tr>");
				}
				out.println("</table><br>");
				out.print("<a href=\"index.html\">Login Page</a>");
				out.println("</body></html>");  
				ress.close();
				ss.close();				
				out.close();
				
				} 
				
			
            
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				if(conn!=null)
				{
					conn.close();
			}}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
            
		
	}
}
