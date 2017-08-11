package com.hrms.exitformality.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.exitformality.bean.DetailsOfHandOverFormBean;
import com.hrms.exitformality.bean.DetailsOfMaterialBean;
import com.hrms.exitformality.bean.DetailsOfPendingMattersBean;
import com.hrms.exitformality.bean.DetailsOfResponsibilitiesBean;
import com.hrms.exitformality.bean.ExitInterviewEmployeeBean;
import com.hrms.exitformality.bean.ExitInterviewFormAttributeBean;
import com.hrms.exitformality.bean.ExitInterviewManagerCommentsBean;
import com.hrms.exitformality.bean.ExitInterviewScoreBean;
import com.hrms.exitformality.bean.HandOverApprovalBean;
import com.hrms.exitformality.util.HibernateUtil;

public class AllInsertExitFormalityDAO {

	public boolean exitInterviewFormAttributeInsert(ExitInterviewFormAttributeBean exitInterviewFormAttributeBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(exitInterviewFormAttributeBean);		
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
	
	
	public boolean exitInterviewEmployeeInsert(ExitInterviewEmployeeBean exitInterviewEmployeeBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(exitInterviewEmployeeBean);		
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

	
	public boolean exitInterviewScoreInsert(ExitInterviewScoreBean exitInterviewScoreBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(exitInterviewScoreBean);		
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
	
	public boolean managerCommentInsert(ExitInterviewManagerCommentsBean exitInterviewManagerCommentsBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(exitInterviewManagerCommentsBean);		
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
	
	
	public boolean handOverFormDetailInsert(DetailsOfHandOverFormBean detailsOfHandOverFormBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(detailsOfHandOverFormBean);		
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
	
	
	public boolean responsibilityDetailInsert(DetailsOfResponsibilitiesBean detailsOfResponsibilitiesBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(detailsOfResponsibilitiesBean);		
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
	
	
	public boolean pendingMattersDetailInsert(DetailsOfPendingMattersBean detailsOfPendingMattersBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(detailsOfPendingMattersBean);		
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
	
	
	public boolean materialDetailInsert(DetailsOfMaterialBean detailsOfMaterialBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(detailsOfMaterialBean);		
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


	public boolean insertHandOverApproval(HandOverApprovalBean handOverApprovalBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(handOverApprovalBean);		
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
