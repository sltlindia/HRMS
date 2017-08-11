package com.hrms.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.util.HibernateUtil;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;

public class AllDeleteDAO
{

	public boolean LeaveCancelled(String status ,int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 EmployeeBean employeeBean = new EmployeeBean();
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			// Query query = session.createQuery("update EmployeeBean set Privilege_Leave = :pl where employee_master_id = :empid");
			 Query query = session.createQuery("update LeaveBean set status = :st where leave_id = :lid");
			 query.setString("st" ,status);
			 query.setInteger("lid",leave_id);
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
	
	public boolean holidayDeleted(int holiday_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete HolidayBean where holiday_id = :hid");
			 query.setInteger("hid",holiday_id);
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
	
	
	
	public boolean laveHrDelete(int leave_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete LeaveHRBean where leaveBean = :lid");
			 query.setInteger("lid",leave_id);
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
	
	public boolean gatePassDelete(int gate_pass_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete GatePassBean where gate_pass_id = :gpid");
			 query.setInteger("gpid",gate_pass_id);
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
