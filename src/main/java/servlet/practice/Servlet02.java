package servlet.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ServletConnection1")
public class Servlet02 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, 
							HttpServletResponse resp)
							throws ServletException, IOException {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		try(
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://13.125.254.147:3306/studydb",
			"study", "1111");			
			PreparedStatement stmt = con.prepareStatement(
                    "select mid, email from pms2_member");
                ResultSet rs = stmt.executeQuery();) {
                
                while (rs.next()) {
                   
                	System.out.println(rs.getString("mid"));
                    System.out.println(rs.getString("email"));
       
                }
		}
		
		
		}catch(Exception e) {
			
		}
		
	}

}
