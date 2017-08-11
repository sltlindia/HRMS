package com.hrms.grievancemanagement.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;

public class AllUpdateGrievanceDAO {

	
	public boolean grievanceQueryUpdate(int grievance_id,String reply,String date,String attachment,String status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update GrievanceQueryBean set date_of_resolve = :dor ,reply = :r,reply_attachment = :ra,status = :s where grievance_query_id = :gqi ");
			 query.setString("dor", date);
			 query.setString("r", reply);
			 query.setString("s", status);
			 query.setString("ra", attachment);
			 query.setInteger("gqi", grievance_id);
			 
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
	
	public boolean grievanceQueryTypeUpdate(int grievance_type_id,String query_type){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update GrievanceQueryTypeBean set grievance_query_type = :g where grievance_query_type_id = :gqti ");
			 query.setString("g", query_type);
			 query.setInteger("gqti", grievance_type_id);
			
			 
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
	
	public boolean grievanceQueryUpdateShowView(int query_id,int show_view){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update GrievanceQueryBean set show_view = :sv where grievance_query_id = :gqi ");
			 query.setInteger("sv", show_view);
			 query.setInteger("gqi", query_id);
			 
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
	
	
	public boolean grievanceQueryEscalation(int emp_id, int grievance_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update GrievanceQueryBean set escalation_id = :sv where grievance_query_id = :gqi ");
			 query.setInteger("sv", emp_id);
			 query.setInteger("gqi", grievance_id);
			 
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
