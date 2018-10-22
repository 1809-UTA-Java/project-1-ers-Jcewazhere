package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/viewuser")
public class viewUserServlet extends HttpServlet {
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