package chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

/**
 * Servlet implementation class Books
 */
@WebServlet("/books")
public class Books extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		if(title == null || title.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			out.println("{\"error\":\"タイトルは必須です\"}");
			return;
		}
		
		response.setStatus(HttpServletResponse.SC_OK);
		out.print(String.format("{\"status\":\"success\",\"見つかった本\":\"%s\"}",title));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contentType = request.getContentType();
		if(contentType == null || !contentType.contains("application/json")) {
			response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
			return;
		}
		
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		
		String requestBody = buffer.toString();
		
		response.setContentType("application/json; charset=UTF-8");
		response.setStatus(XHttpServletResponse.SC_CREATED);
		
		PrintWriter out = response.getWriter();
		out.print("message:登録が完了しました！,受信データ:[" + requestBody + "]");
	}

}
