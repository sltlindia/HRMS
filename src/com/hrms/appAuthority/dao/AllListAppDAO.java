package com.hrms.appAuthority.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.appAuthority.bean.AppAuthorityBean;
import com.hrms.appAuthority.bean.UserBean;
import com.hrms.appAuthority.util.HibernateUtilRMIHL;
import com.hrms.assetmanagement.bean.StockMasterBean;
import com.hrms.lms.bean.LeaveTypeBean;
import com.hrms.pms.util.HibernateUtil;

public class AllListAppDAO {

	public AppAuthorityBean checkAuthority(int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AppAuthorityBean appAuthorityBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("FROM AppAuthorityBean where employeeBean = '"+emp_id+"'");
		    appAuthorityBean = (AppAuthorityBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return appAuthorityBean;
		}
	
	
	
	
	public UserBean checkData(int emp_id) {
		Session session = HibernateUtilRMIHL.openSession();
		Transaction tx = null;
		UserBean userBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("FROM UserBean where emp_id = '"+emp_id+"'");
		    userBean = (UserBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return userBean;
		}
	
	
	public List<AppAuthorityBean> getAllListOfGateAuthority()
	{
        List<AppAuthorityBean> listOfData = new ArrayList<AppAuthorityBean>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            listOfData = session.createQuery("FROM AppAuthorityBean where gate_inword_auth = 1").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOfData;
        
	}
	
	
	
	public AppAuthorityBean checkAuthorityByEmpID(int emp_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AppAuthorityBean appAuthorityBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("FROM AppAuthorityBean where employeeBean = '"+emp_id+"' and gate_inword_auth = 1");
		    appAuthorityBean = (AppAuthorityBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return appAuthorityBean;
		}

	
	
}
