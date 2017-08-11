package com.hrms.riskmanagement.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.util.HibernateUtil;

public class AllDeleteDAO {
	public boolean riskRepositoyryDelete(int risk_repository_id){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 RiskRepositoryBean riskRepositoryBean= new RiskRepositoryBean();
			 riskRepositoryBean.setRisk_repository_id(risk_repository_id);
			 session.delete(riskRepositoryBean);
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
