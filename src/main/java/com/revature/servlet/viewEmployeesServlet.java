package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/employees")
public class viewEmployeesServlet extends HttpServlet {
	List<User> users = new ArrayList<>();
	UserDao dao = new UserDao();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		users = dao.getUsers();
		PrintWriter pw = resp.getWriter();
		pw.print(users);

	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}