package com.hrms.recruitement.dao;

import java.util.ArrayList;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.util.HibernateUtil;


public class DepartmentDAO {
	
	public List<DepartmentBean> getListOfDepartment()
	{
        List<DepartmentBean> listOfDepartment= new ArrayList<DepartmentBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfDepartment = session.createQuery("FROM DepartmentBean order by department_name asc").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfDepartment;
        
	}

}
