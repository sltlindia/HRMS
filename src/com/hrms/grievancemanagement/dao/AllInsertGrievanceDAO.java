package com.hrms.grievancemanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.grievancemanagement.bean.GrievanceEmailBean;
import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean;
import com.hrms.grievancemanagement.controller.GrievanceQueryInsertServlet;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.util.HibernateUtil;

public class AllInsertGrievanceDAO {

	public boolean grievanceInsert(GrievanceQueryBean grievanceQueryBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(grievanceQueryBean);
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	
	public boolean grievanceEmailInsert(GrievanceEmailBean grievanceEmailBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(grievanceEmailBean);
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public boolean grievanceQueryTypeInsert(GrievanceQueryTypeBean grievanceQueryTypeBean){
		 Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(grievanceQueryTypeBean);
			 tx.commit();
			 result = true;
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return result;
	}
	
	
	
}
