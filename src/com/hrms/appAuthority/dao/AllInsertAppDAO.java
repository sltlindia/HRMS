package com.hrms.appAuthority.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.appAuthority.bean.AppAuthorityBean;
import com.hrms.appAuthority.bean.UserBean;
import com.hrms.appAuthority.util.HibernateUtilRMIHL;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.recruitement.util.HibernateUtil;

public class AllInsertAppDAO {

	public boolean appAuthority(AppAuthorityBean appAuthorityBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(appAuthorityBean);
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
	
	
	
	public boolean userInsert(UserBean userBean){
		 Session session = HibernateUtilRMIHL.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(userBean);
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
