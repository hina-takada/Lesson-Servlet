package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/jsp/contact")
public class Contact extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String kaisy = request.getParameter("kaisy");
		String mail = request.getParameter("mail");
		String toiawas = request.getParameter("toiawas");
		String[] checks = request.getParameterValues("check");
		String anser = request.getParameter("anser");
		
		if(name == null && name.isEmpty()) {
			out.println("名前を入力してください");
		}
		
		if(kaisy.isEmpty() && kaisy.length() < 100) {
			out.println("100字以内に収めてください");
		}
		
		if(mail == null && mail.isBlank()&& mail.isEmpty()) {
			out.println("メールアドレスを入力してください");
		}

		if(toiawas == null && toiawas.isBlank()) {
			out.println("");
		}else if (toiawas.isEmpty() && toiawas.length() < 200) {
			out.println("0～200以内に収めてください");
		}
		
		if(anser.equals("YES")) {
			request.getRequestDispatcher("anser.jsp").forward(request, response);
		}else if(anser == null && anser.isBlank()){
			out.println("どちらかを選択してください");
		}else{
			request.getRequestDispatcher("contact2.jsp").forward(request, response);
		}
		
		
	}

}
