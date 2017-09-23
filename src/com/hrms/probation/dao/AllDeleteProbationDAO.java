package com.hrms.probation.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;

public class AllDeleteProbationDAO {
	
	//Author Name :- Ripal Soni
	//For Deleting Data From Table(All Delete Methods)
	
	//Delete method for deleting extended period using probation_assessment_manager_id into probation_extend_tbl
	//Deleting extended period which status is pending
	public boolean deleteExtendedPeriod(int probation_assessment_manager_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete ProbationExtendBean where probation_assessment_manager_id = :pami and status = 'pending'");
			 query.setInteger("pami",probation_assessment_manager_id);
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

	//Delete method for deleting termination using probation_assessment_termination_id into probation_assessment_termination_tbl
		public boolean deleteTerminationPeriod(int probation_assessment_termination_id)
		{
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 
			 
			 try {
				
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("delete ProbationAssessmentTerminationBean where probation_assessment_termination_id = :ptmi");
				 query.setInteger("ptmi",probation_assessment_termination_id);
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
