package com.hrms.corehr.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.corehr.bean.CUGBean;
import com.hrms.corehr.bean.CompanyAdressBean;
import com.hrms.corehr.bean.ExtentionNumberBean;
import com.hrms.corehr.bean.InterviewTrackerDesignationBean;
import com.hrms.corehr.bean.SubDepartmentBean;
import com.hrms.lms.bean.LeaveBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.util.HibernateUtil;

public class AllListCoreHrDAO {

	
	public List<SubDepartmentBean> getListOfSubDepartent()
	{
	List<SubDepartmentBean> listOfSubDepartment = new ArrayList<SubDepartmentBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from SubDepartmentBean";
		 Query query = session.createQuery(hql);
		 listOfSubDepartment = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfSubDepartment;
	}
	
	public List<InterviewTrackerDesignationBean> getListOfInterviewDesignation()
	{
	List<InterviewTrackerDesignationBean> listOfSubDepartment = new ArrayList<InterviewTrackerDesignationBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from InterviewTrackerDesignationBean";
		 Query query = session.createQuery(hql);
		 listOfSubDepartment = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfSubDepartment;
	}

	public List<CompanyAdressBean> getListOfCompanyAdress()
	{
	List<CompanyAdressBean> listOfCompanyAdd = new ArrayList<CompanyAdressBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from CompanyAdressBean order by id DESC";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	
	
	public List<ExtentionNumberBean> getListOfExtentionNumber()
	{
	List<ExtentionNumberBean> listOfCompanyAdd = new ArrayList<ExtentionNumberBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from ExtentionNumberBean where companyname = 'E - 30'";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	
	public List<ExtentionNumberBean> getListOfExtentionNumberE2()
	{
	List<ExtentionNumberBean> listOfCompanyAdd = new ArrayList<ExtentionNumberBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from ExtentionNumberBean where companyname = 'E - 2'";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	
	public List<ExtentionNumberBean> getListOfExtentionNumberA8()
	{
	List<ExtentionNumberBean> listOfCompanyAdd = new ArrayList<ExtentionNumberBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from ExtentionNumberBean where companyname = 'A - 8'";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	
	public List<CUGBean> getListOfCugNo()
	{
	List<CUGBean> listOfCompanyAdd = new ArrayList<CUGBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from CUGBean c where not exists (from EmployeeBean e where c.mob_num = e.cug_num)";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	
	
	public List<EmployeeBean> getListOfCugNoFromEmployee()
	
	{
	List<EmployeeBean> listOfCompanyAdd = new ArrayList<EmployeeBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from EmployeeBean where cug_num != 'null'";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	
	
	
	public List<ExtentionNumberBean> getListOfExtentionNumberSurat()
	{
	List<ExtentionNumberBean> listOfCompanyAdd = new ArrayList<ExtentionNumberBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from ExtentionNumberBean where companyname = 'Surat'";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	
	public List<ExtentionNumberBean> getListOfExtentionNumberNY()
	{
	List<ExtentionNumberBean> listOfCompanyAdd = new ArrayList<ExtentionNumberBean>();
	Session session = HibernateUtil.openSession();
	Transaction tx = null;        
	try {
	    tx = session.getTransaction();
	    tx.begin();
	    String hql = "from ExtentionNumberBean where companyname = 'New York Tower'";
		 Query query = session.createQuery(hql);
		 listOfCompanyAdd = query.list();
	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
	        tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    session.close();
	}
	return listOfCompanyAdd;
	}
	

	//Store Procedure For CUG List 
			@SuppressWarnings("unchecked")
			public List<CUGBean> SPgetListOfCugNo() {

				List<CUGBean> listOfCUGNo = new ArrayList<CUGBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL listOfCugNo()")
		                    .addEntity(CUGBean.class);
					listOfCUGNo = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfCUGNo;
			}
			
			
			//Store Procedure For CUG List 
			@SuppressWarnings("unchecked")
			public List<EmployeeBean> SPgetListOfCugNoFromEmployee() {

				List<EmployeeBean> listOfCUGNo = new ArrayList<EmployeeBean>();
				Session session = HibernateUtil.openSession();
				Transaction tx = null;
				try {
					tx = session.getTransaction();
					tx.begin();
					
					SQLQuery query = (SQLQuery) session.createSQLQuery("CALL listOfCugNoFromEmployee()")
		                    .addEntity(EmployeeBean.class);
					listOfCUGNo = query.list();
					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					e.printStackTrace();
				} finally {
					session.close();
				}
				return listOfCUGNo;
			}

}
