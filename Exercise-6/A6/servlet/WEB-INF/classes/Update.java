import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class Update extends HttpServlet
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
			String msg="update Patient_Details set address=? where id=?";
            PreparedStatement st=conn.prepareStatement(msg);
			st.setString(1,req.getParameter("a"));
			st.setString(2,req.getParameter("id"));
			int i = st.executeUpdate();
			if(i==1)
			{
				out.print("Record Updated!");
				out.print("<form name=\"myForm\" action=\"View\" method=\"get\"><input type=\"submit\" value=\"View\">");
			}
			out.close();
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
