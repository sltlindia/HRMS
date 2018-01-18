package com.hrms.recruitement.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.recruitement.bean.CityBean;
import com.hrms.recruitement.bean.ManagerForVacancyBean;
import com.hrms.recruitement.bean.PostGraduateSpecificationBean;
import com.hrms.recruitement.bean.UnderGraduateSpecificationBean;

public class RecruitmentAjaxDataDAO {

	public List<ManagerForVacancyBean> getAllManagerForVacancy(String dept_id) throws SQLException, Exception {
		
		List<ManagerForVacancyBean> listOfManager = new ArrayList<ManagerForVacancyBean>();
	    Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfManager = session.createQuery("from ManagerForVacancyBean where dept_id='"+dept_id+"'").list();
	        tx.commit();
	        System.out.println("akash");
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfManager;
	}

	public List<CityBean> getAllState(String state_id) throws SQLException, Exception {
		
		List<CityBean> listOfState = new ArrayList<CityBean>();
	    Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfState = session.createQuery("from CityBean where state_id='"+state_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfState;
	}
	
public List<UnderGraduateSpecificationBean> getAllGraduateSpecification(String under_graduate_qualification_id) throws SQLException, Exception {
		
		List<UnderGraduateSpecificationBean> listOfGraduateSpecification = new ArrayList<UnderGraduateSpecificationBean>();
	    Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfGraduateSpecification = session.createQuery("from UnderGraduateSpecificationBean where under_graduate_qualification_id='"+under_graduate_qualification_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfGraduateSpecification;
	}
	
public List<PostGraduateSpecificationBean> getAllPostGraduateSpecification(String post_graduate_qualification_id) throws SQLException, Exception {
	
	List<PostGraduateSpecificationBean> listOfPostGraduateSpecification = new ArrayList<PostGraduateSpecificationBean>();
    Session session = com.hrms.timesheet.util.HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        listOfPostGraduateSpecification = session.createQuery("from PostGraduateSpecificationBean where post_graduate_qualification_id='"+post_graduate_qualification_id+"'").list();
        tx.commit();
    } catch (Exception e) {
        if (tx != null) {
            tx.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return listOfPostGraduateSpecification;
}

}
