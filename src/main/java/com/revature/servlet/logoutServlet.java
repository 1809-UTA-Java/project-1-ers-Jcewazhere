package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		getServletContext().setAttribute("user", user);
		RequestDispatcher rs = req.getRequestDispatcher("index.html");
		rs.forward(req, resp);
	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}