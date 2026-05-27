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
@WebServlet("/chapter15/add")
public class Add extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			Employees em = new Employees();
			em.setName(name);
			em.setAge(age);
			
			EmployeesDAO dao = new EmployeesDAO();
			boolean chack = dao.insert(em);
			
			if(chack == true && em != null) {
				out.println("追加に成功しました。");
			}else {
				out.println("すでに追加されています。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Page.footer(out);
	}

}
