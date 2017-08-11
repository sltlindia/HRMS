package com.hrms.recruitement.dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.recruitement.bean.JobLocationBean;
import com.hrms.recruitement.util.HibernateUtil;


public class JobLocationDAO {

	public List<JobLocationBean> getListOfJobLocation()
	{
        List<JobLocationBean> listOfJobLocation = new ArrayList<JobLocationBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfJobLocation = session.createQuery("FROM JobLocationBean order by job_location_name asc ").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfJobLocation;
        
	}

}
