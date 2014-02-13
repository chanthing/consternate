package org.chanthing.application;

import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import org.hibernate.annotations.Entity;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import org.chanthing.util.HibernateUtil;


public class MemberRepository {

	private final String entityName = "org.chanthing.application.MemberBean";
	private final String tableName = "MEMBER";

	public MemberRepository() {
	}

	public MemberList getAllItems() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		MemberList mList = new MemberList();
		mList.addAll(session.createSQLQuery("SELECT * FROM " + this.tableName).list());
		return mList;
	}

	public MemberBean getItemById(Long id) {
		MemberBean item = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			item = (MemberBean)session.get(entityName, id);
	    } catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			session.close();
		}
		return item;
	}



	public Long addItem(MemberBean member) {
		Transaction trans = null;
		Long id = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trans = session.beginTransaction();
			id = (Long)session.save(member);
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




	public MemberBean updateItem(MemberBean member) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trans = session.beginTransaction();
			session.update(member);
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
		return member;
	}



	public void deleteItemById(Long id) {
		Transaction trans = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			MemberBean item;
			trans = session.beginTransaction();
			item = (MemberBean) session.get(entityName, id);
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
