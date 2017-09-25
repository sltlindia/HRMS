package com.hrms.vehicletracking.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;
import com.hrms.selfservice.bean.MarqueeBean;
import com.hrms.vehicletracking.bean.VehicleServiceRecordBean;
import com.hrms.vehicletracking.bean.VehicleTrackingBean;

public class AllDeleteVtsDAO {
	
	public boolean vehicleTrackingDelete(int vehicle_tracking_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 VehicleTrackingBean vehicleTrackingBean = new VehicleTrackingBean();
			 vehicleTrackingBean.setVehicle_tracking_id(vehicle_tracking_id);
			 session.delete(vehicleTrackingBean);
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
	
	public boolean vehicleServiceRecordDelete(int vehicle_service_record_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 VehicleServiceRecordBean vehicleServiceRecordBean = new VehicleServiceRecordBean();
			 vehicleServiceRecordBean.setVehicle_service_record_id(vehicle_service_record_id);
			 session.delete(vehicleServiceRecordBean);
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
