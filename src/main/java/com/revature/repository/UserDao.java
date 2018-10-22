package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDao {

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	public User getUser(String uName, String password) {
		User found = null;
		List<User> users = new ArrayList<>();
		Session session = HibernateUtil.getSession();//hangs here

		users = session.createQuery("from User where uName = :nameVar and password = :passVar")
				.setString("nameVar", uName).setString("passVar", password).list();
		if (!users.isEmpty()) {
			found = users.get(0);
		}
		return found;
	}

	public void updateUser(User a) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(a);
		session.getTransaction().commit();
	}

}