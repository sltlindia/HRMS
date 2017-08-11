package com.hrms.timesheet.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.util.HibernateUtil;

public class TimeSheetDAO {

		public boolean vacancyInsert(TimeSheetBean timeSheetBean){
			 Session session = HibernateUtil.openSession();
//			int id =0;
//			int review_id;
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.saveOrUpdate(timeSheetBean);
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



