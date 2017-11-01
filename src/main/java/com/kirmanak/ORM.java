package com.kirmanak;

import org.hibernate.Session;

import java.util.List;

public class ORM {
	public static void insert(final RowBean row) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
     	// session.save(row);
     	// save session if it doesn't exist, 
     	// connect row with it's session 
     	// by Many-To-One connection
     	session.getTransaction().commit();
     	HibernateUtil.shutdown();
	}

	public static List<RowBean> getRows (final String sessionId) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final List<RowBean> results = session.createQuery("from RowBean ").list();
        session.getTransaction().commit();
        HibernateUtil.shutdown(); 
        return results;
	}

	public static void clear () {
	}
}