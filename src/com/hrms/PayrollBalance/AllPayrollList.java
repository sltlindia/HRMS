package com.hrms.PayrollBalance;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.util.HibernateUtil;

public class AllPayrollList
{

	public List<EmployeeBean> getListOfEmployee(int employee_code , int companyid) {
		List<EmployeeBean> listOfEmployee = new ArrayList<EmployeeBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM EmployeeBean WHERE employee_code = '" + employee_code + "' AND companyListBean = '" + companyid+ "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployee;

	}
	
	
	
	public boolean Payrollbalanceinsert(PayrolldatainsertBean payrolldatainsertBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(payrolldatainsertBean);
			 System.out.println("inserted");
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
	
	
	public List<PayrolldatainsertBean> getListOfpayrollbalance(int employeemasterid) {
		List<PayrolldatainsertBean> listOfEmployee = new ArrayList<PayrolldatainsertBean>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			listOfEmployee = session.createQuery("FROM PayrolldatainsertBean WHERE employee_master_id = '" + employeemasterid + "'").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listOfEmployee;

	}
}
