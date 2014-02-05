package org.chanthing.application;

import java.util.List;
import java.util.Iterator;
import org.hibernate.annotations.Entity;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import org.chanthing.util.HibernateUtil;


public class Repository<T> {

	private List<T> inventory;	/* The items in this Repository */
	private final String entityName;;
	private final String tableName;

	public Repository(String entityName, String tableName) {
		this.entityName = entityName;
		this.tableName = tableName;
	}

	public List<T> getAllItems() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (List<T>)session.createSQLQuery("SELECT * FROM " + this.tableName).list();
	}

	public T getItemById(Long id) {
		T item = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			item = (T)session.get(entityName, id);
	    } catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			session.close();
		}
		return item;
	}

	public Long addItem(T item) {
		Transaction trans = null;
		Long id = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trans = session.beginTransaction();
			id = (Long)session.save(item);
			trans.commit();
		} catch (HibernateException he) {
			if (trans != null) {
				trans.rollback();
			}
			he.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return id;
	}

	public void deleteItemById(Long id) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			T item;
			trans = session.beginTransaction();
			item = (T) session.get(entityName, id);
			session.delete(item);
			trans.commit();
		} catch (HibernateException he) {
			if (trans != null) {
				trans.rollback();
			}
			he.printStackTrace();
		} finally {
			session.close();
		}
	}
		
	
}
