import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class View extends HttpServlet
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
			String msg="select * from Patient_Details";
            PreparedStatement ss=conn.prepareStatement(msg);
            ResultSet ress=ss.executeQuery(); 
			out.println("<html><body>");  
            out.println("<table border=1>");  
            out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Address</th><th>Marital Status</th><th>Date of visit</th><th>Disease Name</th><tr>");  
			String s1,s2,s3,s4,s5,s6,s7,s8;
            while(ress.next())
            {
                s1=ress.getString(1);
				s2=ress.getString(2);
				s3=ress.getString(3);
				s4=ress.getString(4);
				s5=ress.getString(5);
				s6=ress.getString(6);
				s7=ress.getString(7);
				s8=ress.getString(8);
                out.print("<tr><td>" + s1 + "</td><td>" + s2 + "</td><td>" + s3 + "</td><td>" + s4 + "</td><td>" + s5 + "</td><td>" + s6 + "</td><td>" + s7 + "</td><td>" + s8 + "</td></tr>");
            }
			out.println("</table>");  
			out.println("</body></html>");  
            ss.close();
            ress.close();
			out.print("<form name=\"myForm\" action=\"home.html\" method=\"get\"><input type=\"submit\" value=\"Home\">");
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
