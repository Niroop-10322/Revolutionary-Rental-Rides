package project1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class history
 */
public class history extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","root");
			pw.println("History");
			String view="select * from contents";
			PreparedStatement pre=con.prepareStatement(view);
			ResultSet rs= pre.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("name");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String id=rs.getString("id");
				String comp=rs.getString("company");
				pw.println(name+"\n"+email+"\n"+phone+"\n"+id+"\n"+comp+"\n\n");
			}
		}catch(SQLException e)
		{
			pw.println(e);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
