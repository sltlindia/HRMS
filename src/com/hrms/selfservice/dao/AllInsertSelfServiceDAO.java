package com.hrms.selfservice.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;
import com.hrms.selfservice.bean.AnnouncementBean;
import com.hrms.selfservice.bean.AnnouncementCategoryBean;
import com.hrms.selfservice.bean.AnnouncementCompanyBean;
import com.hrms.selfservice.bean.AnnouncementDepartmentBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ComplaintVerifiedByBean;
import com.hrms.selfservice.bean.DownloadBean;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.bean.SoftwareComplaintBean;
import com.hrms.selfservice.bean.SoftwareNatureBean;

public class AllInsertSelfServiceDAO implements Serializable {
	
	
		public boolean selfserviceInsert(SelfServiceQuerybean selfServiceQuerybean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(selfServiceQuerybean);
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
	
		public boolean marqueeInsert(MarqueeBean marqueeBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(marqueeBean);
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
		
		public boolean complaintInsert(ComplaintBean complaintBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(complaintBean);
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
		
		public boolean announcementInsert(AnnouncementBean announcementBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(announcementBean);
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
		
		
		
		
		public boolean announcementCategoryInsert(AnnouncementCategoryBean announcementCategoryBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(announcementCategoryBean);
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
		
		public boolean announcementDepartmentInsert(AnnouncementDepartmentBean announcementDepartmentBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(announcementDepartmentBean);
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
		public boolean announcementCompanyInsert(AnnouncementCompanyBean announcementCompanyBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(announcementCompanyBean);
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
		
		
		
		
		public boolean downloadInsert(DownloadBean downloadBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(downloadBean);
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
		public boolean problemNatureInsert(ProblemNatureBean problemNatureBean){
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(problemNatureBean);
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
		public boolean softwareNatureInsert(SoftwareNatureBean softwareNatureBean){
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(softwareNatureBean);
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
		public boolean complaintVerifiedByInsert(ComplaintVerifiedByBean complaintVerifiedByBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(complaintVerifiedByBean);
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
		
		public boolean softwareComplaintInsert(SoftwareComplaintBean softwareComplaintBean){
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(softwareComplaintBean);
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
