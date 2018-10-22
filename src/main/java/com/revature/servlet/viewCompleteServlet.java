package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.repository.ReimbursementsDao;
import com.revature.util.HibernateUtil;

@SuppressWarnings("serial")
@WebServlet("/complete")
public class viewCompleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> items;
		ReimbursementsDao dao = new ReimbursementsDao();
		User user = (User) getServletContext().getAttribute("user");

		items = dao.getReimbursements(user.getId(), user.getUrId(), 1);
		PrintWriter pw = resp.getWriter();
		pw.print(items);
	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}