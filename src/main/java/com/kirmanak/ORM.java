package com.kirmanak;

import org.hibernate.Session;

import java.util.List;

public class ORM {
	public void insert(final RowBean row, final FacesSession fs) {
		if (fs.getId().isEmpty()) return; // WTF? Is it possible?
		final Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
     	session.save(row);
     	// save session if it doesn't exist, 
     	// connect row with it's session 
     	// by Many-To-One connection
     	session.getTransaction().commit();
     	HibernateUtil.shutdown();
	}

	public List<RowBean> getRows (final FacesSession fs) {
		if (fs.getId().isEmpty()) return null; // WTF? Is it possible?
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // load every row connected with current session
        final List<RowBean> results = session.createQuery("from RowBean ").list();
        session.getTransaction().commit();
        HibernateUtil.shutdown(); 
        return results;
	}
}