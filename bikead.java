package project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bikead
 */
public class bikead extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String id=request.getParameter("id");
		String company=request.getParameter("company");
		PrintWriter pw=response.getWriter();
		pw.println(name+" "+email+" "+phone+" "+id+" "+company);
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","root");
			pw.println("Success");
			String insert="insert into contents(name,email,phone,id,company) values(?,?,?,?,?)";
			PreparedStatement pre=con.prepareStatement(insert);
			pre.setString(1,name);
			pre.setString(2, email);
			pre.setString(3,phone);
			pre.setString(4, id);
			pre.setString(5, company);
			pre.executeUpdate();
			pre.close();
			pw.println("insert success");
		}
		catch(SQLException e) {
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
