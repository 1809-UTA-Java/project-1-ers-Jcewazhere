package com.revature.servlet;

import java.io.IOException;

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
@WebServlet("/updateuser")
public class updateUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) getServletContext().getAttribute("user");
		UserDao dao = new UserDao();
		String uName = "", password = "", fName = "", lName = "", email = "";
		uName = req.getParameter("uName");
		password = req.getParameter("password");
		fName = req.getParameter("fName");
		lName = req.getParameter("lName");
		email = req.getParameter("email");

		if (!uName.isEmpty()) {
			user.setuName(uName);
		}
		if (!password.isEmpty()) {
			user.setPassword(password);
		}
		if (!fName.isEmpty()) {
			user.setfName(fName);
		}
		if (!lName.isEmpty()) {
			user.setlName(lName);
		}
		if (!email.isEmpty()) {
			user.setEmail(email);
		}

		dao.updateUser(user);
		getServletContext().setAttribute("user", user);

		RequestDispatcher rs = req.getRequestDispatcher("employee.html");
		rs.forward(req, resp);
	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}