package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateUtil;

public class ReimbursementsDao {
	@SuppressWarnings("unchecked")
	public List<Reimbursement> getReimbursements(int id, int role, int status) {
		List<Reimbursement> items = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		if (role == 0) {
			items = session.createQuery("from Reimbursement where author = :idVar and status = :idStatus")
					.setInteger("idVar", id).setInteger("idStatus", status).list();
		} else {
			items = session.createQuery("from Reimbursement where status = :idStatus").setInteger("idStatus", status)
					.list();
		}
		return items;
	}

	@SuppressWarnings("unchecked")
	public Reimbursement getReimbursement(int id) {
		Reimbursement found = null;
		List<Reimbursement> items = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		items = session.createQuery("from Reimbursement where id = :idVar").setInteger("idVar", id).list();
		if (!items.isEmpty()) {
			found = items.get(0);
		}
		return found;
	}

	public void saveRequest(Reimbursement item) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

	public void updateRequest(Reimbursement item) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
	}

}