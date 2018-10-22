package com.revature.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/updaterequest")
public class updateRequestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) getServletContext().getAttribute("user");
		Reimbursement item = null;
		ReimbursementsDao dao = new ReimbursementsDao();
		String id = "", status = "";
		int id2 = 0, status2 = 0;
		id = req.getParameter("id");
		status = req.getParameter("status");

		id2 = Integer.valueOf(id);
		status2 = Integer.valueOf(status);

		if (!id.isEmpty()) {
			item = dao.getReimbursement(id2);
			item.setStatus(status2);
			item.setResolver(user.getId());
			Timestamp time = new Timestamp(System.currentTimeMillis());
			item.setResolved(time);
			dao.updateRequest(item);

			RequestDispatcher rs = req.getRequestDispatcher("manager.html");
			rs.forward(req, resp);

		} else {
			RequestDispatcher rs = req.getRequestDispatcher("approve.html");
			rs.forward(req, resp);
		}

	}

	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}