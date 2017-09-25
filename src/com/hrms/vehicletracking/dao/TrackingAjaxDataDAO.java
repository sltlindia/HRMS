package com.hrms.vehicletracking.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.timesheet.util.HibernateUtil;

public class TrackingAjaxDataDAO {
	
	
	public double getMaxReading(int vehicle_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		double maxvalue = 0;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("select max(end_reading) from VehicleTrackingBean where vehicleBean = '"+vehicle_id+"'");
			maxvalue = (Double) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return maxvalue;
	}
	

}
