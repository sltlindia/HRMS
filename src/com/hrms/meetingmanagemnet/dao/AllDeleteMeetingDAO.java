package com.hrms.meetingmanagemnet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.util.HibernateUtil;
import com.hrms.meetingmanagemnet.bean.MeetingBookingDetailBean;
import com.hrms.pms.bean.EmployeeBean;

public class AllDeleteMeetingDAO {

	
	public boolean meetingDelete(int bookId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 boolean result = false;
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("delete MeetingBookingDetailBean where meeting_booking_detail_id = :mbdi");
			 query.setInteger("mbdi",bookId);
			 int result1 = query.executeUpdate();
			 result = true;
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
