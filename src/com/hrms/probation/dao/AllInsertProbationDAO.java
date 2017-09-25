package com.hrms.probation.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;
import com.hrms.probation.bean.ProbationAssessmentM1Bean;
import com.hrms.probation.bean.ProbationAssessmentM2Bean;
import com.hrms.probation.bean.ProbationAssessmentManagerBean;
import com.hrms.probation.bean.ProbationAssessmentTerminationBean;
import com.hrms.probation.bean.ProbationExtendBean;
import com.hrms.probation.bean.ProbationTopManagementApprovalBean;

public class AllInsertProbationDAO {

	//Author Name :- Ripal Soni
	//For Inserting Data into Tables(All Insert Methods)
	
	//Insert method for insertion of probation M1(Direct) score using probationAssessmentM1Bean into probation_assessment_direct_tbl
	//Insertion Using ProbationAssessmentM1Bean
	//Return probationAssessmentM1Bean
	public boolean probationm1ScoreInsert(ProbationAssessmentM1Bean probationAssessmentM1Bean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(probationAssessmentM1Bean);
			 id = probationAssessmentM1Bean.getProbation_assessment_m1_id();
			 probationAssessmentM1Bean.setProbation_assessment_m1_id(id);
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

	//Insert method for insertion of probation M2(Indirect) score using probationAssessmentM2Bean into probation_assessment_indirect_tbl
	//Insertion Using ProbationAssessmentM2Bean
	//Return ProbationAssessmentM2Bean
	public boolean probationm2ScoreInsert(ProbationAssessmentM2Bean probationAssessmentM2Bean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(probationAssessmentM2Bean);
			 id = probationAssessmentM2Bean.getProbation_assessment_m2_id();
			 probationAssessmentM2Bean.setProbation_assessment_m2_id(id);
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
	
	//Insert method for insertion of probation assessment manager approval,hr approval,top management approval using ProbationAssessmentManagerBean into probation_assessment_manager_tbl
		//Insertion Using ProbationAssessmentManagerBean
	//Return probationAssessmentManagerBean
	public boolean probationManagerReviewInsert(ProbationAssessmentManagerBean probationAssessmentManagerBean){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(probationAssessmentManagerBean);
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
	
	//Insert method for insertion of probation extended period using ProbationExtendBean into probation_extend_tbl
	//Insertion Using ProbationExtendBean
	//Return ProbationExtendBean
	public boolean probationManagerExtendedInsertIndirect(ProbationExtendBean probationExtendBean){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(probationExtendBean);
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
	
	//Insert method for insertion of top management approval send by Hr manager using ProbationTopManagementApprovalBean into probation_topmanagement_approval_tbl
	//Insertion Using ProbationTopManagementApprovalBean
	//Return ProbationTopManagementApprovalBean
	public boolean probationTopManagementInsertIndirect(ProbationTopManagementApprovalBean probationTopManagementApprovalBean){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(probationTopManagementApprovalBean);
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
	
	//Insert method for insertion of manager approval using ProbationAssessmentTerminationBean into probation_assessment_termination_tbl
		//Insertion Using ProbationAssessmentTerminationBean
		//Return ProbationAssessmentTerminationBean
	public boolean terminationInsert(ProbationAssessmentTerminationBean probationAssessmentTerminationBean){
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(probationAssessmentTerminationBean);
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
