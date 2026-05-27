package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.TweetDAO;

@WebServlet("/new_tweet")
public class NewTweetServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String countent = request.getParameter("countent");
		String author = request.getParameter("author");

		TweetDAO tweetDAO = new TweetDAO();
		try {
			tweetDAO.addTweet(countent, author);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (countent == null || countent.isEmpty()) {
			request.setAttribute("message", false);
			request.getRequestDispatcher("tweet_list.jsp").forward(request, response);
		}else if (author.length() >= 255 || author == null) {
			request.setAttribute("message", false);
			request.getRequestDispatcher("tweet_list.jsp").forward(request, response);
		}else {
			request.setAttribute("message", true);
			request.getRequestDispatcher("tweet_list.jsp").forward(request, response);
		}
		
		
	}
}
