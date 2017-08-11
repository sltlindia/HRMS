package com.hrms.riskmanagement.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.util.HibernateUtil;
import com.hrms.riskmanagement.bean.RiskRepositoryBean;
import com.hrms.riskmanagement.bean.StakHoldersDetailsBean;

public class AllUpdateDAO {
	public boolean riskManagementDataUpdate(int monitoring_frequency_id,String updated_on,String risk_type,String category_of_risk,String risk_description,String stage,int probability_id,int severity_id,String impact,String impact_description,int risk_status_id,int risk_priority_id,String justification,String mitigation_action,String threshold_condition_mitigation,int employee_master_id,String mitigation_date,String contingency_action,String threshold_condition_contingency,String contingency_date,int employee_id_contingency,String fallback_plan,int risk_repository_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update RiskRepositoryBean set monitoring_frequency_id = :mfi,updated_on = :uo,risk_type = :rt,category_of_risk = :cor,risk_description = :rd,stage = :st,probability_id = :pri,severity_id = :si,impact = :im,impact_description = :imd,risk_status_id = :rsi,risk_priority_id = :rpi,justification = :jus,mitigation_action = :ma,threshold_condition_mitigation = :tcm,employee_master_id = :emi,mitigation_date = :md,contingency_action = :ca,threshold_condition_contingency = :tcc,contingency_date = :cd,employee_id_contingency = :eic,fallback_plan = :fbp where risk_repository_id = :ri");
			 query.setInteger("mfi", monitoring_frequency_id);
			 query.setString("uo",updated_on);
			 query.setString("rt",risk_type);
			 query.setString("cor",category_of_risk);
			 query.setString("rd", risk_description);
			 query.setString("st", stage);
			 query.setInteger("pri", probability_id);
			 query.setInteger("si", severity_id);
			 query.setString("im",impact);
			 query.setString("imd",impact_description);
			 query.setInteger("rsi", risk_status_id);
			 query.setInteger("rpi",risk_priority_id);
			 query.setString("jus",justification);
			 query.setString("ma",mitigation_action);
			 query.setString("tcm",threshold_condition_mitigation);
			 query.setString("md",mitigation_date);
			 query.setInteger("emi", employee_master_id);
			 query.setString("ca",contingency_action);
			 query.setString("cd",contingency_date);
			 query.setInteger("eic", employee_id_contingency);
			 query.setString("tcc",threshold_condition_contingency);
			 query.setString("fbp",fallback_plan);
			 query.setInteger("ri",risk_repository_id);

			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
	public boolean riskViewDate(String view_on,int risk_repository_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update RiskRepositoryBean set viewed_on = :vo where risk_repository_id = :ri");
			 query.setString("vo",view_on);
			 query.setInteger("ri",risk_repository_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
	public boolean riskCloseDateUpdate(String closed_on,int risk_repository_id,String viewed_on,String remarks){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update RiskRepositoryBean set closed_on = :co,viewed_on = :vo,remarks = :re where risk_repository_id = :ri");
			 query.setString("co",closed_on);
			 query.setInteger("ri",risk_repository_id);
			 query.setString("vo",viewed_on);
			 query.setString("re", remarks);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
	
	
	public boolean concernPersonUpdate(int employee_master_id,int risk_repository_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ConcernPersonBean set employee_master_id = :emi where risk_repository_id = :ri");
			 query.setInteger("ri",risk_repository_id);
			 query.setInteger("emi",employee_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
			 session.update(stakHoldersDetailsBean);
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
