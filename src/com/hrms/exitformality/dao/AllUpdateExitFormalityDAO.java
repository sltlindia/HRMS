package com.hrms.exitformality.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.util.HibernateUtil;

public class AllUpdateExitFormalityDAO {

	
	
	public boolean additionalCommentUpdate(int exit_interview_employee_id, String additional_comment)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 Query query = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 
				 query = session.createQuery("update ExitInterviewEmployeeBean set additional_comment =:ac  where exit_interview_employee_id =:eid");
			
			 query.setString("ac", additional_comment);
			 query.setInteger("eid",exit_interview_employee_id);
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
	
	
	public boolean updateApprovalStatus(int hand_over_form_detail_id, int employee_mastre_id, String status, String approvalDateTime)
	{
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 Query query = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 
			 query = session.createQuery("update HandOverApprovalBean set status =:as, approval_date =:ad where detailsOfHandOverFormBean =:hb and employeeBean =:eb");
			
			 query.setString("as", status);
			 query.setString("ad", approvalDateTime);
			 query.setInteger("hb",hand_over_form_detail_id);
			 query.setInteger("eb",employee_mastre_id);
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
