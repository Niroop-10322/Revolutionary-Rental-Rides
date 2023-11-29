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
import java.sql.SQLException;

/**
 * Servlet implementation class removebike
 */
public class removebike extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		PrintWriter pw=response.getWriter();
		pw.println(id);
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","root");
			pw.println("Success");
			String delete="DELETE from contents where id= ? ";
;
			PreparedStatement pre=con.prepareStatement(delete);
			pre.setString(1, id);
			pre.executeUpdate();
			pre.close();
			pw.println("delete success");
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
