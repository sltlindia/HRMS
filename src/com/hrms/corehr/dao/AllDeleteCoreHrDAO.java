package com.hrms.corehr.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.recruitement.bean.CompanyListBean;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.pms.util.HibernateUtil;

public class AllDeleteCoreHrDAO {

	
	
	public boolean companyDelete(int company_list_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 CompanyListBean companyListBean = new CompanyListBean();
			 companyListBean.setCompany_list_id(company_list_id);
			 session.delete(companyListBean);
			 tx.commit();
			 result = true;
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return result;
	}	
	public boolean roleDelete(int role_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 RoleBean roleBean = new RoleBean();
			 roleBean.setRole_id(role_id);
			 session.delete(roleBean);
			 tx.commit();
			 result = true;
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return result;
	}	
	public boolean managerDelete(int manager_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 ManagerBean managerBean = new ManagerBean();
			 managerBean.setManager_id(manager_id);
			 session.delete(managerBean);
			 tx.commit();
			 result = true;
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return result;
	}
	public boolean departmentDelete(int department_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 DepartmentBean departmentBean = new DepartmentBean();
			 departmentBean.setDepartment_id(department_id);
			 session.delete(departmentBean);
			 tx.commit();
			 result = true;
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return result;
	}
}
