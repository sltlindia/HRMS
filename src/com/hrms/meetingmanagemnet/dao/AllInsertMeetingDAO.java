 package com.hrms.meetingmanagemnet.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.meetingmanagemnet.bean.MeetingAttachmentBean;
import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.meetingmanagemnet.bean.MeetingMOMBean;
import com.hrms.pms.util.HibernateUtil;


public class AllInsertMeetingDAO {
	
	public boolean bookingInsert(MeetingBookingDetailBean meetingBookingDetailBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(meetingBookingDetailBean);
			 System.out.println("inserted");
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
	
	
	public boolean bookingDescInsert(MeetingMOMBean meetingMOMBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(meetingMOMBean);
			 System.out.println("inserted");
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
	
	
	
	public boolean bookiungAttachmentInsert(MeetingAttachmentBean meetingAttachmentBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(meetingAttachmentBean);
			 System.out.println("inserted");
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
