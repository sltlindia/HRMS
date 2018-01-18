package com.hrms.timesheet.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.LoginDAO;

public class AjaxDataDAO {

	public List<ProjectMasterBean> getAllProject(String client_master_id) throws SQLException, Exception {
	
		List<ProjectMasterBean> listOfProject = new ArrayList<ProjectMasterBean>();
		List<ProjectMasterBean> listOfProject1 = new ArrayList<ProjectMasterBean>();
        Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfProject = session.createQuery("from ProjectMasterBean p where exists (from TaskMasterBean t where t.projectMasterBean = p.project_master_id and p.clientMasterBean="+client_master_id+" and p.projectStatusBean = 3)").list();
            
/*for(ProjectMasterBean p : listOfProject)
{
int project_id = p.getProject_master_id();
System.out.println("project_id:"+p.getProject_master_id());
listOfProject1 = session.createQuery("from ProjectMasterBean p  where exist (from TaskMasterBean t where projectMasterBean = project_master_id") .list();
}*/
            if(listOfProject.size() ==0)
            {
            	ProjectMasterBean bean = new ProjectMasterBean();
            	bean.setProject_master_id(0);
            	bean.setProject_master_name("--Select Project Name--");
            	listOfProject.add(bean);
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
        return listOfProject;
    }
	
/*public List<TaskMasterBean> getAllTask(String project_master_id,int dept_id,int emp_id) throws SQLException, Exception {
		
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
        Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            TaskMasterBean bean = new TaskMasterBean();
            listOfTask = session.createQuery("from TaskMasterBean t where not (exists (from ProjectAllocationBean p where p.projectMasterBean ="+project_master_id+" and p.employeeBean = "+emp_id+" and t.task_master_id = p.taskMasterBean ) or exists(from EmployeeBean e where e.managerBean = t.managerBean and e.departmentBean != '"+dept_id+"' )) and projectMasterBean='"+project_master_id+"'").list();
            
            if(listOfTask.size() == 0)
            {
            	bean.setTask_master_id(0);
            	bean.setTask_master_name("--Select Task Name--");
            	listOfTask.add(bean);
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
        return listOfTask;
    }*/



public List<TaskMasterBean> getAllTask(String project_id,int dept_id,int employee_master_id) throws SQLException, Exception {
	
	List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
    Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        TaskMasterBean bean = new TaskMasterBean();
        String hql = null;
        
        LoginDAO loginDAO = new LoginDAO();
        EmployeeBean employeeBean = loginDAO.getEmailIdEmployee(employee_master_id);
        String loctaion = employeeBean.getLocation();
        int under_manager_id = Integer.parseInt(employeeBean.getUnder_manager_id());
        
        if(employee_master_id == 1166 || employee_master_id == 1494){
        	dept_id = 18;
        	hql = "from TaskMasterBean t where (not exists (from ProjectAllocationBean p where p.projectMasterBean ="+project_id+" and p.employeeBean = "+employee_master_id+" and t.task_master_id = p.taskMasterBean ) and exists(from EmployeeBean e where (e.managerBean = t.managerBean or e.employee_master_id = t.emp_id) and (e.departmentBean = '"+dept_id+"' or e.managerBean = '"+under_manager_id+"'))) and projectMasterBean='"+project_id+"' and location='E2' and master_task_or_not = 0";
        }else if(employee_master_id == 1836){
        	dept_id = 18;
        	hql = "from TaskMasterBean t where (not exists (from ProjectAllocationBean p where p.projectMasterBean ="+project_id+" and p.employeeBean = "+employee_master_id+" and t.task_master_id = p.taskMasterBean ) and exists(from EmployeeBean e where (e.managerBean = t.managerBean or e.employee_master_id = t.emp_id) and (e.departmentBean = '"+dept_id+"' or e.managerBean = '"+under_manager_id+"'))) and projectMasterBean='"+project_id+"' and location='A8' and master_task_or_not = 0";
        }else{
        	hql = "from TaskMasterBean t where (not exists (from ProjectAllocationBean p where p.projectMasterBean ="+project_id+" and p.employeeBean = "+employee_master_id+" and t.task_master_id = p.taskMasterBean ) and exists(from EmployeeBean e where (e.managerBean = t.managerBean or e.employee_master_id = t.emp_id) and (e.departmentBean = '"+dept_id+"' or e.managerBean = '"+under_manager_id+"'))) and projectMasterBean='"+project_id+"' and master_task_or_not = 0";
        }
        
        Query query = session.createQuery(hql);
		 listOfTask = query.list();
        
		 //listOfTask = session.createQuery("from TaskMasterBean t where not (exists (from ProjectAllocationBean p where p.projectMasterBean ="+project_master_id+" and p.employeeBean = "+emp_id+" and t.task_master_id = p.taskMasterBean ) or exists(from EmployeeBean e where e.managerBean = t.managerBean and e.departmentBean != '"+dept_id+"' )) and projectMasterBean='"+project_master_id+"'").list();
        
        if(listOfTask.size() == 0)
        {
        	bean.setTask_master_id(0);
        	bean.setTask_master_name("--Select Task Name--");
        	listOfTask.add(bean);
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
    return listOfTask;
}
	
	/*public List<CityBean> getAllCity(String state_id) throws SQLException, Exception {
		
		List<CityBean> listOfCity = new ArrayList<CityBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfCity = session.createQuery("from CityBean where stateBean = '"+state_id+"'").list();
            
            if(listOfCity.size() ==0)
            {
            	CityBean bean = new CityBean();
            	bean.setCity_id(0);
            	bean.setCity_name("---select city---");
            	listOfCity.add(bean);
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
        return listOfCity;
    }
	
public List<AreaBean> getAllArea(String city_id) throws SQLException, Exception {
		
		List<AreaBean> listOfArea = new ArrayList<AreaBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfArea = session.createQuery("from AreaBean where cityBean = '"+city_id+"'").list();
            
            if(listOfArea.size() ==0)
            {
            	AreaBean bean = new AreaBean();
            	bean.setArea_id(0);
            	bean.setArea_name("---select area---");
            	listOfArea.add(bean);
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
        return listOfArea;
    }
*/

}
