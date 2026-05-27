package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EmployeesDAO;
import tool.Page;

/**
 * Servlet implementation class List
 */
@WebServlet("/chapter15/delete")
public class Delete extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			EmployeesDAO dao = new EmployeesDAO();
			boolean check = dao.delete(id);
			
			if(check == true) {
				out.println("削除に成功しました。");
			}else {
				out.println("削除に失敗しました。");
			}
			
		}catch (Exception e) {
			e.printStackTrace(out);
		}
		
		Page.footer(out);
	}

}
