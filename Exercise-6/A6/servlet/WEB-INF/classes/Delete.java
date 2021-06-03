import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class Delete extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Connection conn=null;
		try{
			String url="jdbc:mysql://localhost:3306/sample";
			String user="root";
			String password="Life.123#";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			String msg="delete from Patient_Details where id=?";
            PreparedStatement ss=conn.prepareStatement(msg);
			ss.setString(1,req.getParameter("id"));
            int i=ss.executeUpdate(); 
			if(i==1)
			{
				out.print("Record Deleted!");
				out.print("<form name=\"myForm\" action=\"View\" method=\"get\"><input type=\"submit\" value=\"View\">");
				
			}
			else
			{
				out.print("Failed!");
				out.print("<form name=\"myForm\" action=\"home.html\" method=\"get\"><input type=\"submit\" value=\"Home\">");
			}
			ss.close();
			out.close();
			
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
