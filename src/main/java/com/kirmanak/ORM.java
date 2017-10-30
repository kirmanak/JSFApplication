package com.kirmanak;

import org.hibernate.query.Query;
import org.hibernate.Session;

import java.util.List;

public class ORM {
	public void insert(final RowBean row) {
		final Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
     	session.save(row);
     	session.getTransaction().commit();
     	HibernateUtil.shutdown();
	}

	public List<RowBean> getRows (final TableBean table) {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final List<RowBean> results = session.createQuery("from RowBean ").list();
        session.getTransaction().commit();
        HibernateUtil.shutdown(); 
        return results;
	}
}