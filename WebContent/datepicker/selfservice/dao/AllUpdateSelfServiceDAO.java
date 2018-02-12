package com.hrms.selfservice.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;
import com.hrms.selfservice.bean.ComplaintBean;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.selfservice.bean.ProblemNatureBean;
import com.hrms.selfservice.bean.SelfServiceTypeBean;

public class AllUpdateSelfServiceDAO {

	public boolean selfserviceUpdate(int selfservice_query_id, String description,String  attachment,String  date_of_submission, int selfservice_type_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update SelfServiceQuerybean set description = :b ,attachment = :c,date_of_submission = :d,selfservice_type_id = :e where selfservice_query_id = :a ");
			 query.setInteger("a", selfservice_query_id);
			 query.setString("b", description);
			 query.setString("c", attachment);
			 query.setString("d", date_of_submission);
			 query.setInteger("e", selfservice_type_id);
			 
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
	public boolean marqueeUpdate(MarqueeBean marqueeBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(marqueeBean);
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
	
	
	public boolean announcementUpdate(int announcement_id,String announcement_title,String announcement_description,String announcement_attachment,String announcement_enddate,int employee_master_id,String announcement_submission_date,String from_time, String to_time){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AnnouncementBean set announcement_title = :b ,announcement_description = :c,announcement_attachment = :d,announcement_enddate = :e,employee_master_id = :f,announcement_submission_date = :g,from_time = :ft,to_time = :tt where announcement_id = :a");
			 query.setInteger("a", announcement_id);
			 query.setString("b", announcement_title);
			 query.setString("c", announcement_description);
			 query.setString("d", announcement_attachment);
			 query.setString("e", announcement_enddate);
			 query.setInteger("f", employee_master_id);
			 query.setString("g", announcement_submission_date);
			 query.setString("ft", from_time);
			 query.setString("tt", to_time);
			 
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

	public boolean announcementCategoryUpdate(int role_category_id,int announcement_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AnnouncementCategoryBean set role_category_id = :rci where announcement_id = :a");
			 query.setInteger("rci", role_category_id);
			 query.setInteger("a", announcement_id);
			 
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
	
	
	public boolean complaintUpdate(ComplaintBean complaintBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(complaintBean);
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

	public boolean replyUpdate(String correction,String date_of_resolve,String remarks,String status,int complaint_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ComplaintBean set correction = :b ,date_of_resolve = :c,remarks = :d,status = :e where complaint_id = :a ");
			 query.setInteger("a", complaint_id);
			 query.setString("b", correction);
			 query.setString("c", date_of_resolve);
			 query.setString("d", remarks);
			 query.setString("e", status);
			 
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
	
	public boolean replyUpdateManager(int problem_nature_id, String description,String location,String extension,String correction,String remarks,int complaint_id,String date_of_submission,String correction_date){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ComplaintBean set problem_nature_id = :a,description = :c ,location = :d ,remarks = :e ,extension = :f ,correction = :h,date = :sd, date_of_resolve = :crd  where complaint_id = :cid");
			 query.setInteger("cid", complaint_id);
			 query.setInteger("a", problem_nature_id);
			 query.setString("c", description);
			 query.setString("d", location);
			 query.setString("e", remarks);
			 query.setString("f", extension);
			 query.setString("h", correction);
			 query.setString("sd", date_of_submission);
			 query.setString("crd", correction_date);
			 
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
	
	public boolean downloadUpdate(String reply,String remarks,String status,int download_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update DownloadBean set reply = :b ,remarks = :d,status = :e where download_id = :a ");
			 query.setInteger("a", download_id);
			 query.setString("b", reply);
			 query.setString("d", remarks);
			 query.setString("e", status);
			 
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

	public boolean problemNatureUpdate(ProblemNatureBean problemNatureBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(problemNatureBean);
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
