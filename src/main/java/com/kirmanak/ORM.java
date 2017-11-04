package com.kirmanak;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class ORM {
    public static Session session;
    
    public static void insert(final RowEntity row) { 
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(row);
        session.getTransaction().commit();
        session.close();
    }

    public static List<RowEntity> getRows () {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from RowEntity");
        final List<RowEntity> results = query.list();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public static void clear () {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from RowEntity");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
