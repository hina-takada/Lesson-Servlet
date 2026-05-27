package chapter15;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Employees;
import dao.EmployeesDAO;

/**
 * Servlet implementation class List
 */
@WebServlet("/chapter15/list")
public class EList extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			EmployeesDAO dao = new EmployeesDAO();
			List<Employees> list = dao.findAll();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("employeebeen.jsp").
			forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
