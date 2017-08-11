package com.hrms.grievancemanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.util.HibernateUtil;

public class AllDeleteGrievanceDAO {
	
	public boolean grievanceQueryTypeDelete(int query_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 GrievanceQueryTypeBean grievanceQueryTypeBean = new GrievanceQueryTypeBean();
			 grievanceQueryTypeBean.setGrievance_query_type_id(query_id);
			 session.delete(grievanceQueryTypeBean);
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
	
	
	public boolean grievanceQueryDelete(int query_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 GrievanceQueryBean grievanceQueryBean = new GrievanceQueryBean();
			 grievanceQueryBean.setGrievance_query_id(query_id);
			 session.delete(grievanceQueryBean);
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
