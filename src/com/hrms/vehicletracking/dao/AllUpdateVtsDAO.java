package com.hrms.vehicletracking.dao;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;



public class AllUpdateVtsDAO {
			
	public boolean endReadingUpdate(int vt_id,double endReading,double km,double avg){
		 Session session = HibernateUtil.openSession();

		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update VehicleTrackingBean set end_reading = :er,km = :km,average = :avg where vehicle_tracking_id = :vti");
			 query.setInteger("vti", vt_id);
			 query.setDouble("er", endReading);
			 query.setDouble("km", km);
			 query.setDouble("avg", avg);

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
