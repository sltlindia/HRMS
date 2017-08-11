package com.hrms.recruitement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.recruitement.util.HibernateUtil;

public class CompanyListDAO {

	public List<CompanyListBean> getListOfCompanyList()
	{
        List<CompanyListBean> listOfCompanyList= new ArrayList<CompanyListBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfCompanyList = session.createQuery("FROM CompanyListBean").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfCompanyList;
        
	}
	
}
