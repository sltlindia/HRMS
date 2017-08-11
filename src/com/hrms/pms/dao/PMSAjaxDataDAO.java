package com.hrms.pms.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.TaskRemarkBean;
import com.hrms.pms.util.HibernateUtil;


public class PMSAjaxDataDAO {
	
	public boolean clientInsert(String client_name,String client_type) throws SQLException, Exception{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ClientMasterBean clientMasterBean = new ClientMasterBean();
			 clientMasterBean.setClient_master_name(client_name);
			 clientMasterBean.setClient_type(client_type);
			 session.saveOrUpdate(clientMasterBean);
			 System.out.println("inserted data");
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
	
	
	public List<ClientMasterBean> getListOfClient()
	{
	    List<ClientMasterBean> listOfClient = new ArrayList<ClientMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfClient = session.createQuery("FROM ClientMasterBean").list();                        
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfClient;
	    
	}
	
public List<TaskMasterBean> getAllTask(String project_master_id) throws SQLException, Exception {
		
		List<TaskMasterBean> listOfTask = new ArrayList<TaskMasterBean>();
        Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            TaskMasterBean bean = new TaskMasterBean();
            listOfTask = session.createQuery("from TaskMasterBean t where projectMasterBean = '"+project_master_id+"'").list();
            
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


//Akash Ramani
//Date : 23-03-2017
public boolean taskRemarkInsert(String task_id,String remarks,String remark_id){
	 Session session = HibernateUtil.openSession();
	 Transaction tx = null;
	 
	 System.out.println("remarks:"+remarks);
	 System.out.println("task_id:"+task_id);
	 System.out.println("remark_id"+remark_id);
	 
	 TaskMasterBean taskMasterBean = new TaskMasterBean();
	 taskMasterBean.setTask_master_id(Integer.parseInt(task_id));
	 
	 
	 TaskRemarkBean taskRemarkBean = new TaskRemarkBean();
	 taskRemarkBean.setRemarks(remarks);
	 taskRemarkBean.setTaskMasterBean(taskMasterBean);
	 
	 
	
	 
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 
		 if(Integer.parseInt(remark_id)!=0){
			 taskRemarkBean.setTask_remark_id(Integer.parseInt(remark_id));
			 session.update(taskRemarkBean);
		 }else{
			 session.save(taskRemarkBean);
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
	
	
}
