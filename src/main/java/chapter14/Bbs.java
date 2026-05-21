package chapter14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bbs
 */
@WebServlet("/chapter14/bbs")
public class Bbs extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/chapter14");
			Connection con = ds.getConnection();

			String name = request.getParameter("name");
			String content = request.getParameter("content");

			if (name == null && name.isEmpty()) {

			}
			if (content == null && content.isEmpty()) {

			}

			PreparedStatement ps = con.prepareStatement("INSERT INTO posts(name,content) VALUES (?,?)");
			ps.setString(1, name);
			ps.setString(2, content);
			ps.executeUpdate();
			
			response.sendRedirect("/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			request.setCharacterEncoding("UTF-8");

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/chapter14");
			Connection con = ds.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM posts order by post_date");
			ResultSet rs = ps.executeQuery();
			
			String rsName = rs.getString("name");
			String content = rs.getString("content");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			

	}

}
