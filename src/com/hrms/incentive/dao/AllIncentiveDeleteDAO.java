package com.hrms.incentive.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.TargetBean;
import com.hrms.pms.util.HibernateUtil;

public class AllIncentiveDeleteDAO {

	
	public boolean incentiveSalesPersonId(int id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete IncentiveSalesPersonListBean where incentive_sales_person_list_id = :ispli");
			 query.setInteger("ispli",id);
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
	
	
	
	public boolean incentiveAmountDelete(int id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete AmountHistoryBean where amount_history_id = :ahi");
			 query.setInteger("ahi",id);
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
	
	
	public boolean incentiveSalesTargetId(int id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete TargetBean where sales_target_id = :sti");
			 query.setInteger("sti",id);
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
