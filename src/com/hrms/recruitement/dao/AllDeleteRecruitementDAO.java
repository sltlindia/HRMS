package com.hrms.recruitement.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.pms.bean.SpecificCriteriaMonthBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.recruitement.bean.VacancyBenefitsBean;
import com.hrms.recruitement.bean.VacancyFormBean;

public class AllDeleteRecruitementDAO {
	/*public boolean benefitsDelete(int v_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 VacancyFormBean vacancyFormBean = new VacancyFormBean();
			 vacancyFormBean.setVacancy_id(v_id);
			 VacancyBenefitsBean vacancyBenefitsBean = new VacancyBenefitsBean();
			 vacancyBenefitsBean.setVacancyFormBean(vacancyFormBean);
			 session.delete(vacancyBenefitsBean);
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
	}	*/
	
	
	
	public boolean benefitsDelete(int v_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("Delete from VacancyBenefitsBean where vacancyFormBean = :vid");
			 query.setInteger("vid", v_id);
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
	
	public boolean interviewerDelete(int v_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("Delete from InterviewedByBean where vacancyFormBean = :vid");
			 query.setInteger("vid", v_id);
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

}
