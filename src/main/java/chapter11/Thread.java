package chapter11;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Thread
 */
@WebServlet("/chapter11/thread")
public class Thread extends HttpServlet {
	private AtomicInteger count = new AtomicInteger(0);
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet initialized. Counter set to 0.");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("increment".equals(action)) {
			response.getWriter().println("Count:" + count.incrementAndGet());
		}else if ("reset".equals(action)) {
			count.set(0);
			response.getWriter().println("Count reset to 0.");
		}else {
			response.getWriter().println("Current Count" + count.get());
		}
	}


	@Override
	public void destroy() {
		System.out.println("Servlet destroyed. Final Counter:" + count.get());
	}
}
