package com.hrms.incentive.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.ClassificationBean;
import com.hrms.incentive.bean.IncentiveDesignationBean;
import com.hrms.incentive.bean.LaserMasterBean;
import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.lms.util.HibernateUtil;

public class IncentiveAjaxDataDAO {
	
	
	public List<SalespersonBean> getnameOfsalesPerson()
	{
	    List<SalespersonBean> listOfSales = new ArrayList<SalespersonBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from SalespersonBean";
			 Query query = session.createQuery(hql);
			 listOfSales = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSales;

	}	

	public List<ProductMasterBean> getnameOfproduct()
	{
	    List<ProductMasterBean> listOfproduct = new ArrayList<ProductMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProductMasterBean";
			 Query query = session.createQuery(hql);
			 listOfproduct = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfproduct;

	}
	
	
	
	public List<ClassificationBean> getnameOfclassification()
	{
	    List<ClassificationBean> listOfclassification = new ArrayList<ClassificationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ClassificationBean";
			 Query query = session.createQuery(hql);
			 listOfclassification = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfclassification;

	}
	
	
	public List<LaserMasterBean> getListOfLaser()
	{
	    List<LaserMasterBean> listOfLaser = new ArrayList<LaserMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from LaserMasterBean";
			 Query query = session.createQuery(hql);
			 listOfLaser = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfLaser;

	}
	
	
	public List<SalespersonBean> getnameOfsalesPersonByYearnadMonth(int year, int month)
	{
	    List<SalespersonBean> listOfSales = new ArrayList<SalespersonBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from SalespersonBean s where exists(from TargetBean t where s.sales_person_id = t.salespersonBean and t.monthBean = '"+month+"' and t.yearBean.year = '"+year+"')";
			 Query query = session.createQuery(hql);
			 listOfSales = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSales;

	}	
	
	
	
	public List<ProductMasterBean> getnameOfproductByMonthYearId(int sales_id,int month,int year)
	{
	    List<ProductMasterBean> listOfproduct = new ArrayList<ProductMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = "from ProductMasterBean p where exists(from TargetBean t where p.product_master_id = t.productMasterBean and t.salespersonBean = '"+sales_id+"' and t.monthBean = '"+month+"' and t.yearBean.year = '"+year+"')";
			 Query query = session.createQuery(hql);
			 listOfproduct = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfproduct;

	}
	
	
	public List<SalespersonBean> getnameOfPersonByDesignation(String designation)
	{
	    List<SalespersonBean> listOfSalaesPerson = new ArrayList<SalespersonBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = null;
	        if(designation.equalsIgnoreCase("SE/SSE")){
	        	 hql = "from SalespersonBean p where designation = 'ASM'";
	        }else if(designation.equalsIgnoreCase("ASM") || designation.equalsIgnoreCase("RSM")){
	        	 hql = "from SalespersonBean p where designation = 'ZSM'";
	        }else if(designation.equalsIgnoreCase("AM")){
	        	 hql = "from SalespersonBean p where designation = 'RSM'";
	        }
			 Query query = session.createQuery(hql);
			 listOfSalaesPerson = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSalaesPerson;

	}
	
	
	
	public List<SalespersonBean> getDesignationOfPersonById(int sales_id)
	{
	    List<SalespersonBean> listOfSalaesPerson = new ArrayList<SalespersonBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        String hql = null;
	        	 hql = "from SalespersonBean p where sales_person_id = '"+sales_id+"'";
			 Query query = session.createQuery(hql);
			 listOfSalaesPerson = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSalaesPerson;

	}
	
	
	
	public List<IncentiveDesignationBean> getnameOfDesignation() {
		List<IncentiveDesignationBean> listOfSales = new ArrayList<IncentiveDesignationBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			String hql = "from IncentiveDesignationBean";
			Query query = session.createQuery(hql);
			listOfSales = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfSales;

	}
	
	
}
