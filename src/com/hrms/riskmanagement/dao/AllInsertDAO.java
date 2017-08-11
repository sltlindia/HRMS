package com.hrms.riskmanagement.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.recruitement.bean.ResumeDataBean;
import com.hrms.recruitement.util.HibernateUtil;
import com.hrms.riskmanagement.bean.ConcernPersonBean;
import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.riskmanagement.bean.StakHoldersDetailsBean;
import com.hrms.riskmanagement.bean.SuggestionBean;
import com.hrms.riskmanagement.controller.SuggestionInsertServlet;

public class AllInsertDAO {

	
	public boolean riskManagementDataInsert(RiskRepositoryBean riskRepositoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(riskRepositoryBean);
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
	public boolean stakHoldersDataInsert(StakHoldersDetailsBean stakHoldersDetailsBean) {
	Session session = HibernateUtil.openSession();
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.save(stakHoldersDetailsBean);
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
	public boolean concernPersonInsert(ConcernPersonBean concernPersonBean) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(concernPersonBean);
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
	public boolean suggestionInsert(SuggestionBean suggestionBean) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(suggestionBean);
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

}
