package com.hrms.selfservice.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.selfservice.bean.AnnouncementBean;
import com.hrms.selfservice.bean.AnnouncementCategoryBean;
import com.hrms.selfservice.bean.AnnouncementCompanyBean;
import com.hrms.selfservice.bean.AnnouncementDepartmentBean;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.ComplaintVerifiedByBean;
import com.hrms.selfservice.bean.DownloadBean;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.selfservice.bean.SelfServiceQuerybean;
import com.hrms.selfservice.bean.SoftwareComplaintBean;

public class AllDeleteSelfServiceDAO {
	
	public boolean selfServiceDelete(int selfservice_query_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 SelfServiceQuerybean selfServiceQuerybean = new SelfServiceQuerybean();
			 selfServiceQuerybean.setSelfservice_query_id(selfservice_query_id);
			 session.delete(selfServiceQuerybean);
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
	
	public boolean marqueeDelete(int marquee_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 MarqueeBean marqueeBean = new MarqueeBean();
			 marqueeBean.setMarquee_id(marquee_id);
			 session.delete(marqueeBean);
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
	
	
	
	
	public boolean announcementDelete(int announcement_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AnnouncementBean announcementBean = new AnnouncementBean();
			 announcementBean.setAnnouncement_id(announcement_id);
			 session.delete(announcementBean);
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
	public boolean announcementCategoryDelete(int announcement_category_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AnnouncementCategoryBean announcementCategoryBean = new AnnouncementCategoryBean();
			 announcementCategoryBean.setAnnouncement_category_id(announcement_category_id);
			 session.delete(announcementCategoryBean);
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
	public boolean announcementDepartmentDelete(int announcement_department_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AnnouncementDepartmentBean announcementDepartmentBean = new AnnouncementDepartmentBean();
			 announcementDepartmentBean.setAnnouncement_department_id(announcement_department_id);
			 session.delete(announcementDepartmentBean);
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
	public boolean announcementCompanyDelete(int announcement_company_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AnnouncementCompanyBean announcementCompanyBean = new AnnouncementCompanyBean();
			 announcementCompanyBean.setAnnouncement_company_id(announcement_company_id);
			 session.delete(announcementCompanyBean);
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
	public boolean announcementCategoryDeleteId(int announcement_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AnnouncementCategoryBean  announcementCategoryBean = new AnnouncementCategoryBean();
			 AnnouncementBean announcementBean = new AnnouncementBean();
			 announcementBean.setAnnouncement_id(announcement_id);
			 announcementCategoryBean.setAnnouncementBean(announcementBean);
			 session.delete(announcementCategoryBean);
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
	
	public boolean announcementCompanyDeleteId(int announcement_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AnnouncementCompanyBean announcementCompanyBean= new AnnouncementCompanyBean();
			 AnnouncementBean announcementBean = new AnnouncementBean();
			 announcementBean.setAnnouncement_id(announcement_id);
			 announcementCompanyBean.setAnnouncementBean(announcementBean);
			 session.delete(announcementCompanyBean);
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
	
	
	public boolean complaintDelete(int complaint_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ComplaintBean complaintBean = new ComplaintBean();  
			 complaintBean.setComplaint_id(complaint_id);
			 session.delete(complaintBean);
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
	public boolean softwareComplaintDelete(int complaint_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 SoftwareComplaintBean softwareComplaintBean = new SoftwareComplaintBean();  
			 softwareComplaintBean.setSoftware_complaint_id(complaint_id);
			 session.delete(softwareComplaintBean);
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
	
	
	
	public boolean complaintVerifiedPersonDelete(int complaint_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ComplaintVerifiedByBean where complaintBean = :cb");
			 query.setInteger("cb",complaint_id);
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
	
	
	
	
	
	public boolean downloadDelete(int download_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 DownloadBean downloadBean = new DownloadBean();
			 downloadBean.setDownload_id(download_id);
			 session.delete(downloadBean);
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

	public boolean complaintHide(int complaint_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ComplaintBean complaintBean = new ComplaintBean();
			 complaintBean.setComplaint_id(complaint_id);
			 session.delete(complaintBean);
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
	public boolean softwareComplaintHide(int complaint_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 SoftwareComplaintBean softwareComplaintBean = new SoftwareComplaintBean();
			 softwareComplaintBean.setSoftware_complaint_id(complaint_id);
			 session.delete(softwareComplaintBean);
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
