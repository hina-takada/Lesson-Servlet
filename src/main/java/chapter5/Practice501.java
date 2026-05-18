package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice501
 */
@WebServlet("/chapter5/practice501")
public class Practice501 extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			if(age < 0 || age > 100) {
				out.println("0～100の数値を入力してください");
			}else if(age < 18) {
				out.printf("こんにちは%sさん。未成年ですね",name);
			}else{
				out.printf("こんにちは%sさん。大人ですね",name);
			}
		} catch (NumberFormatException | NullPointerException e) {
			out.println("年齢は数値で入力してください");
		}
		
		
	}

}
