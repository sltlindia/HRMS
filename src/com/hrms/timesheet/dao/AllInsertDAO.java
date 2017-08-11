package com.hrms.timesheet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.AllocationNotificationBean;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.timesheet.bean.DayBean;
import com.hrms.timesheet.bean.ProjectAllocationBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.timesheet.util.HibernateUtil;


public class AllInsertDAO {

	
	
	
	public boolean timeSheetInsert(TimeSheetBean timeSheetBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(timeSheetBean);
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
	
	
	public boolean timeSheetExternalTaskInsert(EmployeeBean employeeBean,ProjectMasterBean projectMasterBean,int task_id,ClientMasterBean clientMasterBean,DayBean dayBean,String date,double workedHour,String employee_comment,String task_time_status,String approval_status,double percentage_completed,String external_task){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 
			 TimeSheetBean timeSheetBean = new TimeSheetBean();
			 
			 timeSheetBean.setEmployeeBean(employeeBean);
			 timeSheetBean.setProjectMasterBean(projectMasterBean);
			 timeSheetBean.setClientMasterBean(clientMasterBean);
			 timeSheetBean.setDayBean(dayBean);
			 timeSheetBean.setDate(date);
			 timeSheetBean.setWorked_hours(workedHour);
			 timeSheetBean.setEmployee_comment(employee_comment);
			 timeSheetBean.setTask_time_status(task_time_status);
			 timeSheetBean.setApproval_status(approval_status);
			 timeSheetBean.setPercentage_completed(percentage_completed);
			 timeSheetBean.setExternal_task_name(external_task);

			 session.saveOrUpdate(timeSheetBean);
			 
			 int timesheet_master_id = timeSheetBean.getTimesheet_master_id();
			 
			 Query query = session.createQuery("update TimeSheetBean set taskMasterBean =:tmb where timesheet_master_id =:tmid");
			 query.setInteger("tmb", task_id);
			 query.setInteger("tmid", timesheet_master_id);
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
	
	
	public boolean timeSheetupdteEmployee(int timesheet_master_id,int project_master_id,int client_master_id,int task_master_id,double worked_hours,double leave_hours,String task_time_status,String employee_comment){
		 Session session = HibernateUtil.openSession();
//		int id =0;
//		int review_id;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set project_master_id =:pid,client_master_id =:cid,task_master_id =:tid, worked_hours =:wh,leave_hours =:lh,task_time_status =:tts,employee_comment =:ec where timesheet_master_id =:tmid");
			 query.setInteger("pid", project_master_id);
			 query.setInteger("cid", client_master_id);
			 query.setInteger("tid", task_master_id);
			 query.setDouble("wh", worked_hours);
			 query.setDouble("lh", leave_hours);
			 query.setParameter("tts", task_time_status);
			 query.setParameter("ec", employee_comment);
			 query.setInteger("tmid", timesheet_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result" + result);
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
	
	public boolean timeSheetupdteManager(int timesheet_master_id,int project_master_id,int client_master_id,int task_master_id,double worked_hours,double leave_hours,String task_time_status,String manager_comment){
		 Session session = HibernateUtil.openSession();
//		int id =0;
//		int review_id;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TimeSheetBean set project_master_id =:pid,client_master_id =:cid,task_master_id =:tid, worked_hours =:wh,leave_hours =:lh,task_time_status =:tts,manager_comment =:mc where timesheet_master_id =:tmid");
			 query.setInteger("pid", project_master_id);
			 query.setInteger("cid", client_master_id);
			 query.setInteger("tid", task_master_id);
			 query.setDouble("wh", worked_hours);
			 query.setDouble("lh", leave_hours);
			 query.setParameter("tts", task_time_status);
			 query.setParameter("mc", manager_comment);
			 query.setInteger("tmid", timesheet_master_id);
			 int result = query.executeUpdate();
			 System.out.println("result" + result);
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
	
	
	public boolean unplanProjectInsert(UnplanProjectBean unplanProjectBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(unplanProjectBean);
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
	
	
	
	
	
	
	public boolean taskInsert(TaskMasterBean taskMasterBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(taskMasterBean);
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
	
	
	
	public boolean ProjectAllocationPercentageInsert(int project_master_id,double per_allocation,int employee_id,String startDate,String endDate,double cost){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 
			 int allocation_status = 1;
			 
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			 EmployeeBean employeeBean = new EmployeeBean();  
			 
			 projectMasterBean.setProject_master_id(project_master_id);
			 employeeBean.setEmployee_master_id(employee_id);
			 
			 ProjectAllocationPercentageBean projectAllocationPercentageBean = new ProjectAllocationPercentageBean();
			 projectAllocationPercentageBean.setEmployeeBean(employeeBean);
			 projectAllocationPercentageBean.setProjectMasterBean(projectMasterBean);
			 projectAllocationPercentageBean.setPer_allocation(per_allocation);
			 projectAllocationPercentageBean.setAllocation_start_date(startDate);
			 projectAllocationPercentageBean.setAllocation_status(allocation_status);
			 projectAllocationPercentageBean.setAllocation_end_date(endDate);
			 projectAllocationPercentageBean.setCost(cost);
			 session.save(projectAllocationPercentageBean);
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
	
	

	
	
	
	public boolean projectAllocationInsert(YearBean yearBean,ProjectMasterBean projectMasterBean,MonthBean monthBean,EmployeeBean employeeBean,int manager_id,TaskMasterBean taskMasterBean){
		
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 
		 try {
				
			 tx = session.getTransaction();
			 tx.begin();
			 
			 
				 ProjectAllocationBean projectAllocationBean = new ProjectAllocationBean();
				 
					 
				 projectAllocationBean.setEmployeeBean(employeeBean);
				 projectAllocationBean.setMonthBean(monthBean);
				 projectAllocationBean.setYearBean(yearBean);
				 projectAllocationBean.setProjectMasterBean(projectMasterBean);
				 projectAllocationBean.setUnder_manager_id(manager_id);
				 projectAllocationBean.setTaskMasterBean(taskMasterBean);
				 projectAllocationBean.setAllocation_status(1);
				 session.saveOrUpdate(projectAllocationBean);
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
