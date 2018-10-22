package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;
import com.revature.repository.UserDao;
import com.revature.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/employee")
public class employeeServlet extends HttpServlet {
	List<User> users;
	UserDao dao = new UserDao();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) getServletContext().getAttribute("user");

		PrintWriter pw = resp.getWriter();
		pw.print(user);

	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}