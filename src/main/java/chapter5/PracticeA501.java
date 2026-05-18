package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeA501
 */
@WebServlet("/chapter5/practiceA501")
public class PracticeA501 extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");
		String color = request.getParameter("color");

		String massage = "";
		if (color == null || color.isEmpty()) {
			color = "white";
			massage = "色が選択されていません";
		}else {
			switch (color) {
			case "red":
				massage = "赤は情熱の色です。";
				break;
				
			case "blue":
				massage = "青は冷静さと信頼を表します。";
				break;
				
			case "yellow":
				massage = "黄色は元気と希望の色です。";
				break;
				
			case "green":
				massage = "緑は自然や安心感を連想させます。";
				break;
				
			default:
				massage = "選択された色は未対応です。";
				break;
			}
		}
		
		  out.println("<!DOCTYPE html>");
		  out.println("<html>");
		  out.println("<head><meta charset='UTF-8'><title>背景を変えるサーブレット</title></head>");
		  out.println("<body style='background-color:" + color +";'>");
		  out.println("<h1>色が選択されました<h1>");
		  out.println("<p>" + massage + "</p>");
		  out.println("</body></html>");

	}

}
