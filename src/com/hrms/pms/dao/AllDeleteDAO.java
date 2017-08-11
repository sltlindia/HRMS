package com.hrms.pms.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.ProjectDocumentBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.SpecificCriteriaAllocationBean;
import com.hrms.pms.bean.SpecificCriteriaBean;
import com.hrms.pms.bean.SpecificCriteriaMonthBean;
import com.hrms.pms.bean.SpecificCriteriaSoftskillBean;
import com.hrms.pms.bean.SpecificCriteriaTechnicalBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.util.HibernateUtil;

public class AllDeleteDAO {
	
	public boolean projectDelete(int project_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean(); 
			 projectMasterBean.setProject_master_id(project_id);
			 session.delete(projectMasterBean);
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

	public boolean specificAlloctionDelete(int specific_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			SpecificCriteriaAllocationBean allocationBean = new SpecificCriteriaAllocationBean();
			allocationBean.setSpecific_criteria_id(specific_id);
			 session.delete(allocationBean);
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
	
	
	public boolean specificCriteriaAlloctionDelete(int specific_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			SpecificCriteriaBean specificCriteriaBean = new SpecificCriteriaBean();
			specificCriteriaBean.setSpecific_criteria_allocation_id(specific_id);
			session.delete(specificCriteriaBean);
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
	
	
	public boolean specificCriteriaAlloctionMonthDelete(int specific_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 SpecificCriteriaBean specificCriteriaBean = new SpecificCriteriaBean();
				specificCriteriaBean.setSpecific_criteria_allocation_id(specific_id);
			 
			SpecificCriteriaMonthBean specificCriteriaMonthBeanBean = new SpecificCriteriaMonthBean();
			specificCriteriaMonthBeanBean.setSpecificCriteriaBean(specificCriteriaBean);
			session.delete(specificCriteriaMonthBeanBean);
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
	
	public boolean specificCriteriaAlloctionSoftskillDelete(int specific_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 SpecificCriteriaBean specificCriteriaBean = new SpecificCriteriaBean();
				specificCriteriaBean.setSpecific_criteria_allocation_id(specific_id);
			 
			SpecificCriteriaSoftskillBean specificCriteriaSoftskillBean = new SpecificCriteriaSoftskillBean();
			specificCriteriaSoftskillBean.setSpecificCriteriaBean(specificCriteriaBean);
			session.delete(specificCriteriaSoftskillBean);
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
	
	public boolean specificCriteriaAlloctionTechnicalDelete(int specific_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 SpecificCriteriaBean specificCriteriaBean = new SpecificCriteriaBean();
				specificCriteriaBean.setSpecific_criteria_allocation_id(specific_id);
			 
			SpecificCriteriaTechnicalBean specificCriteriaTechnicalBean= new SpecificCriteriaTechnicalBean();
			specificCriteriaTechnicalBean.setSpecificCriteriaBean(specificCriteriaBean);
			session.delete(specificCriteriaTechnicalBean);
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
	
	
	public boolean taskDelete(int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			TaskMasterBean taskMasterBean = new TaskMasterBean();
			taskMasterBean.setTask_master_id(task_id);
			 session.delete(taskMasterBean);
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
	
	public boolean milestoneDelete(int milestone_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			MilestoneBean milestoneBean = new MilestoneBean();
			milestoneBean.setMilestone_id(milestone_id);
			 session.delete(milestoneBean);
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
	
	
	
	public boolean deptTaskRemove(int deptTaskId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectDepartmentTaskBean where project_department_task_id = :pdti");
			 query.setInteger("pdti",deptTaskId);
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
	
	
	public boolean documentDelete(int projectDocumentId){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ProjectDocumentBean projectDocumentBean = new ProjectDocumentBean(); 
			 projectDocumentBean.setProject_document_id(projectDocumentId);
			 session.delete(projectDocumentBean);
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
	
	
	
	public boolean taskDeleteByProejctId(int projectId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete TaskMasterBean where projectMasterBean = :pdti");
			 query.setInteger("pdti",projectId);
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
	
	
	public boolean allocationDeleteByProejctId(int projectId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectAllocationBean where projectMasterBean = :pdti");
			 query.setInteger("pdti",projectId);
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
	
	
	public boolean allocationPercentageDeleteByProejctId(int projectId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectAllocationPercentageBean where projectMasterBean = :pdti");
			 query.setInteger("pdti",projectId);
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
	
	
	
	
	public boolean projectInputHeadDeleteByProejctId(int projectId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectDesignHeadBean where projectMasterBean = :pdti");
			 query.setInteger("pdti",projectId);
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
	
	
	
	
	public boolean projectInputsDeleteByProejctId(int projectId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectDesignInputsBean where projectMasterBean = :pdti");
			 query.setInteger("pdti",projectId);
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
	
	public boolean allocationDeleteByTaskId(int taskId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectAllocationBean where taskMasterBean = :pdti");
			 query.setInteger("pdti",taskId);
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
	
	
	public boolean departmentDeleteByTaskId(int taskId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectDepartmentTaskBean where task_master_id = :pdti");
			 query.setInteger("pdti",taskId);
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
	
	
	
	
	public boolean departmentDeleteByManagerId(int manager_id,int project_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectDepartmentTaskBean where managerBean = :pdti and projectMasterBean = :pmi");
			 query.setInteger("pdti",manager_id);
			 query.setInteger("pmi",project_id);
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
	
	
	public boolean projectManagerDelete(int projectManagerId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectManagerListBean where project_manager_list_id = :pmli");
			 query.setInteger("pmli",projectManagerId);
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
	
	
	
	public boolean projectAssignManagerDelete(int assignId)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProjectAssignToManagerBean where project_assign_to_manager_id = :pstmi");
			 query.setInteger("pstmi",assignId);
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
	
	
	
	public boolean employeeDelete(int employee_dummy_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 EmployeeBean employeeBean = new EmployeeBean();
			 employeeBean.setEmployee_master_id(employee_dummy_id);
			 session.delete(employeeBean);
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
	
	public boolean OTPDeleted(int emp_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete OTPBean where employeeBean = :eid");
			 query.setInteger("eid",emp_id);
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
