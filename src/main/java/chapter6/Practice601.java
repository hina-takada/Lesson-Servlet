package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Practice601
 */
@WebServlet("/chapter6/practice601")
public class Practice601 extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String destination = request.getParameter("destination");
		int days = Integer.parseInt(request.getParameter("days"));
		String transport = request.getParameter("transport");
		String campaing = request.getParameter("campaing");
		
		Page.header(out);
		
		out.println("<p>「" + destination + "」への旅行を" + days +"日間、"
				+ "交通手段は「" + transport + "」で予約しました。</p>");
		
		if("spring2026".equals(campaing)) {
			out.println("<p>春のキャンペーンを適用しました</p>");
		}else {
			out.println("<p>春のキャンペーンは適用されませんでした。</p>");
		}
		
		Page.footer(out);
	}

}
