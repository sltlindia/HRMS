package com.hrms.lms.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.bean.GatePassBean;
import com.hrms.lms.bean.IntervieweeBean;
import com.hrms.lms.bean.LeaveAdjustBalanceBean;
import com.hrms.lms.bean.LeaveAfterAddBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveCancelRequestBean;
import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.bean.NopunchBean;
import com.hrms.lms.util.HibernateUtil;
import com.hrms.pms.bean.RoleBean;
import com.hrms.timesheet.bean.HolidayBean;




public class AllInsertDAO 
{

	
	public boolean leaveInsert(LeaveBean leaveBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(leaveBean);
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
	
	public boolean leaveCutBalanceInsert(LeavecutBalance leavecutBalance)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(leavecutBalance);
			 System.out.println("Leave Balance Cut Successfully");
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
	
	public boolean leaveCOInsert(LeaveCOBean leaveCOBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(leaveCOBean);
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
	
	public boolean leaveODInsert(LeaveODBean leaveODBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(leaveODBean);
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
	
	public boolean HolidayInsert(HolidayBean holidayBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(holidayBean);
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
	
	public boolean leaveAddAfterInsert(LeaveAfterAddBean leaveAfterAddBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(leaveAfterAddBean);
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
	
	
	public boolean leaveHRInsert(LeaveHRBean leaveHRBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(leaveHRBean);
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
	
	public boolean leaveAdjustInsert(LeaveAdjustBalanceBean adjustBalanceBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(adjustBalanceBean);
			
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


	public boolean leaveCancelRequestInsert(LeaveCancelRequestBean leaveCancelRequestBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(leaveCancelRequestBean);
			
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

	
	
	public boolean gatePassInsert(GatePassBean gatePassBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(gatePassBean);
			
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

	
	public boolean intervieweeInsert(IntervieweeBean intervieweeBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(intervieweeBean);
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
	
	
	public boolean roleInsert(String role_type, String role_authority, String level, String level_name)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 int id = 0;
		 boolean result = false;
		 RoleBean roleBean = new RoleBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 
			 roleBean.setRole_type(role_type);
			 roleBean.setRole_authority(role_authority);
			 roleBean.setLevel(level);
			 roleBean.setLevel_name(level_name);
			 session.saveOrUpdate(roleBean);
			 id = roleBean.getRole_id();
			 roleBean.setRole_id(id);
			 System.out.println("id"+id);
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
		 return true;
	}
	
	
	
	
	
	
	public boolean leaveInsertformultiple(NopunchBean nopunchBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(nopunchBean);
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
