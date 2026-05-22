package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Sort;
import dao.SortDAO;
import tool.Page;

/**
 * Servlet implementation class SortBeen
 */
@WebServlet("/chapter16/sort")
public class SortBeen extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			String sort = request.getParameter("sort");
			
			SortDAO sb = new SortDAO();
			List<Sort> list = sb.search(sort);
			
			for(Sort s : list) {
				out.println(s.getId());
				out.println(":");
				out.println(s.getName());
				out.println(":");
				out.println(s.getPrice());
				out.println(":");
				out.println("<br>");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Page.footer(out);
	}

}
