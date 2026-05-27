package chapter14;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

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
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		//文字化け対策
			request.setCharacterEncoding("UTF-8");
			
			Connection con = null;
			PreparedStatement ps = null;
		try {
			//DB接続
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/chapter14");
			con = ds.getConnection();
			
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			
			//登録
			ps = con.prepareStatement("INSERT INTO posts (name,content,post_date) VALUES (?,?,?)");
			ps.setString(1, name);
			ps.setString(2, content);
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) 
				try {
					ps.close();
				} catch (Exception e) {
				}
			if(con != null) 
				try {
					ps.close();
				} catch (Exception e) {
				}
		}
		//リダイレクト
		response.sendRedirect(request.getContextPath() + "/chapter14/index.jsp" );

	}

}
