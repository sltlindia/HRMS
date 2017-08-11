package com.hrms.grievancemanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.grievancemanagement.bean.GrievanceQueryBean;
import com.hrms.grievancemanagement.bean.GrievanceQueryTypeBean;
import com.hrms.grievancemanagement.bean.HrmsMailBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.util.HibernateUtil;

public class AllListGrievanceDAO {

	public List<GrievanceQueryBean> getListOfGrievanceQuery(int employee_id){
	    List<GrievanceQueryBean> listOfGrievanceQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfGrievanceQuery = session.createQuery("FROM GrievanceQueryBean WHERE employeeBean='"+employee_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfGrievanceQuery;
	    
	}
	
	public List<GrievanceQueryTypeBean> getListOfGrievanceQueryType(){
	    List<GrievanceQueryTypeBean> listOfGrievanceQueryType = new ArrayList<GrievanceQueryTypeBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfGrievanceQueryType = session.createQuery("FROM GrievanceQueryTypeBean order by grievance_query_type ASC").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfGrievanceQueryType;
	    
	}
	
	
	public List<GrievanceQueryBean> getListOfAllGrievanceQuery(){
	    List<GrievanceQueryBean> listOfAllGrievanceQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAllGrievanceQuery = session.createQuery("FROM GrievanceQueryBean").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllGrievanceQuery;
	    
	}
	
	
	public List<GrievanceQueryBean> getListOfPendingGrievanceQuery(){
	    List<GrievanceQueryBean> listOfPendingGrievanceQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfPendingGrievanceQuery = session.createQuery("FROM GrievanceQueryBean where status = 'pending' order by grievance_query_id desc ").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfPendingGrievanceQuery;
	    
	}
	
	public List<GrievanceQueryBean> getListOfPendingGrievanceQueryByEmployeeId(int employee_id){
	    List<GrievanceQueryBean> listOfPendingGrievanceQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfPendingGrievanceQuery = session.createQuery("FROM GrievanceQueryBean where status = 'pending' and employeeBean="+employee_id+" order by grievance_query_id desc").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfPendingGrievanceQuery;
	    
	}
	
	public List<GrievanceQueryBean> getListOfResolveGrievanceQuery(){
	    List<GrievanceQueryBean> listOfResolveGrievanceQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfResolveGrievanceQuery = session.createQuery("FROM GrievanceQueryBean where status = 'replied' and show_view=0  order by grievance_query_id desc").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfResolveGrievanceQuery;
	    
	}
	
	public List<GrievanceQueryBean> getListOfResolveGrievanceQueryByEmployeeId(int employee_id){
	    List<GrievanceQueryBean> listOfResolveGrievanceQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfResolveGrievanceQuery = session.createQuery("FROM GrievanceQueryBean where status = 'replied' and show_view=0 and employeeBean="+employee_id+" order by grievance_query_id desc").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfResolveGrievanceQuery;
	    
	}

	public List<GrievanceQueryBean> getListOfResolveQuery(String startDate, String endDate){
	    List<GrievanceQueryBean> listOfResolveQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfResolveQuery = session.createQuery("FROM GrievanceQueryBean where (date_of_submission BETWEEN '"+startDate+"' AND '"+endDate+"') and status = 'replied'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfResolveQuery;
	    
	}
	
	
	public List<GrievanceQueryBean> getListOfPendingQuery(String startDate, String endDate){
	    List<GrievanceQueryBean> listOfPendingQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfPendingQuery = session.createQuery("FROM GrievanceQueryBean where (date_of_submission BETWEEN '"+startDate+"' AND '"+endDate+"') and status = 'pending'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfPendingQuery;
	    
	}
	
	public List<GrievanceQueryBean> getListOfAllQuery(String startDate, String endDate){
	    List<GrievanceQueryBean> listOfAllQuery = new ArrayList<GrievanceQueryBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAllQuery = session.createQuery("FROM GrievanceQueryBean where (date_of_submission BETWEEN '"+startDate+"' AND '"+endDate+"') ").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllQuery;
	    
	}

	public List<HrmsMailBean> getAllMailList(){
	    List<HrmsMailBean> listOfAllMail = new ArrayList<HrmsMailBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAllMail = session.createQuery("FROM HrmsMailBean").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAllMail;
	    
	}

}
