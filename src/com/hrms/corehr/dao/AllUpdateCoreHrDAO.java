package com.hrms.corehr.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.RoleBean;
import com.hrms.recruitement.util.HibernateUtil;

public class AllUpdateCoreHrDAO {
	
	
	public boolean companyUpdate(String company_name,String company_code,int company_list_id) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update CompanyListBean set company_name = :cn,company_code = :cc where company_list_id = :cli");
			 query.setString("cn", company_name);
			 query.setString("cc", company_code);
			 query.setInteger("cli", company_list_id);
			
			 
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
	public boolean roleUpdate(String role_type,String role_authority,int role_id) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update RoleBean set role_type = :rt,role_authority = :ra where role_id = :ri");
			 query.setString("rt", role_type);
			 query.setString("ra", role_authority);
			 query.setInteger("ri", role_id);
			
			 
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
	public boolean departmentUpdate(String department_name,int department_id) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update DepartmentBean set department_name = :dn where department_id = :di");
			 query.setString("dn", department_name);
			 query.setInteger("di", department_id);
			
			 
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
	public boolean managerUpdate(String manager_name,int manager_id,int employee_code) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ManagerBean set manager_name = :mn, emp_code =:ec where manager_id = :mi");
			 query.setString("mn", manager_name);
			 query.setInteger("ec", employee_code);
			 query.setInteger("mi", manager_id);
			
			 
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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
	
	public boolean subDepartmentUpdate(String sub_department_name,int sub_department_id) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update SubDepartmentBean set sub_department_name = :dn where sub_department_id = :di");
			 query.setString("dn", sub_department_name);
			 query.setInteger("di", sub_department_id);
			
			 
			 int result = query.executeUpdate();
			 System.out.println("result :"+result);
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

}
