package com.hrms.kaizen.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.kaizen.bean.KaizenManagementApprovalBean;
import com.hrms.pms.util.HibernateUtil;

public class AllKaizenUpdateDAO{
	
	
	//Kaizen approval
		public boolean kaizenApproval(int kaizen_id,String status, String reason, int employee_id){
			Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("update KaizenManagerBean set status = :s,rejection_reason = :a  where kaizenBean= :k and employeeBean = :e");
				 query.setString("s",status);
				 query.setString("a", reason);
				 query.setInteger("k", kaizen_id);
				 query.setInteger("e", employee_id);
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
	
		
		//Kaizen approval
				public boolean kaizenMainApproval(int kaizen_id,String status, String reason){
					Session session = HibernateUtil.openSession();
					 Transaction tx = null;	
					 try {
						 tx = session.getTransaction();
						 tx.begin();
						 Query query = session.createQuery("update KaizenBean set status = :s, rejection_reason = :rr   where kaizen_id= :k");
						 query.setString("s","Genuine");
						 query.setString("rr",reason);
						 query.setInteger("k", kaizen_id);
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
				
				
				
				//Kaizen approval
				public boolean kaizenMainApprovalRejetcion(int kaizen_id,String status){
					Session session = HibernateUtil.openSession();
					 Transaction tx = null;	
					 try {
						 tx = session.getTransaction();
						 tx.begin();
						 Query query = session.createQuery("update KaizenBean set status = :s where kaizen_id= :k");
						 query.setString("s",status);
						 query.setInteger("k", kaizen_id);
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
				
				
				
				//Kaizen Desc update
				public boolean kaizenDescUpdate(int kaizen_id,String desc, String desc_name){
					Session session = HibernateUtil.openSession();
					 Transaction tx = null;	
					 try {
						 tx = session.getTransaction();
						 tx.begin();
						 Query query = session.createQuery("update KaizenBean set "+desc_name+" = :d where kaizen_id= :k ");
						 query.setString("d",desc);
						 query.setInteger("k", kaizen_id);
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
				
				
				
				//Kaizen management approval
				public boolean kaizenManagemnetApproval(int kaizen_id,String status, String reason){
					Session session = HibernateUtil.openSession();
					 Transaction tx = null;	
					 
					 
					 
					 try {
						 tx = session.getTransaction();
						 tx.begin();
						 Query query = session.createQuery("update KaizenManagementApprovalBean set management_approval_status = :s, management_rejection_reason = :rr  where kaizen_id= :k");
						 query.setString("s",status);
						 query.setString("rr",reason);
						 query.setInteger("k", kaizen_id);
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
				
				
				//Kaizen completion_status Status update
				public boolean kaizenStatusUpdate(int kaizen_id,String status){
					Session session = HibernateUtil.openSession();
					 Transaction tx = null;	
					 try {
						 tx = session.getTransaction();
						 tx.begin();
						 Query query = session.createQuery("update KaizenBean set completion_status = :cs where kaizen_id= :k ");
						 query.setString("cs",status);
						 query.setInteger("k", kaizen_id);
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
				
				
				//Kaizen completion Status update with date
				public boolean kaizenStatusUpdateWithTime(int kaizen_id,String status,String date){
					Session session = HibernateUtil.openSession();
					 Transaction tx = null;	
					 try {
						 tx = session.getTransaction();
						 tx.begin();
						 Query query = session.createQuery("update KaizenBean set completion_status = :cs,completion_date = :cd  where kaizen_id= :k ");
						 query.setString("cs",status);
						 query.setString("cd",date);
						 query.setInteger("k", kaizen_id);
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
