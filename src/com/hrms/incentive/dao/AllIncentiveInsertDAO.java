package com.hrms.incentive.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.AksharNewHistoryBean;
import com.hrms.incentive.bean.AksharRepeatHistoryBean;
import com.hrms.incentive.bean.AmountHistoryBean;
import com.hrms.incentive.bean.BrahmastraNewHistoryBean;
import com.hrms.incentive.bean.BrahmastraRepeatBean;
import com.hrms.incentive.bean.BrahmastraRepeatHistoryBean;
import com.hrms.incentive.bean.ClassificationBean;
import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.incentive.bean.IncentiveCriteriaBean;
import com.hrms.incentive.bean.IncentiveCriteriaHistoryBean;
import com.hrms.incentive.bean.IncentiveSalesPersonListBean;
import com.hrms.incentive.bean.LaserMasterBean;
import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.incentive.bean.TargetBean;
import com.hrms.pms.util.HibernateUtil;

public class AllIncentiveInsertDAO {

	public boolean incentiveInsert(IncentiveBean incentiveBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(incentiveBean);
			 tx.commit();
			
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
	
	
	
	public boolean targetInsert(TargetBean targetBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(targetBean);
			 tx.commit();
			
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
	
	public boolean salesPersonInsert(SalespersonBean salespersonBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(salespersonBean);
			 tx.commit();
			
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
	
	public boolean productMasterInsert(ProductMasterBean productMasterBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(productMasterBean);
			 tx.commit();
			
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
	
	public boolean classificationMasterInsert(ClassificationBean classificationBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(classificationBean);
			 tx.commit();
			
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
	
	public boolean amountInsert(AmountHistoryBean amountHistoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(amountHistoryBean);
			 tx.commit();
			
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
	
	
	
	public boolean akshrNewHistoryInsert(AksharNewHistoryBean aksharNewHistoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(aksharNewHistoryBean);
			 tx.commit();
			
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
	
	
	public boolean akshrRepeatHistoryInsert(AksharRepeatHistoryBean aksharRepeatHistoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(aksharRepeatHistoryBean);
			 tx.commit();
			
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
	
	
	public boolean brahmashtraRepeatHistoryInsert(BrahmastraRepeatHistoryBean brahmastraRepeatHistoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(brahmastraRepeatHistoryBean);
			 tx.commit();
			
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
	
	
	public boolean brahmashtraNewHistoryInsert(BrahmastraNewHistoryBean brahmastraNewHistoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(brahmastraNewHistoryBean);
			 tx.commit();
			
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
	
	
	
	public boolean incentiveCriteriaHistoryInsert(IncentiveCriteriaHistoryBean incentiveCriteriaHistoryBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(incentiveCriteriaHistoryBean);
			 tx.commit();
			
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
	
	
	public boolean incentiveLaserSourceInsert(LaserMasterBean laserMasterBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(laserMasterBean);
			 tx.commit();
			
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
	
	
	public boolean incentiveSalesPersonInsert(IncentiveSalesPersonListBean incentiveSalesPersonListBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 int id = 0;
		 boolean result = false;
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(incentiveSalesPersonListBean);
			 tx.commit();
			
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
