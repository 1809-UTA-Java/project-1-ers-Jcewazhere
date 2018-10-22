package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.*;
import com.revature.repository.*;
import com.revature.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/submit")
public class submitReimbursement extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursementsDao re = new ReimbursementsDao();
		User user = (User) getServletContext().getAttribute("user");
		Reimbursement item = new Reimbursement();
		String amount = "", description = "";

		amount = req.getParameter("amount");
		description = req.getParameter("description");
		String temp = req.getParameter("type");
		int type = Integer.valueOf(temp);
		item.setAmmount(Double.parseDouble(amount));
		item.setAuthor(user.getId());
		item.setDescription(description);
		item.setType(type);

		re.saveRequest(item);
		getServletContext().setAttribute("item", item);

		RequestDispatcher rs = req.getRequestDispatcher("employee.html");
		rs.forward(req, resp);
	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}