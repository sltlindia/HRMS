package com.hrms.timesheet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.timesheet.util.HibernateUtil;

public class AllUpdateDAO {
	
	
	public boolean timeSheetStatusUpdate(int employee_id,String action,String date){
		 Session session = HibernateUtil.openSession();
//		int id =0;
//		int review_id;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set approval_status = :as where employee_master_id = :e and date =:d ");
			 query.setInteger("e", employee_id);
			 query.setString("as", action);
			 query.setString("d", date);
			 
			 
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

	
	
	public boolean timeSheetUnplanStatusUpdate(int employee_id,String action,String date){
		 Session session = HibernateUtil.openSession();
//		int id =0;
//		int review_id;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update UnplanProjectBean set approval_status = :as where employeeBean = :e and date =:d ");
			 query.setInteger("e", employee_id);
			 query.setString("as", action);
			 query.setString("d", date);
			 
			 
			 
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
	
	
	public boolean timeSheetStatusRejectUpdate(int employee_id,String action,String date,String remarks){
		 Session session = HibernateUtil.openSession();
//		int id =0;
//		int review_id;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set approval_status = :as, rejection_reason =:rr where employee_master_id = :e and date =:d ");
			 query.setInteger("e", employee_id);
			 query.setString("as", action);
			 query.setString("rr", remarks);
			 query.setString("d", date);
			 
			 
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
	
	
	
	public boolean timeSheetUnplanStatusRejectUpdate(int employee_id,String action,String date,String remarks){
		 Session session = HibernateUtil.openSession();
//		int id =0;
//		int review_id;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update UnplanProjectBean set approval_status = :as, rejection_reason =:rr where employeeBean = :e and date =:d ");
			 query.setInteger("e", employee_id);
			 query.setString("as", action);
			 query.setString("rr", remarks);
			 query.setString("d", date);
			 
			 
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

	
	
	public boolean timeSheetSubmitStatusUpdate(int employee_id,String date,String approval_status,String task_time_status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set task_time_status = :ts , approval_status = :as where employee_master_id = :e and date= :d ");
			 query.setInteger("e", employee_id);
			 query.setString("d", date);
			 query.setString("ts", task_time_status);
			 query.setString("as", approval_status);
			 
			 
			 
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
	
	public boolean timeSheetSubmitStatusUpdate1(int employee_id,String date){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set task_time_status = :ts where employee_master_id = :e and date= :d ");
			 query.setInteger("e", employee_id);
			 query.setString("d", date);
			 query.setString("ts", "updated");
			 
			 
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
	
	
	public boolean timeSheetUpdate(int timesheet_id,double workhour,double percentage_completed,String task_time_status,String comment,int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set worked_hours = :wh, percentage_completed = :pc ,task_time_status = :ts, employee_comment = :ec, taskMasterBean = :ti   where timesheet_master_id = :tmi");
			 query.setInteger("tmi", timesheet_id);
			 query.setInteger("ti", task_id);
			 query.setString("ts", task_time_status);
			 query.setDouble("wh", workhour);
			 query.setDouble("pc", percentage_completed);
			 query.setString("ec", comment);
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
	public boolean timeSheetEmployeeCommentUpdate(int employee_id,String date,String employee_comment){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set employee_comment = :ec where employee_master_id = :e and date= :d ");
			 query.setInteger("e", employee_id);
			 query.setString("d", date);
			 query.setString("ec", employee_comment);
			 
			 
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
	
	public boolean timeSheetUpdateAfterReject(int timesheet_id,double workhour,double percentage_completed,String task_time_status,String approval_status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set worked_hours = :wh, percentage_completed = :pc ,task_time_status = :ts , approval_status = :as where timesheet_master_id = :tmi ");
			 query.setInteger("tmi", timesheet_id);
			 query.setString("ts", task_time_status);
			 query.setString("as", approval_status);
			 query.setDouble("wh", workhour);
			 query.setDouble("pc", percentage_completed);
			 
			 
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

	
	public boolean timeSheetUnplanSubmitStatusUpdate(int employee_id,String date,String approval_status,String task_time_status){
		 Session session = HibernateUtil.openSession();
//		int id =0;
//		int review_id;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update  UnplanProjectBean set task_time_status = :ts , approval_status = :as where employeeBean = :e and date= :d ");
			 query.setInteger("e", employee_id);
			 query.setString("d", date);
			 query.setString("ts", task_time_status);
			 query.setString("as", approval_status);
			 
			
			 
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
	
	
	public boolean timeSheetUnplanUpdate(int timesheet_id,double workhour,double percentage_completed,String task_time_status,String comment,String task_name,String project_name){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update UnplanProjectBean set worked_hours = :wh, percentage_completed = :pc ,task_time_status = :ts, employee_comment = :ec, task_name = :tn, project_name = :pn    where timesheet_unplan_project_id = :tmi");
			 query.setInteger("tmi", timesheet_id);
			 query.setString("ts", task_time_status);
			 query.setDouble("wh", workhour);
			 query.setDouble("pc", percentage_completed);
			 query.setString("ec", comment);
			 query.setString("tn", task_name);
			 query.setString("pn", project_name);
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
