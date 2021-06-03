import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class Add extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String n=req.getParameter("uname");
		String username=req.getParameter("psw");
		Connection conn=null;
		try{
			String url="jdbc:mysql://localhost:3306/sample";
			String user="root";
			String password="Life.123#";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			String msg="insert into Patient_Details values(?,?,?,?,?,?,?,?)";
            PreparedStatement st=conn.prepareStatement(msg);
			st.setString(1,req.getParameter("id"));
			st.setString(2,req.getParameter("n"));
			st.setString(3,req.getParameter("a"));
			st.setString(4,req.getParameter("g"));
			st.setString(5,req.getParameter("addr"));
			st.setString(6,req.getParameter("ms"));
			st.setString(7,req.getParameter("d"));
			st.setString(8,req.getParameter("dis"));
			int i = st.executeUpdate();
			out.print(i);
			if(i==1)
			{
				out.print("Record added!");
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
