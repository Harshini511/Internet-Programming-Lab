import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class LogoutServlet extends HttpServlet
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
			HttpSession session=req.getSession(); 
			session.invalidate();  
            out.print("<h3>You are successfully logged out!</h3>");  
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
