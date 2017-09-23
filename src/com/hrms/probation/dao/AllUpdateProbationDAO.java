package com.hrms.probation.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;


//Author Name :- Ripal Soni
//For Updating Data From Table(All Update Methods)


public class AllUpdateProbationDAO {
	//Update method for update of probation hr approval using ProbationAssessmentManagerBean into probation_assessment_manager_tbl
		//Updation Using ProbationAssessmentManagerBean by particular employee_id
		//Return ProbationAssessmentManagerBean
	public boolean updateApproval(String hr_approval,String hr_approval_rejection_remarks,int employee_master_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentManagerBean set hr_approval = :ha ,hr_rejection_remarks = :har where employee_master_id = :emi");
			 query.setString("ha", hr_approval);
			 query.setString("har", hr_approval_rejection_remarks);
			 query.setInteger("emi", employee_master_id);
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
	//Update method for update of probation manager approval using ProbationAssessmentManagerBean into probation_assessment_manager_tbl
	//Updation Using ProbationAssessmentManagerBean by particular employee_id
	//Return ProbationAssessmentManagerBean
	public boolean updateManagerApproval(String manager_approval,String manager_approval_rejection_remarks,int employee_master_id,String manager_suggestion){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentManagerBean set manager_approval = :pa ,manager_rejection_remarks = :par,manager_suggestion = :ms where employee_master_id = :emi");
			 query.setString("pa", manager_approval);
			 query.setString("par", manager_approval_rejection_remarks);
			 query.setString("ms", manager_suggestion);
			 query.setInteger("emi", employee_master_id);
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
	//Update method for update of probation top management approval using ProbationAssessmentManagerBean into probation_assessment_manager_tbl
		//Updation Using ProbationAssessmentManagerBean by particular employee_id
		//Return ProbationAssessmentManagerBean
	public boolean updateTopApproval(String top_management_approval,String top_management_rejection_remarks,int employee_master_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentManagerBean set top_management_approval = :tma ,top_management_rejection_remarks = :tmra where employee_master_id = :emi");
			 query.setString("tma", top_management_approval);
			 query.setString("tmra", top_management_rejection_remarks);
			 query.setInteger("emi", employee_master_id);
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
	//Update method for update of probation top management approval using ProbationAssessmentManagerBean into probation_assessment_manager_tbl
			//Updation Using ProbationAssessmentManagerBean by particular employee_id
			//Return ProbationAssessmentManagerBean
	public boolean updateTopApprovalByHR(String top_management_approval,int employee_master_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentManagerBean set top_management_approval = :tma where employee_master_id = :emi");
			 query.setString("tma", top_management_approval);
			 query.setInteger("emi", employee_master_id);
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
	//Update method for update of probation extend period using ProbationExtendBean into probation_extend_tbl for updating status
	//Updation Using ProbationExtendBean by particular probation_assessment_manager_id
	//Return ProbationExtendBean
	public boolean updateExtendedStatus(String status,int probation_assessment_manager_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationExtendBean set status = :sta where probation_assessment_manager_id= :psmi");
			 query.setString("sta", status);
			 query.setInteger("psmi", probation_assessment_manager_id);
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
	
	//Update method for update of probation extend period using ProbationExtendBean into probation_extend_tbl for updating status
		//Updation Using ProbationExtendBean by particular probation_assessment_manager_id
		//Return ProbationExtendBean
	public boolean update(int probation_assessment_manager_id,String to_be_confirmed,String to_be_terminated,String to_be_extended,String remarks,String period_to_be_extended,String manager_approval,String manager_rejection_remarks,String hr_approval,String hr_rejection_remarks,String top_management_approval,String top_management_rejection_remarks,String reporting_manager_approval){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentManagerBean set to_be_confirmed = :tbc,to_be_terminated = :tbt,to_be_extended = :tbe,remarks = :re,period_to_be_extended = :ptbe,manager_approval = :ma,manager_rejection_remarks = :mrr,hr_approval = :ha,hr_rejection_remarks = :hrr,top_management_approval = :tma,top_management_rejection_remarks = :tmrr,reporting_manager_approval = :rpa where probation_assessment_manager_id = :pami");
			 query.setString("tbc", to_be_confirmed);
			 query.setString("tbt", to_be_terminated);
			 query.setString("tbe", to_be_extended);
			 query.setString("re", remarks);
			 query.setString("ptbe", period_to_be_extended);
			 query.setString("ma", manager_approval);
			 query.setString("mrr", manager_rejection_remarks);
			 query.setString("ha", hr_approval);
			 query.setString("hrr", hr_rejection_remarks);
			 query.setString("tma", top_management_approval);
			 query.setString("tmrr", top_management_rejection_remarks);
			 query.setInteger("pami", probation_assessment_manager_id);
			 query.setString("rpa", reporting_manager_approval);
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
	
	//Update method ProbationAssessmentManagerBean into probation_assessment_manager_tbl
	//Updation Using ProbationAssessmentManagerBean
	//Return ProbationAssessmentManagerBean
	public boolean updateAfterExtend(int employee_master_id,String manager_approval,String manager_rejection_remarks,String hr_approval,String hr_rejection_remarks,String top_management_approval,String top_management_rejection_remarks,String reporting_manager_approval){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentManagerBean set manager_approval = :ma,manager_rejection_remarks = :mrr,hr_approval = :ha,hr_rejection_remarks = :hrr,top_management_approval = :tma,top_management_rejection_remarks = :tmrr,reporting_manager_approval = :rma,reporting_manager_approval = :rma where employee_master_id = :emi");
			 query.setString("ma", manager_approval);
			 query.setString("mrr", manager_rejection_remarks);
			 query.setString("ha", hr_approval);
			 query.setString("hrr", hr_rejection_remarks);
			 query.setString("tma", top_management_approval);
			 query.setString("tmrr", top_management_rejection_remarks);
			 query.setInteger("emi", employee_master_id);
			 query.setString("rma", reporting_manager_approval);
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
	
	//Update method ProbationExtendBean into probation_extend_tbl
	//Updation Using ProbationExtendBean by particular probation_assessment_manager_id
	//Return ProbationExtendBean
	public boolean probationManagerExtendedUpdateIndirect(String extended_period,String status,int probation_assessment_manager_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationExtendBean set extended_period = :ep,status = :sta where probation_assessment_manager_id = :pami");
			 query.setString("ep", extended_period);
			 query.setString("sta", status);
			 query.setInteger("pami", probation_assessment_manager_id);
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
	//Update method ProbationAssessmentM2Bean into probation_assessment_indirect_tbl
		//Updation Using ProbationAssessmentM2Bean by particular probation_assessment_m2_id
		//Return ProbationAssessmentM2Bean
	public boolean probationm2ScoreUpdateMonthWise(double month_score,int probation_assessment_m2_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentM2Bean set attribute_m2_score = :ams where probation_assessment_m2_id = :psmi");
			 query.setDouble("ams", month_score);
			 query.setInteger("psmi", probation_assessment_m2_id);
			 int result = query.executeUpdate();
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
	//Update method ProbationAssessmentM2Bean into probation_assessment_indirect_tbl
	//Updation Using ProbationAssessmentM2Bean by particular month_id
	//Return ProbationAssessmentM2Bean
	public boolean probationm2ScoreUpdate(String continue_for_next_month,String warning_letter,String termination_letter,int month_id,int year_id,String comments_month_wise){

		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentM2Bean set continue_for_next_month = :cfnm,warning_letter = :wl,termination_letter = :tl,comments_monthly = :cm where month_id = :mi and year_id = :yi");
			 query.setString("cfnm", continue_for_next_month);
			 query.setString("wl", warning_letter);
			 query.setString("tl", termination_letter);
			 query.setInteger("mi", month_id);
			 query.setInteger("yi", year_id);
			 query.setString("cm", comments_month_wise);
			 int result = query.executeUpdate();
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
	
	//Update method ProbationAssessmentM2Bean into probation_assessment_indirect_tbl
		//Updation Using ProbationAssessmentM2Bean by particular month_id
		//Return ProbationAssessmentM2Bean
		public boolean probationm2ScoreUpdateComment(int employee_master_id,String comments_month_wise){

			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("update ProbationAssessmentM2Bean set comments_monthly = :cfnm where employee_master_id = :emi and comments_monthly = null");
				 query.setString("cfnm", comments_month_wise);
				 query.setInteger("emi", employee_master_id);
				 int result = query.executeUpdate();
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
	//Update method ProbationAssessmentM2Bean into probation_assessment_indirect_tbl
	//Updation Using ProbationAssessmentM2Bean by particular probation_assessment_m2_id
	//Return ProbationAssessmentM2Bean
		public boolean probationm2ScoreUpdateByProbationId(String continue_for_next_month,String warning_letter,String termination_letter,int employee_master_id,int month_id,int year_id){
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("update ProbationAssessmentM2Bean set continue_for_next_month = :cfnm,warning_letter = :wl,termination_letter = :tl where employee_master_id = :emi and month_id = :mi and year_id = :yi");
				 query.setString("cfnm", continue_for_next_month);
				 query.setString("wl", warning_letter);
				 query.setString("tl", termination_letter);
				 query.setInteger("emi", employee_master_id);
				 query.setInteger("mi", month_id);
				 query.setInteger("yi", year_id);
				 int result = query.executeUpdate();
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
		
	//Update method ProbationTopManagementApprovalBean into probation_topmanagement_approval_tbl
	//Updation Using ProbationTopManagementApprovalBean by particular probation_assessment_manager_id where top_management_Approval = pending
	//Return ProbationTopManagementApprovalBean
	public boolean updateStatus(int probation_assessment_manager_id,String top_management_status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationTopManagementApprovalBean set top_management_status = :sta where probation_assessment_manager_id= :psmi and top_management_status = 'pending'");
			 query.setString("sta", top_management_status);
			 query.setInteger("psmi", probation_assessment_manager_id);
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
	
	//Update method ProbationTopManagementApprovalBean into probation_topmanagement_approval_tbl
	//Updation Using ProbationTopManagementApprovalBean by particular probation_assessment_manager_id where top_management_Approval = pending
	//Return ProbationTopManagementApprovalBean
	public boolean updateManagerStatus(int employee_master_id,String manager_status,String manager_rejection_remarks){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProbationAssessmentTerminationBean set manager_status = :sta,manager_rejection_remarks = :mrr where employeeBean= :emi and (manager_status='pending' or manager_status='hrPending')");
			 query.setString("sta", manager_status);
			 query.setString("mrr", manager_rejection_remarks);
			 query.setInteger("emi", employee_master_id);
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
	
	//Update method for update of probation extend period using ProbationExtendBean into probation_extend_tbl for updating status
	//Updation Using ProbationExtendBean by particular probation_assessment_manager_id
	//Return ProbationExtendBean
		public boolean updateManagerTermination(String status,int probation_assessment_termination_id){
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 Query query = session.createQuery("update ProbationAssessmentTerminationBean set manager_status = :sta where probation_assessment_termination_id= :psmi");
				 query.setString("sta", status);
				 query.setInteger("psmi", probation_assessment_termination_id);
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