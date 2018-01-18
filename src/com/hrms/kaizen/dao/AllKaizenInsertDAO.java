package com.hrms.kaizen.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.TargetBean;
import com.hrms.kaizen.bean.KaizenAfterUploadAttachmentBean;
import com.hrms.kaizen.bean.KaizenAuthorityScoreBean;
import com.hrms.kaizen.bean.KaizenBean;
import com.hrms.kaizen.bean.KaizenBeforeUploadAttachmentBean;
import com.hrms.kaizen.bean.KaizenBillboardResultBean;
import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.bean.KaizenManagerScoreBean;
import com.hrms.kaizen.bean.KaizenMemberBean;
import com.hrms.kaizen.bean.KaizenProblemIdentificationBean;
import com.hrms.kaizen.bean.KaizenReactivationRemarkBean;
import com.hrms.kaizen.bean.kaizenRCABean;
import com.hrms.pms.util.HibernateUtil;

public class AllKaizenInsertDAO {

	public boolean kaizenInsert(KaizenBean kaizenBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenBean);
			 tx.commit();
			
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
	
	
	public boolean kaizenManagerInsert(KaizenManagerBean kaizenManagerBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(kaizenManagerBean);
			 tx.commit();
			
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
	
	
	
	public boolean kaizenMemberInsert(KaizenMemberBean kaizenMemberBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(kaizenMemberBean);
			 tx.commit();
			
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
	
	
	public boolean kaizenPhotoUploadBeforeInsert(KaizenBeforeUploadAttachmentBean kaizenBeforeUploadAttachmentBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenBeforeUploadAttachmentBean);
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
	
	public boolean kaizenPhotoUploadAfterInsert(KaizenAfterUploadAttachmentBean kaizenAfterUploadAttachmentBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenAfterUploadAttachmentBean);
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
	
	
	public boolean kaizenManagementInsert(KaizenManagementApprovalBean kaizenManagementApprovalBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenManagementApprovalBean);
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
	
	
	public boolean kaizenManagerScoreInsert(KaizenManagerScoreBean kaizenManagerScoreBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenManagerScoreBean);
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
	
	
	public boolean kaizenAuthorityScoreInsert(KaizenAuthorityScoreBean kaizenAuthorityScoreBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenAuthorityScoreBean);
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
	
	
	public boolean kaizenManagerResultnsert(KaizenBillboardResultBean kaizenBillboardResultBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenBillboardResultBean);
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
	
	
	public boolean kaizenProblemInsert(KaizenProblemIdentificationBean kaizenProblemIdentificationBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(kaizenProblemIdentificationBean);
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
	
	public boolean kaizenRCAInsert(kaizenRCABean kaizenRCABean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(kaizenRCABean);
			 tx.commit();
			
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
	
	
	public boolean kaizenReactivatkionInsert(KaizenReactivationRemarkBean kaizenReactivationRemarkBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(kaizenReactivationRemarkBean);
			 tx.commit();
			
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
