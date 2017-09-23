package com.hrms.vehicletracking.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;
import com.hrms.vehicletracking.bean.VehicleBean;
import com.hrms.vehicletracking.bean.VehicleServiceRecordBean;
import com.hrms.vehicletracking.bean.VehicleTrackingBean;

public class AllInsertVtsDAO implements Serializable {

	public boolean vehicleInsert(VehicleBean vehicleBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(vehicleBean);
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
	
	public boolean vehicleTrackingInsert(VehicleTrackingBean vehicleTrackingBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(vehicleTrackingBean);
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
	
	public boolean vehicleServiceRecordInsert(VehicleServiceRecordBean vehicleServiceRecordBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(vehicleServiceRecordBean);
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
