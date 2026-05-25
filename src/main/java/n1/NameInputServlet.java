package n1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class NameInputServlet
 */
@WebServlet("/n1/nameinputservlet")
public class NameInputServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("name");
		
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		if(name == null) name = "";
		
		name = user;
		session.setAttribute("name", name);
		
		request.getRequestDispatcher("output.jsp").
		forward(request, response);
		
	}

}
