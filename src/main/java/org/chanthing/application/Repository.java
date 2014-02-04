package org.chanthing.application;

import java.util.List;
import java.util.Iterator;
import org.hibernate.annotations.Entity;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import org.chanthing.util.HibernateUtil;


public class Repository<T> {

	private List<T> inventory;	/* The items in this Repository */
	private final String entityName;;
	private final String tableName;

	public Repository(String entityName, String tableName) {
		this.entityName = entityName;
		this.tableName = tableName;
	}

	public Repository<T> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Iterator allIds = session.createSQLQuery("SELECT ID FROM " + this.tableName).iterate();
		return this; 
	}

	public T getItem(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			return (T)session.get(entityName, id);
	    } finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
		
	
}
