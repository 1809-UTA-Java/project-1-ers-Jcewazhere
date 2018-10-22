package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;
import com.revature.repository.UserDao;
import com.revature.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	List<User> users;
	UserDao dao = new UserDao();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDao();
		String name = "", password = "";
		name = req.getParameter("uName");
		// System.out.println("getting name " +name); worked
		password = req.getParameter("password");
		// System.out.println("password is " +password);worked
		User user = dao.getUser(name, password);

		if (user == null) {
			RequestDispatcher rs = req.getRequestDispatcher("index.html");
			rs.forward(req, resp);
//			System.out.println("testing if null"); printed but shouldn't have been null. Fixed, problem in table
		} else {
			getServletContext().setAttribute("user", user);
//			System.out.println("testing if else");worked
			if (user.getUrId() == 1) {// System.out.println("testing if userID == 1"); worked
				RequestDispatcher rs = req.getRequestDispatcher("manager.html");
				rs.forward(req, resp);
			} else {
				System.out.println("testing else");
				RequestDispatcher rs = req.getRequestDispatcher("employee.html");
				rs.forward(req, resp);
			}
		}
	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}