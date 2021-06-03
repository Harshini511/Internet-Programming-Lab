import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.util.*;
public class AjaxCountryList extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String query = (String)req.getParameter("val");
		Connection conn=null;
		try{
			String url="jdbc:mysql://localhost:3306/sample";
			String user="root";
			String password="Life.123#";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			String msg="select name from country where name like '"+query+"%'";
            PreparedStatement st=conn.prepareStatement(msg);
			ResultSet ress = st.executeQuery();
			out.print("<datalist id=\"listc\">");
            while(ress.next())
			{
				out.print("<option value=\""+ress.getString(1)+"\">");
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
