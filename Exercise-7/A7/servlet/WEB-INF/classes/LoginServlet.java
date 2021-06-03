import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
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
			String msg="select * from admindb where name='"+n+"' and pw='"+p+"'";
            PreparedStatement st=conn.prepareStatement(msg);
			ResultSet ress = st.executeQuery();
            if(ress.next())
			{
				HttpSession session=req.getSession();  
				session.setAttribute("name",n);  
				out.print("<h3>Welcome "+n+"!</h3>");
				out.print("<a href='ProfileServlet'>View Profile in detail</a>");
			}
			else
			{
				out.print("invalid credentials");
				req.getRequestDispatcher("login.html");
			}
			out.close();
			ress.close();
			st.close();
            
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
					out.close(); 
			}}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
            
		
	}
}
