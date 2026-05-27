package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Employees;
import dao.EmployeesDAO;
import tool.Page;

/**
 * Servlet implementation class List
 */
@WebServlet("/chapter15/update")
public class Update extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			Page.header(out);
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			Employees em = new Employees();
			em.setId(id);
			em.setName(name);
			em.setAge(age);
			
			EmployeesDAO dao = new EmployeesDAO();
			boolean check = dao.update(em);
			
			if(check == true && em != null) {
				out.println("変更できました");
			}else {
				out.println("変更できませんでした。");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Page.footer(out);
	}

}
