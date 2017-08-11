package com.hrms.timesheet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.timesheet.util.HibernateUtil;

public class AllDeleteDAO {
	
	public boolean timeSheetDelete(int employee_master_id,String date){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete from TimeSheetBean where employee_master_id= :e and date= :d");
			 query.setInteger("e", employee_master_id);
			 query.setString("d", date);
			 int result = query.executeUpdate();
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
	
	
	public boolean timeSheetUnplanDelete(int employee_master_id,String date){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete from UnplanProjectBean where employee_master_id= :e and date= :d");
			 query.setInteger("e", employee_master_id);
			 query.setString("d", date);
			 int result = query.executeUpdate();
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
	public boolean timeSheetDelete1(int timesheet_master_id){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 TimeSheetBean timeSheetBean = new TimeSheetBean();
			 timeSheetBean.setTimesheet_master_id(timesheet_master_id);
			 session.delete(timeSheetBean);
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
	public boolean timeSheetUnplanDelete1(int timesheet_master_id){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 UnplanProjectBean unplanProjectBean = new UnplanProjectBean();
			 unplanProjectBean.setTimesheet_unplan_project_id(timesheet_master_id);
			 session.delete(unplanProjectBean);
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
