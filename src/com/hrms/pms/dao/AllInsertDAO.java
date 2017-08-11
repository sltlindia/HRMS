package com.hrms.pms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.bean.LeaveBalanceCSVUploadBean;
import com.hrms.pms.bean.AllocationNotificationBean;
import com.hrms.pms.bean.Appraisal5sBean;
import com.hrms.pms.bean.AppraisalBean;
import com.hrms.pms.bean.AppraisalCriteriaGradeBean;
import com.hrms.pms.bean.AppraisalKizenBean;
import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.AppraisalTrainingBean;
import com.hrms.pms.bean.AppraisalUpdateManagerScoreBean;
import com.hrms.pms.bean.AppraisalUpdateScoreBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.AppraisalWhiteCollarSection2Bean;
import com.hrms.pms.bean.AppraisalWhiteSection1Bean;
import com.hrms.pms.bean.ChangePriorityNotificationBean;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.CommentMilestoneBean;
import com.hrms.pms.bean.CommentTaskBean;
import com.hrms.pms.bean.CostFeasibilityBean;
import com.hrms.pms.bean.DependencyBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.EmployeeCSVUploadBean;
import com.hrms.pms.bean.EngineeringFeasibilityBean;
import com.hrms.pms.bean.FamilyDetailBean;
import com.hrms.pms.bean.FixtureFeasibiltyBean;
import com.hrms.pms.bean.GoalAllocationBean;
import com.hrms.pms.bean.GoalDefinitionBean;
import com.hrms.pms.bean.GoalEmployeeAllocationBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ManufacturingFeasibilityBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.MonthlyGoalDetailBean;
import com.hrms.pms.bean.OTPBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectAdminTaskBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectAssignToManagerBean;
import com.hrms.pms.bean.ProjectDepartmentTaskBean;
import com.hrms.pms.bean.ProjectDesignHeadBean;
import com.hrms.pms.bean.ProjectDesignInputsBean;
import com.hrms.pms.bean.ProjectDocumentBean;
import com.hrms.pms.bean.ProjectHoldHistoryBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ProjectUpdateNotificationBean;
import com.hrms.pms.bean.QualityFeasibilityBean;
import com.hrms.pms.bean.RecommendationBean;
import com.hrms.pms.bean.RecommendationOptionsBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.ReviewCriteriaBean;
import com.hrms.pms.bean.ReviewSoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaAllocationBean;
import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.pms.bean.SpecificCriteriaMonthBean;
import com.hrms.pms.bean.SpecificCriteriaSoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaTechnicalBean;
import com.hrms.pms.bean.StatusBean;
import com.hrms.pms.bean.SubGoalAllocationBean;
import com.hrms.pms.bean.TaskDateHistoryBean;
import com.hrms.pms.bean.TaskDefaultListBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.TaskRemarkBean;
import com.hrms.pms.bean.WorkGradeBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.bean.YearlyGoalBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.timesheet.bean.ProjectAllocationBean;


public class AllInsertDAO {

	
	public boolean reviewInsert(ReviewBean reviewBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(reviewBean);
			 id = reviewBean.getReview_id();
			 reviewBean.setReview_id(id);
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
	
	public boolean reviewCriteriaInsert(ReviewCriteriaBean reviewCriteriaBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(reviewCriteriaBean);		
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
	
	public boolean reviewSoftskillInsert(ReviewSoftskillBean reviewSoftskillBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(reviewSoftskillBean);		
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
	
	public boolean specificCrieriaInsert(YearBean yearBean,ProjectMasterBean projectMasterBean,MonthBean monthBean,EmployeeBean employeeBean,String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9,String t10,String t11,String t12,String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10,String s11,String s12,String s13,String s14,int manager_id,int dept_id,int technical_per,int softskill_per){
		
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 
		 try {
				
			 tx = session.getTransaction();
			 tx.begin();
			 
			 
				 SpecificCriteriaAllocationBean allocationBean = new SpecificCriteriaAllocationBean();
				 
					 
				 allocationBean.setEmployeeBean(employeeBean);
				 allocationBean.setMonthBean(monthBean);
				 allocationBean.setYearBean(yearBean);
				 allocationBean.setProjectMasterBean(projectMasterBean);
				 allocationBean.setT1(t1);
				 allocationBean.setT2(t2);
				 allocationBean.setT3(t3);
				 allocationBean.setT4(t4);
				 allocationBean.setT5(t5);
				 allocationBean.setT6(t6);
				 allocationBean.setT7(t7);
				 allocationBean.setT8(t8);
				 allocationBean.setT9(t9);
				 allocationBean.setT10(t10);
				 allocationBean.setT11(t11);
				 allocationBean.setT12(t12);
				 allocationBean.setS1(s1);
				 allocationBean.setS2(s2);
				 allocationBean.setS3(s3);
				 allocationBean.setS4(s4);
				 allocationBean.setS5(s5);
				 allocationBean.setS6(s6);
				 allocationBean.setS7(s7);
				 allocationBean.setS8(s8);
				 allocationBean.setS9(s9);
				 allocationBean.setS10(s10);
				 allocationBean.setS11(s11);
				 allocationBean.setS12(s12);
				 allocationBean.setS13(s13);
				 allocationBean.setS14(s14);
				 allocationBean.setUnder_dept_id(dept_id);
				 allocationBean.setTechnical_per(technical_per);
				 allocationBean.setSoftskill_per(softskill_per);
				 allocationBean.setUnder_manager_id(manager_id);
				 session.saveOrUpdate(allocationBean);
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
	
	
	public boolean specificCriteriaAllocationInsert(SpecificCriteriaBean specificCriteriaBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(specificCriteriaBean);		
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
	
	public boolean specificCriteriaAllocationMonthInsert(SpecificCriteriaMonthBean specificCriteriaMonthBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(specificCriteriaMonthBean);		
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
	
	
	public boolean specificCriteriaAllocationSoftskillInsert(SpecificCriteriaSoftskillBean specificCriteriaSoftskillBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(specificCriteriaSoftskillBean);		
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
	
	
	public boolean specificCriteriaAllocationTechnicalInsert(SpecificCriteriaTechnicalBean specificCriteriaTechnialBean){
		
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(specificCriteriaTechnialBean);		
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
	
	
	public boolean recommendationInsert(int employee_id,int review_id,int recommendation_id,String description){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 RecommendationBean recommendationBean= new RecommendationBean();
			 RecommendationOptionsBean recommendationOptionsBean = new RecommendationOptionsBean();
			 EmployeeBean employeeBean = new EmployeeBean();
			 ReviewBean reviewBean = new ReviewBean();
			 
			 employeeBean.setEmployee_master_id(employee_id);
			 reviewBean.setReview_id(review_id);
			 recommendationOptionsBean.setRecommendation_options_id(recommendation_id);
			 
				 
				 recommendationBean.setEmployeeBean(employeeBean);
				 recommendationBean.setReviewBean(reviewBean);
				 recommendationBean.setRecommendationOptionsBean(recommendationOptionsBean);
				 recommendationBean.setDescription(description);
				 session.save(recommendationBean);
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

	
	public boolean milestoneInsert(String milestone_name,String milestone_desc,PriorityBean priorityBean,ManagerBean managerBean,ProjectMasterBean projectMasterBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 MilestoneBean milestoneBean = new MilestoneBean();
			 milestoneBean.setMilestone_name(milestone_name);
			 milestoneBean.setMilestone_description(milestone_desc);
			 milestoneBean.setPriorityBean(priorityBean);
			 milestoneBean.setProjectMasterBean(projectMasterBean);
			 milestoneBean.setManagerBean(managerBean);
			 session.save(milestoneBean);		
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
	public boolean taskInsert(String task_name,String task_desc,String plannedStartDtae,String plannedEndDate,String Duration,double cost,int priority_id,int manager_id,int project_id,int dependent_id,String resources){
		 Session session = HibernateUtil.openSession();
		 int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 PriorityBean priorityBean = new PriorityBean();
			 ManagerBean managerBean = new ManagerBean();
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			 StatusBean statusBean = new StatusBean();
			 MilestoneBean milestoneBean = new MilestoneBean();
			 
			 priorityBean.setPriority_id(priority_id);
			 managerBean.setManager_id(manager_id);
			 projectMasterBean.setProject_master_id(project_id);
			 statusBean.setStatus_id(3);
			 milestoneBean.setMilestone_id(1);
			
			 
			 
			 
			TaskMasterBean taskMasterBean = new TaskMasterBean();
			
			taskMasterBean.setTask_master_name(task_name);
			taskMasterBean.setTask_description(task_desc);
			taskMasterBean.setTask_planned_start_date(plannedStartDtae);
			taskMasterBean.setTask_planned_end_date(plannedEndDate);
			taskMasterBean.setTask_estimated_duration(Duration);
			taskMasterBean.setTask_estimated_cost(cost);
			taskMasterBean.setPriorityBean(priorityBean);
			taskMasterBean.setManagerBean(managerBean);
			taskMasterBean.setProjectMasterBean(projectMasterBean);
			taskMasterBean.setStatusBean(statusBean);
			taskMasterBean.setMilestoneBean(milestoneBean);
			taskMasterBean.setTask_estimated_resources(resources);
			session.save(taskMasterBean);
			
			 System.out.println("task insert");
			id =taskMasterBean.getTask_master_id();
			System.out.println("DATA Id:"+id);
			
			
			DependencyBean dependencyBean = new DependencyBean();
			 
			 taskMasterBean.setTask_master_id(id);
			 
			 dependencyBean.setTaskMasterBean(taskMasterBean);
			 dependencyBean.setDependent_id(dependent_id);
			 session.saveOrUpdate(dependencyBean);
			 System.out.println("dependency insert");
			
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
	
	
	
	public boolean employeeInsert(EmployeeBean employeeBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(employeeBean);
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
	
	public boolean otpInsert(OTPBean otpBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(otpBean);
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
	
	
	public boolean managerInsert(ManagerBean managerBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(managerBean);
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
	
	
	public boolean employeeCSVInsert(EmployeeCSVUploadBean employeeCSVUploadBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(employeeCSVUploadBean);
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
	
	

	public boolean leaveBalanceCSVInsert(LeaveBalanceCSVUploadBean leaveBalanceCSVUploadBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(leaveBalanceCSVUploadBean);
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
	
	
	public boolean projectInsert(ProjectMasterBean projectMasterBean){
		 Session session = HibernateUtil.openSession();
		boolean result = false;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectMasterBean);		
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
	
	
	public boolean projectManagerInsert(ProjectManagerListBean projectManagerListBean){
		 Session session = HibernateUtil.openSession();
		boolean result = false;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectManagerListBean);		
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
	

	public boolean clientInsert(String name,String type){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 ClientMasterBean clientMasterBean = new ClientMasterBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 
			 clientMasterBean.setClient_master_name(name);
			 clientMasterBean.setClient_type(type);
			 session.saveOrUpdate(clientMasterBean);
			 id = clientMasterBean.getClient_master_id();
			 clientMasterBean.setClient_master_id(id);
			 System.out.println("id:"+id);
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
	
	public boolean milestoneInsert(MilestoneBean milestoneBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(milestoneBean);		
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
	
	
	
	public boolean taskInsert0(String task_name,String task_desc,String plannedStartDtae,String plannedEndDate,String Duration,double cost,int priority_id,int manager_id,int project_id,int dependent_id,String resources,int milestone_id,int task_id,int master_task_id, int master_task_or_not){
		 Session session = HibernateUtil.openSession();
		 int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 PriorityBean priorityBean = new PriorityBean();
			 ManagerBean managerBean = new ManagerBean();
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			 StatusBean statusBean = new StatusBean();
			 MilestoneBean milestoneBean = new MilestoneBean();
			 
			 priorityBean.setPriority_id(priority_id);
			 managerBean.setManager_id(manager_id);
			 projectMasterBean.setProject_master_id(project_id);
			 statusBean.setStatus_id(3);
			 milestoneBean.setMilestone_id(milestone_id);
			
			 
			 
			 
			TaskMasterBean taskMasterBean = new TaskMasterBean();
			
			taskMasterBean.setTask_master_name(task_name);
			taskMasterBean.setTask_description(task_desc);
			taskMasterBean.setTask_planned_start_date(plannedStartDtae);
			taskMasterBean.setTask_planned_end_date(plannedEndDate);
			taskMasterBean.setTask_estimated_duration(Duration);
			taskMasterBean.setTask_estimated_cost(cost);
			taskMasterBean.setPriorityBean(priorityBean);
			taskMasterBean.setManagerBean(managerBean);
			taskMasterBean.setProjectMasterBean(projectMasterBean);
			taskMasterBean.setStatusBean(statusBean);
			taskMasterBean.setMilestoneBean(milestoneBean);
			taskMasterBean.setTask_estimated_resources(resources);
			taskMasterBean.setTask_id(task_id);
			taskMasterBean.setMaster_task_id(master_task_id);
			taskMasterBean.setMaster_task_or_not(master_task_or_not);
			session.save(taskMasterBean);
			
			 System.out.println("task insert");
			 id =taskMasterBean.getTask_master_id();			
			
			 DependencyBean dependencyBean = new DependencyBean();
			 
			 taskMasterBean.setTask_master_id(id);
			 
			 dependencyBean.setTaskMasterBean(taskMasterBean);
			 dependencyBean.setDependent_id(dependent_id);
			 session.saveOrUpdate(dependencyBean);
			 System.out.println("dependency insert");
			 
			 
			 
 AllListDAO allListDAO = new AllListDAO();
 
			 if(task_name.equalsIgnoreCase("Planning")){
				 
				 List<TaskDefaultListBean> listOfDefaultList = allListDAO.getListOfDefaultTask(18);
				 for(TaskDefaultListBean defaultListBean : listOfDefaultList){
					 ManagerBean managerBean2 = new ManagerBean();
					 managerBean2.setManager_id(201);
					 TaskMasterBean taskMasterBean2 = new TaskMasterBean();
					 	taskMasterBean2.setTask_master_name(defaultListBean.getTask_default_list_name());
						taskMasterBean2.setTask_description(defaultListBean.getTask_default_list_name());
						taskMasterBean2.setTask_planned_start_date(plannedStartDtae);
						taskMasterBean2.setTask_planned_end_date(plannedStartDtae);
						taskMasterBean2.setTask_estimated_duration(Duration);
						taskMasterBean2.setTask_estimated_cost(cost);
						taskMasterBean2.setPriorityBean(priorityBean);
						taskMasterBean2.setManagerBean(managerBean2);
						taskMasterBean2.setProjectMasterBean(projectMasterBean);
						taskMasterBean2.setStatusBean(statusBean);
						taskMasterBean2.setMilestoneBean(milestoneBean);
						taskMasterBean2.setTask_estimated_resources(resources);
						taskMasterBean2.setTask_id(0);
						taskMasterBean2.setMaster_task_id(master_task_id);
						taskMasterBean2.setMaster_task_or_not(0);
						taskMasterBean2.setLocation("E2");
						session.save(taskMasterBean2);
				 }
			 }
			 
			 
			 
			 if(task_name.equalsIgnoreCase("Procurement")){
			  	ManagerBean managerBean2 = new ManagerBean();
					 managerBean2.setManager_id(201);
				 	/*TaskMasterBean taskMasterBean3 = new TaskMasterBean();
				 	
				 	taskMasterBean3.setTask_master_name("In House Production in A8");
					taskMasterBean3.setTask_description("In House Production in A8");
					taskMasterBean3.setTask_planned_start_date(plannedStartDtae);
					taskMasterBean3.setTask_planned_end_date(plannedEndDate);
					taskMasterBean3.setTask_estimated_duration(Duration);
					taskMasterBean3.setTask_estimated_cost(cost);
					taskMasterBean3.setPriorityBean(priorityBean);
					taskMasterBean3.setManagerBean(managerBean2);
					taskMasterBean3.setProjectMasterBean(projectMasterBean);
					taskMasterBean3.setStatusBean(statusBean);
					taskMasterBean3.setMilestoneBean(milestoneBean);
					taskMasterBean3.setTask_estimated_resources(resources);
					taskMasterBean3.setTask_id(0);
					taskMasterBean3.setMaster_task_id(master_task_id);
					taskMasterBean3.setMaster_task_or_not(0);
					session.save(taskMasterBean3);
				 
					int tId = taskMasterBean3.getTask_master_id();*/
					
				 
				 List<TaskDefaultListBean> listOfDefaultList = allListDAO.getListOfDefaultTask(20);
				 for(TaskDefaultListBean defaultListBean : listOfDefaultList){
					 TaskMasterBean taskMasterBean4 = new TaskMasterBean();
					 	
					 	taskMasterBean4.setTask_master_name(defaultListBean.getTask_default_list_name());
						taskMasterBean4.setTask_description(defaultListBean.getTask_default_list_name());
						taskMasterBean4.setTask_planned_start_date(plannedStartDtae);
						taskMasterBean4.setTask_planned_end_date(plannedStartDtae);
						taskMasterBean4.setTask_estimated_duration(Duration);
						taskMasterBean4.setTask_estimated_cost(cost);
						taskMasterBean4.setPriorityBean(priorityBean);
						taskMasterBean4.setManagerBean(managerBean2);
						taskMasterBean4.setProjectMasterBean(projectMasterBean);
						taskMasterBean4.setStatusBean(statusBean);
						taskMasterBean4.setMilestoneBean(milestoneBean);
						taskMasterBean4.setTask_estimated_resources(resources);
						taskMasterBean4.setTask_id(0);
						taskMasterBean4.setMaster_task_id(master_task_id);
						taskMasterBean4.setMaster_task_or_not(0);
						taskMasterBean4.setLocation("A8");
						session.save(taskMasterBean4);
				 }
				 
				 
				 TaskMasterBean taskMasterBean5 = new TaskMasterBean();
				 	
				 	taskMasterBean5.setTask_master_name("Bought out Item");
					taskMasterBean5.setTask_description("Bought out Item");
					taskMasterBean5.setTask_planned_start_date(plannedStartDtae);
					taskMasterBean5.setTask_planned_end_date(plannedStartDtae);
					taskMasterBean5.setTask_estimated_duration(Duration);
					taskMasterBean5.setTask_estimated_cost(cost);
					taskMasterBean5.setPriorityBean(priorityBean);
					taskMasterBean5.setManagerBean(managerBean);
					taskMasterBean5.setProjectMasterBean(projectMasterBean);
					taskMasterBean5.setStatusBean(statusBean);
					taskMasterBean5.setMilestoneBean(milestoneBean);
					taskMasterBean5.setTask_estimated_resources(resources);
					taskMasterBean5.setTask_id(id);
					taskMasterBean5.setMaster_task_id(master_task_id);
					taskMasterBean5.setMaster_task_or_not(master_task_or_not);
					session.save(taskMasterBean5);
				 
			 }
			 
			 
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
	
	public boolean taskInsert(String task_name,String task_desc,String plannedStartDtae,String plannedEndDate,String Duration,double cost,int priority_id,int manager_id,int project_id,int dependent_id,String resources,int milestone_id,int task_id,int master_task_id){
		 Session session = HibernateUtil.openSession();
		 int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 PriorityBean priorityBean = new PriorityBean();
			 ManagerBean managerBean = new ManagerBean();
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			 StatusBean statusBean = new StatusBean();
			 MilestoneBean milestoneBean = new MilestoneBean();
			 
			 priorityBean.setPriority_id(priority_id);
			 managerBean.setManager_id(manager_id);
			 projectMasterBean.setProject_master_id(project_id);
			 statusBean.setStatus_id(3);
			 milestoneBean.setMilestone_id(milestone_id);
			
			 
			 
			 
			TaskMasterBean taskMasterBean = new TaskMasterBean();
			
			taskMasterBean.setTask_master_name(task_name);
			taskMasterBean.setTask_description(task_desc);
			taskMasterBean.setTask_planned_start_date(plannedStartDtae);
			taskMasterBean.setTask_planned_end_date(plannedEndDate);
			taskMasterBean.setTask_estimated_duration(Duration);
			taskMasterBean.setTask_estimated_cost(cost);
			taskMasterBean.setPriorityBean(priorityBean);
			taskMasterBean.setManagerBean(managerBean);
			taskMasterBean.setProjectMasterBean(projectMasterBean);
			taskMasterBean.setStatusBean(statusBean);
			taskMasterBean.setMilestoneBean(milestoneBean);
			taskMasterBean.setTask_estimated_resources(resources);
			taskMasterBean.setTask_id(task_id);
			taskMasterBean.setMaster_task_id(master_task_id);
			session.save(taskMasterBean);
			
			 System.out.println("task insert");
			 id =taskMasterBean.getTask_master_id();			
			
			DependencyBean dependencyBean = new DependencyBean();
			 
			 taskMasterBean.setTask_master_id(id);
			 
			 dependencyBean.setTaskMasterBean(taskMasterBean);
			 dependencyBean.setDependent_id(dependent_id);
			 session.saveOrUpdate(dependencyBean);
			 System.out.println("dependency insert");
			
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
	
	
	
	public boolean taskInsert1(String task_name,String task_desc,String plannedStartDtae,String plannedEndDate,String Duration,double cost,int priority_id,int manager_id,int project_id,int dependent_id,String resources,int milestone_id,int task_id,int milestoneId){
		 Session session = HibernateUtil.openSession();
		 int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 PriorityBean priorityBean = new PriorityBean();
			 ManagerBean managerBean = new ManagerBean();
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			 StatusBean statusBean = new StatusBean();
			 MilestoneBean milestoneBean = new MilestoneBean();
			 
			 priorityBean.setPriority_id(priority_id);
			 managerBean.setManager_id(manager_id);
			 projectMasterBean.setProject_master_id(project_id);
			 statusBean.setStatus_id(3);
			 milestoneBean.setMilestone_id(milestone_id);
			
			 
			 
			 
			TaskMasterBean taskMasterBean = new TaskMasterBean();
			
			taskMasterBean.setTask_master_name(task_name);
			taskMasterBean.setTask_description(task_desc);
			taskMasterBean.setTask_planned_start_date(plannedStartDtae);
			taskMasterBean.setTask_planned_end_date(plannedEndDate);
			taskMasterBean.setTask_estimated_duration(Duration);
			taskMasterBean.setTask_estimated_cost(cost);
			taskMasterBean.setPriorityBean(priorityBean);
			taskMasterBean.setManagerBean(managerBean);
			taskMasterBean.setProjectMasterBean(projectMasterBean);
			taskMasterBean.setStatusBean(statusBean);
			taskMasterBean.setMilestoneBean(milestoneBean);
			taskMasterBean.setTask_estimated_resources(resources);
			taskMasterBean.setTask_id(task_id);
			session.save(taskMasterBean);
			
			 System.out.println("task insert");
			 id =taskMasterBean.getTask_master_id();
			 
			 Query query = session.createQuery("update TaskMasterBean set task_id = :ti where milestoneBean = :mb1");
			 query.setInteger("ti", id);
			 query.setInteger("mb1", milestoneId);
			 int result = query.executeUpdate();
			
			DependencyBean dependencyBean = new DependencyBean();
			 
			 taskMasterBean.setTask_master_id(id);
			 
			 dependencyBean.setTaskMasterBean(taskMasterBean);
			 dependencyBean.setDependent_id(dependent_id);
			 session.saveOrUpdate(dependencyBean);
			 System.out.println("dependency insert");
			
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
	
	
	
	public boolean projectAllocationInsert(YearBean yearBean,ProjectMasterBean projectMasterBean,MonthBean monthBean,EmployeeBean employeeBean,int manager_id,TaskMasterBean taskMasterBean,int myId){
		
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
				 
				 int id = projectAllocationBean.getProject_Allocation_id();
				 System.out.println("pid:"+id);
				 projectAllocationBean.setProject_Allocation_id(id);
				 
				 AllocationNotificationBean allocationNotificationBean = new AllocationNotificationBean();
				 EmployeeBean employeeBean2 = new EmployeeBean();
				 employeeBean2.setEmployee_master_id(myId);
				 
				 allocationNotificationBean.setProjectAllocationBean(projectAllocationBean);
				 allocationNotificationBean.setEmployeeBean(employeeBean2);
				 allocationNotificationBean.setShow_view(0);
				 session.save(allocationNotificationBean);
				 
				 int allocation_id = allocationNotificationBean.getAllocation_notification_id();
				 System.out.println("allocatio_id:"+allocation_id);
				 
				 Query query = session.createQuery("update AllocationNotificationBean set allocationPercentageBean = :apb where allocation_notification_id = :ani");
				 query.setInteger("apb", 0);
				 query.setInteger("ani", allocation_id);
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
	
	
	public boolean taskDependencyInsert(int task_master_id,int dependent_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 DependencyBean dependencyBean = new DependencyBean();
			 
			 TaskMasterBean taskMasterBean = new TaskMasterBean();
			 taskMasterBean.setTask_master_id(task_master_id);
			 
			 dependencyBean.setTaskMasterBean(taskMasterBean);
			 dependencyBean.setDependent_id(dependent_id);
			 session.save(dependencyBean);
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
	
	public boolean cahngePriorityNotificationInsert(int project_id,int employee_id,int priority_id, int milestone_id, int show_notification,int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			
			 
			 ProjectMasterBean  projectMasterBean = new ProjectMasterBean();
			 EmployeeBean employeeBean = new EmployeeBean();
			 MilestoneBean milestoneBean = new MilestoneBean();
			 TaskMasterBean taskMasterBean = new TaskMasterBean();
			 PriorityBean priorityBean = new PriorityBean();
			 
			 projectMasterBean.setProject_master_id(project_id);
			 employeeBean.setEmployee_master_id(employee_id);
			 priorityBean.setPriority_id(priority_id);
			 milestoneBean.setMilestone_id(milestone_id);
			 
			 ChangePriorityNotificationBean changePriorityNotificationBean = new ChangePriorityNotificationBean();
			 
			 changePriorityNotificationBean.setProjectMasterBean(projectMasterBean);
			 changePriorityNotificationBean.setMilestoneBean(milestoneBean);
			 changePriorityNotificationBean.setPriorityBean(priorityBean);
			 changePriorityNotificationBean.setEmployeeBean(employeeBean);
			 changePriorityNotificationBean.setShow_notification(show_notification);
			 session.save(changePriorityNotificationBean);
			 int id = changePriorityNotificationBean.getChange_priority_notification_id();
			  System.out.println(id);
			  
			  Query query = session.createQuery("update ChangePriorityNotificationBean set taskMasterBean = :tmb where change_priority_notification_id = :cpni");
				 query.setInteger("tmb", task_id);
				 query.setInteger("cpni", id);
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
	
	
	public boolean ProjectAllocationPercentageInsert(int project_master_id,double per_allocation,int employee_id,String startDate,String endDate,double cost,int myId){
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
			 
			 int id = projectAllocationPercentageBean.getProject_allocation_percentage_id();
			 System.out.println("pid:"+id);
			 projectAllocationPercentageBean.setProject_allocation_percentage_id(id);
			 employeeBean.setEmployee_master_id(myId);
			 
			 AllocationNotificationBean allocationNotificationBean = new AllocationNotificationBean();
			 
			 allocationNotificationBean.setAllocationPercentageBean(projectAllocationPercentageBean);
			 allocationNotificationBean.setEmployeeBean(employeeBean);
			 allocationNotificationBean.setShow_view(0);
			 
			 session.save(allocationNotificationBean);
			 
			 int allocation_id = allocationNotificationBean.getAllocation_notification_id();
			 
			 Query query = session.createQuery("update AllocationNotificationBean set projectAllocationBean = :pab where allocation_notification_id = :ani");
			 query.setInteger("pab", 0);
			 query.setInteger("ani", allocation_id);
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
	
	public boolean projectUpdateNotificationInsert(int project_id,int employee_id,int resource_change,int start_date_change,int end_date_change){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			 EmployeeBean employeeBean = new EmployeeBean();
			 ProjectUpdateNotificationBean projectUpdateNotificationBean = new ProjectUpdateNotificationBean();
			 
			 projectMasterBean.setProject_master_id(project_id);
			 employeeBean.setEmployee_master_id(employee_id);
			 
			 projectUpdateNotificationBean.setProjectMasterBean(projectMasterBean);
			 projectUpdateNotificationBean.setEmployeeBean(employeeBean);
			 projectUpdateNotificationBean.setResource_change(resource_change);
			 projectUpdateNotificationBean.setStart_date_change(start_date_change);
			 projectUpdateNotificationBean.setEnd_date_change(end_date_change);
			 projectUpdateNotificationBean.setShow_view(0);
			 session.save(projectUpdateNotificationBean);
			 
			 int id = projectUpdateNotificationBean.getProject_update_notification_id();
			 Query query = session.createQuery("update ProjectUpdateNotificationBean set taskMasterBean = :tb where project_update_notification_id = :puni ");
			 query.setInteger("tb", 0);
			 query.setInteger("puni", id);
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
	
	public boolean projectUpdateNotificationInsert1(int project_id,int employee_id,int resource_change,int start_date_change,int end_date_change,int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			 EmployeeBean employeeBean = new EmployeeBean();
			 TaskMasterBean taskMasterBean = new TaskMasterBean();
			 ProjectUpdateNotificationBean projectUpdateNotificationBean = new ProjectUpdateNotificationBean();
			 
			 projectMasterBean.setProject_master_id(project_id);
			 employeeBean.setEmployee_master_id(employee_id);
			 taskMasterBean.setTask_master_id(task_id);
			 
			 projectUpdateNotificationBean.setProjectMasterBean(projectMasterBean);
			 projectUpdateNotificationBean.setEmployeeBean(employeeBean);
			 projectUpdateNotificationBean.setResource_change(resource_change);
			 projectUpdateNotificationBean.setStart_date_change(start_date_change);
			 projectUpdateNotificationBean.setEnd_date_change(end_date_change);
			 projectUpdateNotificationBean.setShow_view(0);
			 projectUpdateNotificationBean.setTaskMasterBean(taskMasterBean);
			 session.save(projectUpdateNotificationBean);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean milestoneCommentInsert(CommentMilestoneBean commentMilestoneBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(commentMilestoneBean);
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
	
	public boolean taskCommentInsert(CommentTaskBean commentTaskBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(commentTaskBean);
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
	
	
	public boolean EngineeringFeasibiltyInsert(EngineeringFeasibilityBean engineeringFeasibilityBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(engineeringFeasibilityBean);
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
	
	
	public boolean FixtureFeasiblityInsert(FixtureFeasibiltyBean fixtureFeasibiltyBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(fixtureFeasibiltyBean);
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
	
	
	public boolean ManufactureFeasiblityInsert(ManufacturingFeasibilityBean manufacturingFeasibilityBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(manufacturingFeasibilityBean);
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
	
	
	public boolean QualityFeasiblityInsert(QualityFeasibilityBean qualityFeasibilityBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(qualityFeasibilityBean);
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
	
	
	public boolean CostFeasiblityInsert(CostFeasibilityBean costFeasibilitybean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(costFeasibilitybean);
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
	
	
	public boolean clientInsert(ClientMasterBean clientMasterBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(clientMasterBean);
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
	
	public boolean designHeadInputInsert(ProjectDesignHeadBean projectDesignHeadBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectDesignHeadBean);
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
	
	
	public boolean designInputInsert(ProjectDesignInputsBean projectDesignInputsBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectDesignInputsBean);
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
	
	
	public boolean projectAdminTaskInsert(ProjectAdminTaskBean projectAdminTaskBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectAdminTaskBean);
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
	
	
	public boolean taskInsertByDepartment(ProjectDepartmentTaskBean projectDepartmentTaskBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectDepartmentTaskBean);
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
	
	
	public boolean taskDateHistoryInsert(TaskDateHistoryBean taskDateHistoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(taskDateHistoryBean);
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
	
	
	public boolean taskInsert(TaskMasterBean taskMasterBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(taskMasterBean);
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
	
	
	public boolean projectManagerAssignInsert(ProjectAssignToManagerBean projectAssignToManagerBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectAssignToManagerBean);
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
	
	
	public boolean projectDocumentInsert(ProjectDocumentBean projectDocumentBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(projectDocumentBean);
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
	
	
	public boolean taskRemarkInsert(TaskRemarkBean taskRemarkBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(taskRemarkBean);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean appraisalInsert(AppraisalBean appraisalBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalBean);		
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
	
	
	public boolean appraisalLeaveInsert(AppraisalLeaveBean appraisalLeaveBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(appraisalLeaveBean);		
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
	
	
	public boolean appraisalKizenInsert(AppraisalKizenBean appraisalKizenBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalKizenBean);		
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
	
	public boolean appraisal5sInsert(Appraisal5sBean appraisal5sBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisal5sBean);		
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
	
	
	public boolean appraisalTrainingInsert(AppraisalTrainingBean appraisalTrainingBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalTrainingBean);		
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
	
	
	public boolean appraisalGradeInsert(AppraisalCriteriaGradeBean appraisalCriteriaGradeBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalCriteriaGradeBean);		
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
	
	public boolean appraisalwhiteSection1Insert(AppraisalWhiteSection1Bean appraisalWhiteSection1Bean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalWhiteSection1Bean);		
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
	
	public boolean appraisalwhiteSection11Insert(AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalWhiteCollarGradeBean);
			 int id = appraisalWhiteCollarGradeBean.getAppraisal_white_grade_id();
			 Query query = session.createQuery("update AppraisalWhiteCollarGradeBean set appraisalGradeBean = :ag where appraisal_white_grade_id = :awgi ");
			 query.setInteger("ag", 0);
			 query.setInteger("awgi", id);
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
	
	
	public boolean appraisalwhiteSection2Insert(AppraisalWhiteCollarSection2Bean appraisalWhiteCollarSection2Bean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalWhiteCollarSection2Bean);
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
	
	public boolean workGradeInsert(WorkGradeBean workGradeBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(workGradeBean);
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
	
	
	public boolean managerScoreUpdateInsert(AppraisalUpdateManagerScoreBean appraisalUpdateManagerScoreBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalUpdateManagerScoreBean);
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
	
	public boolean ScoreUpdateInsert(AppraisalUpdateScoreBean appraisalUpdateScoreBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appraisalUpdateScoreBean);
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
	
	public boolean goalInsert(GoalDefinitionBean goalDefinitionBean){
		 Session session = HibernateUtil.openSession();
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(goalDefinitionBean);
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
	
	
	public boolean yearlyGoalInsert(YearlyGoalBean yearlyGoalBean ){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(yearlyGoalBean);
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
	
	
	public boolean yearlyGoalAllocationInsert(GoalAllocationBean goalAllocationBean ){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(goalAllocationBean);
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
	
	public boolean GoalEmployeeAllocationInsert(GoalEmployeeAllocationBean goalEmployeeAllocationBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(goalEmployeeAllocationBean);
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
	
	
	public boolean MonthlyGoalDetailInsert(MonthlyGoalDetailBean monthlyGoalDetailBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(monthlyGoalDetailBean);
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
	
	
	public boolean subGoalInsert(SubGoalAllocationBean subGoalAllocationBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(subGoalAllocationBean);
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
	
	
	public boolean holdHistoryInsert(ProjectHoldHistoryBean projectHoldHistoryBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(projectHoldHistoryBean);
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
	
	
	
	//Insert into family_detail_tbl
		//Date : 13-06-2017
		//Name : Bhoomi Patel
		
		public boolean familyDetailInsert(FamilyDetailBean familyDetailBean){
			 Session session = HibernateUtil.openSession();
			int id =0;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(familyDetailBean);
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
