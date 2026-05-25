package n2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Favorite;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/n2/favoriteservlet")
public class FavoriteServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		HttpSession session = request.getSession();
		
		List<Favorite> registrations = (List<Favorite>)session.getAttribute("registration");
		if(registrations == null) {
			registrations = new ArrayList<Favorite>();
		}
		
		Favorite f = new Favorite();
		f.setName(name);
		f.setUrl(url);
		registrations.add(f);
		
		session.setAttribute("registration", registrations);
		
		request.getRequestDispatcher("favorites.jsp").
		forward(request, response);
	}

}
