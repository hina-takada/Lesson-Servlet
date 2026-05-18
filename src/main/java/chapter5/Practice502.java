package chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Practice502
 */
@WebServlet("/chapter5/practice502")
public class Practice502 extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		LocalDateTime ldt =  LocalDateTime.now();
		int hour = ldt.getHour();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");
		String dateTime = df.format(ldt);
		
		String message = "";
		if(hour >= 5 && hour < 12) {
			message ="<p>おはようございます。</p>";
		}else if(hour >= 12 && hour < 18) {
			message ="<p>こんにちは。</p>";
		}else {
			message ="<p>こんばんは。</p>";
		}
		
		Page.header(out);
		out.printf("%s %s", dateTime,message);
		Page.footer(out);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
