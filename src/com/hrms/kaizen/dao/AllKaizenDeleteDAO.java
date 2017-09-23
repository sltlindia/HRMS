package com.hrms.kaizen.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.kaizen.bean.KaizenManagerBean;
import com.hrms.kaizen.bean.KaizenMemberBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.util.HibernateUtil;

public class AllKaizenDeleteDAO {
	
	
	public boolean kaizenManagerDelete(int kaizen_manager_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 KaizenManagerBean kaizenManagerBean = new KaizenManagerBean(); 
			 kaizenManagerBean.setKaizen_manager_id(kaizen_manager_id);
			 session.delete(kaizenManagerBean);
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
	
	
	
	
	public boolean kaizenMemberDelete(int kaizen_member_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 KaizenMemberBean kaizenMemberBean = new KaizenMemberBean(); 
			 kaizenMemberBean.setKaizen_member_id(kaizen_member_id);
			 session.delete(kaizenMemberBean);
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
	
	
	public boolean kaizenManagemnetDelete(int kaizen_managemnet_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 KaizenManagementApprovalBean kaizenManagementApprovalBean = new KaizenManagementApprovalBean(); 
			 kaizenManagementApprovalBean.setKaizen_management_approval_id(kaizen_managemnet_id);
			 session.delete(kaizenManagementApprovalBean);
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
