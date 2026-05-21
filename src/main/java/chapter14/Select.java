package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Select
 */
@WebServlet("/chapter14/select")
public class Select extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		request.setCharacterEncoding("UTF-8");
		int count =Integer.parseInt(request.getParameter("count"));
		String payment = request.getParameter("payment");
		String review = request.getParameter("review");
		String mail = request.getParameter("mail");
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/chapter14");
			Connection con = ds.getConnection();

			PreparedStatement ps = con.prepareStatement("INSERT INTO registration (count,payment,review,mail) values (?,?,?,?)");
			ps.setInt(1, count);
			ps.setString(2, payment);
			ps.setString(3, review);
			ps.setString(4, mail);
			ps.executeUpdate();
			
			ps.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println("<p>" + count + "</p>");
		out.println("<p>" + payment + "</p>");
		
		if(review != null && !review.isEmpty()) {
			out.println("<p>ご感想ありがとうございます</p>");
			out.println("<p>「" + review + "」</p>");
		}else{
			out.println();
		}
		
		if(mail != null && !mail.isEmpty()) {
			out.println("<p>メールを送信します。</p>");
		}else{		
			out.println("<p>メールは送信しません</p>");
		}
		
		
		
		Page.footer(out);
	}

}
