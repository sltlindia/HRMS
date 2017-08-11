package com.hrms.incentive.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.incentive.bean.AksharNewBean;
import com.hrms.incentive.bean.AksharRepeatBean;
import com.hrms.incentive.bean.BrahmastraNewBean;
import com.hrms.incentive.bean.BrahmastraRepeatBean;
import com.hrms.incentive.bean.ClassificationBean;
import com.hrms.incentive.bean.IncentiveBean;
import com.hrms.incentive.bean.IncentiveCriteriaBean;
import com.hrms.incentive.bean.IncentiveSalesPersonListBean;
import com.hrms.incentive.bean.LaserMasterBean;
import com.hrms.incentive.bean.ProductMasterBean;
import com.hrms.incentive.bean.SalespersonBean;
import com.hrms.incentive.bean.TargetBean;
import com.hrms.pms.bean.WorkGradeBean;
import com.hrms.pms.util.HibernateUtil;

public class AllIncentiveUpdateDAO {
	
	public boolean salesTrgetUpdate(TargetBean targetBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(targetBean);
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
	
	
	public boolean aksharNewUpdate(AksharNewBean aksharNewBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(aksharNewBean);
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
	
	
	public boolean aksharRepeatUpdate(AksharRepeatBean aksharRepeatBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(aksharRepeatBean);
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
	
	
	
	public boolean brahmastraNewUpdate(BrahmastraNewBean brahmastraNewBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(brahmastraNewBean);
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
	
	
	
	public boolean brahmastraRepeatUpdate(BrahmastraRepeatBean brahmastraRepeatBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(brahmastraRepeatBean);
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
	
	public boolean productUpdate(ProductMasterBean productMasterBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(productMasterBean);
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

	
	public boolean salesUpdate(SalespersonBean salespersonBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(salespersonBean);
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


	public boolean laserUpdate(LaserMasterBean laserMasterBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(laserMasterBean);
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

	public boolean classUpdate(ClassificationBean classificationBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(classificationBean);
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
	
	public boolean incentiveCriteriaUpdate(IncentiveCriteriaBean incentiveCriteriaBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(incentiveCriteriaBean);
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
	
	public boolean incentiveStatusUpdate(int incentive_id,String value){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update IncentiveBean set incentive_status = :is  where incentive_id= :id");
			 query.setString("is",value);
			 query.setInteger("id", incentive_id);
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
	
	//Incentive Slabvalue and Incentive Amount Recount update
	public boolean incentiveSlabValueUpdate(int incentive_id,double slabValue, double amount){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update IncentiveBean set slab = :s,amount = :a  where incentive_id= :id");
			 query.setDouble("s",slabValue);
			 query.setDouble("a", amount);
			 query.setInteger("id", incentive_id);
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
	
	//Incentive All Data update
	public boolean incentiveUpdate(IncentiveBean incentiveBean){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(incentiveBean);
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
	
	
	
		//Incentive list person update
		public boolean incentiveListSaPersonUpdate(IncentiveSalesPersonListBean incentiveSalesPersonListBean){
			Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.update(incentiveSalesPersonListBean);
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
	
		//Incentive Pecentage and Incentive Status update
		public boolean incentiveEligibleStatusUpdate(int incentive_id,double percentage){
			Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("update IncentiveBean set eligible_incentive_percentage = :eip,eligible_insentive_save = :eis  where incentive_id= :id");
				 query.setDouble("eip",percentage);
				 query.setString("eis", "yes");
				 query.setInteger("id", incentive_id);
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
