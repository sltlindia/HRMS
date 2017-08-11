package com.hrms.timesheet.dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.bean.ProjectAllocationBean;
import com.hrms.timesheet.util.HibernateUtil;

public class LoginDAO {

    public boolean authenticateUser(int employee_code, String password) {
        EmployeeBean employeeBean = getUserByUserId(employee_code);       
        if(employeeBean!=null && employeeBean.getEmployee_code()==(employee_code)&& employeeBean.getPassword().equals(password)){
            return true;
        }else{ 
            return false;
        }
    }

    public EmployeeBean getUserByUserId(int employee_code) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        EmployeeBean employeeBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from EmployeeBean where employee_code="+employee_code+"");
            employeeBean = (EmployeeBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeBean;
    }
    
    public List<EmployeeBean> getListOfEmployee(){
        List<EmployeeBean> listofEmployee = new ArrayList<EmployeeBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listofEmployee = session.createQuery("from EmployeeBean").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listofEmployee;
    }
    
    
    public ProjectAllocationBean getAllocationByTaskId(int taskId,int employee_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        ProjectAllocationBean projectAllocationBean = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from ProjectAllocationBean where employeeBean="+employee_id+" and taskMasterBean="+taskId+" group by taskMasterBean");
            projectAllocationBean = (ProjectAllocationBean)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return projectAllocationBean;
    }
    
}
