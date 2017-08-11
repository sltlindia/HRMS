package com.hrms.pms.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.Appraisal5sBean;
import com.hrms.pms.bean.AppraisalCriteriaGradeBean;
import com.hrms.pms.bean.AppraisalKizenBean;
import com.hrms.pms.bean.AppraisalLeaveBean;
import com.hrms.pms.bean.AppraisalTrainingBean;
import com.hrms.pms.bean.AppraisalWhiteCollarGradeBean;
import com.hrms.pms.bean.AppraisalWhiteSection1Bean;
import com.hrms.pms.bean.CostFeasibilityBean;
import com.hrms.pms.bean.EngineeringFeasibilityBean;
import com.hrms.pms.bean.FamilyDetailBean;
import com.hrms.pms.bean.FixtureFeasibiltyBean;
import com.hrms.pms.bean.ManagerGradeMasterBean;
import com.hrms.pms.bean.ManufacturingFeasibilityBean;
import com.hrms.pms.bean.MonthlyGoalDetailBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectDesignHeadBean;
import com.hrms.pms.bean.ProjectDesignInputsBean;
import com.hrms.pms.bean.ProjectHoldHistoryBean;
import com.hrms.pms.bean.QualityFeasibilityBean;
import com.hrms.pms.bean.ReviewBean;
import com.hrms.pms.bean.ReviewCriteriaBean;
import com.hrms.pms.bean.ReviewSoftskillBean;
import com.hrms.pms.bean.SoftskillBean;
import com.hrms.pms.bean.TechnicalBean;
import com.hrms.pms.bean.WorkGradeBean;
import com.hrms.pms.util.HibernateUtil;

public class AllUpdateDAO {
	
	
	public boolean reviewManagerTechUpdate(int manager_techgrade_id,int review_criteria_id,String manager_techcomment,String technicalProof){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewCriteriaBean set managerGradeMasterBean = :mg ,comment_manager = :cm ,manager_tech_attachment = :mta where review_criteria_id = :rc ");
			 query.setInteger("mg", manager_techgrade_id);
			 query.setString("cm", manager_techcomment);
			 query.setString("mta", technicalProof);
			 query.setInteger("rc", review_criteria_id);
			 
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
	
	
	public boolean reviewManagerTechIDUpdate(int manager_techgrade_id,int review_id,String manager_techcomment,String technicalProof){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewCriteriaBean set managerGradeMasterBean = :mg ,comment_manager = :cm ,manager_tech_attachment = :mta where review_id = :rd ");
			 query.setInteger("mg", manager_techgrade_id);
			 query.setString("cm", manager_techcomment);
			 query.setString("mta", technicalProof);
			 query.setInteger("rd", review_id);
			 
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
	
	

	public boolean reviewManagerSoftUpdate(int manager_softgrade_id,int review_softskill_id,String manager_softcomment,int review_id,String softskillProof){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewSoftskillBean set managerGradeMasterBean = :mg ,comment_manager = :cm ,manager_soft_attachment = :msa where review_softskill_id = :rs ");
			 Query query2 = session.createQuery("update ReviewBean set approve_status = :as where review_id= :rd");
			 query.setInteger("mg", manager_softgrade_id);
			 query.setString("cm", manager_softcomment);
			 query.setString("msa", softskillProof);
			 query.setInteger("rs", review_softskill_id);
			 query2.setString("as", "approved");
			 query2.setInteger("rd",review_id);
			 
			 int result = query.executeUpdate();
			 int result2 = query2.executeUpdate();
			 System.out.println("result :"+result);
			 System.out.println("result :"+result2);
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

	public boolean reviewManagerSoftIDUpdate(int manager_softgrade_id,String manager_softcomment,int review_id,String softskillProof){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewSoftskillBean set managerGradeMasterBean = :mg ,comment_manager = :cm ,manager_soft_attachment = :msa where review_id = :rd ");
			 query.setInteger("mg", manager_softgrade_id);
			 query.setString("cm", manager_softcomment);
			 query.setString("msa", softskillProof);
			 query.setInteger("rd",review_id);
			 
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
	
	
	public boolean reviewUpdate(double techAve,double softAve,double techBonus,double softBonus,double totalBonus,int review_id,int performance_score){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewBean set tech_ave = :ta ,soft_ave = :sa,tech_bonus = :tc,soft_bonus = :sb,total_bonus = :tb,performance_score = :ps where review_id = :ri ");
			 query.setDouble("ta", techAve);
			 query.setDouble("sa", softAve);
			 query.setDouble("tc", techBonus);
			 query.setDouble("sb", softBonus);
			 query.setDouble("tb", totalBonus);
			 query.setInteger("ps", performance_score);
			 query.setInteger("ri", review_id);
			 
			 
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
	
	public boolean reviewStatusUpdate(int review_id,String remarks){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewBean set approve_status = :as, remarks_manager = :rm  where review_id= :rd");
			 query.setString("as", "rejected");
			 query.setString("rm", remarks);
			 query.setInteger("rd", review_id);
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

	public boolean techAttachmentUpdate(int reviewTech_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewCriteriaBean set criteria_attachment = :ca where review_criteria_id= :rcd");
			 query.setString("ca","-");
			 query.setInteger("rcd", reviewTech_id);
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
	
	public boolean managerTechAttachmentUpdate(int reviewTech_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewCriteriaBean set manager_tech_attachment = :mta where review_criteria_id= :rcd");
			 query.setString("mta","-");
			 query.setInteger("rcd", reviewTech_id);
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
	
	public boolean softAttachmentUpdate(int reviewSoft_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewSoftskillBean set softskill_attachment = :sa where review_softskill_id= :rsd");
			 query.setString("sa","-");
			 query.setInteger("rsd", reviewSoft_id);
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
	
	public boolean managerSoftAttachmentUpdate(int reviewSoft_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewSoftskillBean set manager_soft_attachment = :msa where review_softskill_id= :rsd");
			 query.setString("msa","-");
			 query.setInteger("rsd", reviewSoft_id);
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
	
	
	/*public boolean reviewCriteriaUpdate(ReviewCriteriaBean reviewCriteriaBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(reviewCriteriaBean);
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
	}*/
	
	public boolean reviewCriteriaUpdate(int technicalCriteria_id,int technicalGrade,String technicalComment,String technicalProof,int review_criteria_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewCriteriaBean set technicalBean = :tb,gradeMasterBean = :gb, comment_employee =:ce, criteria_attachment = :ca  where review_criteria_id= :rcd");
			 query.setInteger("tb",technicalCriteria_id);
			 query.setInteger("gb", technicalGrade);
			 query.setString("ce",technicalComment);
			 query.setString("ca",technicalProof);
			 query.setInteger("rcd", review_criteria_id);
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

	/*public boolean reviewSoftskillUpdate(ReviewSoftskillBean reviewSoftskillBean){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(reviewSoftskillBean);
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
	*/
	
	public boolean reviewSoftskillUpdate(int softskill_id,int sofskillGrade,String softskillComment,String softskillProof,int review_softskill_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewSoftskillBean set softskillBean = :sb,gradeMasterBean = :gb, comment_employee =:ce, softskill_attachment = :sa  where review_softskill_id= :rsd");
			 query.setInteger("sb",softskill_id);
			 query.setInteger("gb", sofskillGrade);
			 query.setString("ce",softskillComment);
			 query.setString("sa",softskillProof);
			 query.setInteger("rsd", review_softskill_id);
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
	
	
	public boolean statusUpdate(int review_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewBean set approve_status = :as where review_id= :rd");
			 query.setString("as","updated");
			 query.setInteger("rd", review_id);
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
	
	public boolean reviewAchivementsUpdate(String achievements,String area_of_improvement,int review_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewBean set achievements = :a ,area_of_improvement = :aoi ,date_finalize_manager = :dfm where review_id = :ri ");
			 query.setString("a", achievements);
			 query.setString("aoi", area_of_improvement);
			 query.setInteger("ri", review_id);
			 query.setString("dfm","-");
			 
			 
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
	
	public boolean reviewtechGradeUpdate(int review_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewCriteriaBean set managerGradeMasterBean= :mgb where review_id= :rd");
			 query.setInteger("mgb", 0);
			 query.setInteger("rd", review_id);
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

	public boolean reviewSoftGradeUpdate(int review_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewSoftskillBean set managerGradeMasterBean= :mgb where review_id= :rd");
			 query.setInteger("mgb", 0);
			 query.setInteger("rd", review_id);
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
	
	public boolean finalizeDateUpdate(int review_id,String date ){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewBean set date_finalize_manager = :dfm where review_id= :rd");
			 query.setString("dfm",date);
			 query.setInteger("rd", review_id);
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
	
	public boolean reviewEscalteUpdate(int employee_id,int review_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ReviewBean set approve_status = :as, escalated_employee_id = :eei where review_id= :rd");
			 query.setString("as", "escalated");
			 query.setInteger("eei", employee_id);
			 query.setInteger("rd", review_id);
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
	
	
	
	
	
	public boolean milestoneUpdate(int milestone_id,String milestone_name,String milestone_desc,int priority_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update MilestoneBean set milestone_name = :mn , milestone_description = :md , priorityBean = :pb where milestone_id = :mi");
			query.setString("mn", milestone_name);
			query.setString("md", milestone_desc);
			query.setInteger("pb", priority_id);
			 query.setInteger("mi", milestone_id);
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
	
	
	
	
	
	
	
	public boolean projectAllUpdate(String projectName,String project_desc,String startDate,String endDate,double cost,String resources,String duration,int client_id,int priority_id,int project_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectMasterBean set project_master_name = :pmn, project_description = :pd, planned_start_date = :psd,planned_end_date = :ped, proj_estimated_cost = :pec, proj_estimated_resources = :per,proj_estimated_duration = :ped1,clientMasterBean = :cmb,priorityBean = :pb  where project_master_id = :pmi");
			 query.setString("pmn", projectName);
			 query.setString("pd", project_desc);
			 query.setString("psd", startDate);
			 query.setString("ped", endDate);
			 query.setDouble("pec", cost);
			 query.setString("per", resources);
			 query.setString("ped1", duration);
			 query.setInteger("cmb",client_id);
			 query.setInteger("pb", priority_id);
			 query.setInteger("pmi", project_id);
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
	
	
	
	
	
	public boolean employeeAllUpdate(int employee_dummy_id,String firstname, String middlename, String lastname ,int employee_code, String salutation, String marital_status, String adress, String joining_date, String birth_date, int department_id , String sub_department, String gender , String gross_salary, String languages, String blood_group, String height, String weight, String identification_marks, int company_id, String location, int role_id, int manager_id, String resource_cost, String email_id, String mob_num, String nationality, String basic_qualification, String special_qualification,int employee_status_id,String graduate_degree,String master_degree,String per_emailid, String cug_num, String grade_code, String iti_course, String diploma_course, String special_interest )
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update EmployeeBean set firstname = :a, middlename = :b,  lastname = :c , employee_code = :d,  salutation = :e,  marital_status = :f,  adress = :g,  joining_date = :h,  birth_date = :i,  department_id = :j,  sub_department = :k,  gender= :l ,  gross_salary= :m,  languages= :n,  blood_group = :o,  height = :p,  weight= :q,  identification_marks = :r,  company_list_id= :s, location = :u,  role_id= :v, under_manager_id= :w, resource_cost= :x,  email_id= :y,  mob_num= :z,  nationality= :aa, basic_qualification = :ab ,special_qualification= :ac,employee_status_id = :es , graduate_degree = :gd, master_degree =:md, per_emailid = :pe, cug_num =:cn, grade_code =:grade_code ,iti_course =:iti , diploma_course =:diploma, special_interest =:sp where employee_master_id= :emp_id ");
			 query.setString("a", firstname);
			 query.setString("b", middlename);
			 query.setString("c", lastname);
			 query.setInteger("d", employee_code);
			 query.setString("e", salutation);
			 query.setString("f", marital_status);
			 query.setString("g", adress);
			 query.setString("h",joining_date);
			 query.setString("i", birth_date);
			 query.setInteger("j", department_id);
			 query.setString("k", sub_department);
			 query.setString("l", gender);
			 query.setString("m", gross_salary);
			 query.setString("n", languages);
			 query.setString("o", blood_group);
			 query.setString("p", height);
			 query.setString("q", weight);
			 query.setString("r", identification_marks);
			 query.setInteger("s", company_id);
			 query.setString("u", location);
			 query.setInteger("v", role_id);
			 query.setInteger("w", manager_id);
			 query.setString("x", resource_cost);
			 query.setString("y", email_id);
			 query.setString("z", mob_num);
			 query.setString("aa", nationality);
			 query.setString("ab", basic_qualification);
			 query.setString("ac", special_qualification);
			 query.setInteger("es", employee_status_id);
			 query.setInteger("emp_id", employee_dummy_id);
			 query.setString("gd",graduate_degree);
			query.setString("md", master_degree);
			query.setString("pe", per_emailid);
			query.setString("cn", cug_num);
			query.setString("grade_code", grade_code);
			query.setString("iti", iti_course);
			query.setString("diploma", diploma_course);
			query.setString("sp", special_interest);
			
			
			
			
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
	
	
	
	
	public boolean employeeProfileUpdate(int employee_master_id,String profile_pic){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 boolean result = false;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update EmployeeBean set photo= :p where employee_master_id= :emp_id ");
			 query.setString("p", profile_pic);
			 query.setInteger("emp_id", employee_master_id);
			 int result1 = query.executeUpdate();
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
	
	
	
	
	
	public boolean projectUpdate(int project_id,String reason,String date){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectMasterBean set proj_hold_date = :phd, proj_hold_reason = :phr, projectStatusBean = :p where project_master_id = :psi");
			 query.setString("phd", date);
			 query.setString("phr", reason);
			 query.setInteger("p", 1);
			 query.setInteger("psi", project_id);
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
	
	public boolean projectStatusUpdate(int project_id,String date){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectMasterBean set proj_resume_date = :prd,  projectStatusBean = :p where project_master_id = :psi");
			 query.setString("prd", date);
			 query.setInteger("p",3);
			 query.setInteger("psi", project_id);
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
	
	
	
	public boolean holdHistoryStatusUpdate(int project_id,String date){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectHoldHistoryBean set project_resume_date = :prd where project_master_id = :psi and project_resume_date = '-'");
			 query.setString("prd", date);
			 query.setInteger("psi", project_id);
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
	
	public boolean milestoneIdUpdate(int milestone_id,int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set milestoneBean = :mi where task_master_id = :tmi");
			 query.setInteger("mi", milestone_id);
			 query.setInteger("tmi", task_id);
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
	
	
	
	public boolean milestoneIdUpdate1(int milestoneTaskID,int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set task_id = :ti where task_master_id = :tmi");
			 query.setInteger("ti", milestoneTaskID);
			 query.setInteger("tmi", task_id);
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
	
	public boolean milestoneUpdate(int milestone_id,String milestone_name,String milestone_desc,int priority_id,String start_date,String end_date,String duration){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update MilestoneBean set milestone_name = :mn , milestone_description = :md , priorityBean = :pb , planned_start_date = :psd, planned_end_date = :ped, milestone_estimated_duration = :med where milestone_id = :mi");
			query.setString("mn", milestone_name);
			query.setString("md", milestone_desc);
			query.setString("psd", start_date);
			query.setString("ped", end_date);
			query.setString("med", duration);
			query.setInteger("pb", priority_id);
			 query.setInteger("mi", milestone_id);
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
	
	public boolean projectPriorityUpdate(int project_id,int priority_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectMasterBean set priorityBean = :pb where project_master_id = :pmi");
			 query.setInteger("pb", priority_id);
			 query.setInteger("pmi", project_id);
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
	
	
	public boolean milestonePriorityUpdate(int milestone_id,int priority_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update MilestoneBean set priorityBean = :pb where milestone_id = :mi");
			 query.setInteger("pb", priority_id);
			 query.setInteger("mi", milestone_id);
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
	
	
	public boolean taskPriorityUpdate(int task_id,int priority_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set priorityBean = :pb where task_master_id = :tmi");
			 query.setInteger("pb", priority_id);
			 query.setInteger("tmi", task_id);
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
	
	
	
	public boolean changePrioritynotificationUpdate(int id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ChangePriorityNotificationBean set show_notification = :sn where change_priority_notification_id = :cpni");
			 query.setInteger("sn", 1);
			 query.setInteger("cpni", id);
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
	
	public boolean projectAllUpdate(String projectName,String project_desc,String startDate,String endDate,double cost,String resources,String duration,int client_id,int priority_id,int project_id,String project_code,double machine_cost,String deliverable){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectMasterBean set project_master_name = :pmn, project_description = :pd, planned_start_date = :psd,planned_end_date = :ped, proj_estimated_cost = :pec, proj_estimated_resources = :per,proj_estimated_duration = :ped1,clientMasterBean = :cmb,priorityBean = :pb, machine_cost= :mc, project_code = :pc, deliverable = :del where project_master_id = :pmi");
			 query.setString("pmn", projectName);
			 query.setString("pd", project_desc);
			 query.setString("psd", startDate);
			 query.setString("ped", endDate);
			 query.setString("pc", project_code);
			 query.setDouble("pec", cost);
			 query.setDouble("mc", machine_cost);
			 query.setString("per", resources);
			 query.setString("ped1", duration);
			 query.setInteger("cmb",client_id);
			 query.setInteger("pb", priority_id);
			 query.setInteger("pmi", project_id);
			 query.setString("del", deliverable);
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
	
	
	
	public boolean taskUpdate(String taskName,String task_desc,String startDate,String endDate,double cost,String resources,String duration,int priority_id,int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set task_master_name = :tmn, task_description = :td, task_planned_start_date = :tpsd,task_planned_end_date = :tped, task_estimated_cost = :tec, task_estimated_resources = :ter,task_estimated_duration = :ted1,priorityBean = :pb  where task_master_id = :tmi");
			 query.setString("tmn", taskName);
			 query.setString("td", task_desc);
			 query.setString("tpsd", startDate);
			 query.setString("tped", endDate);
			 query.setDouble("tec", cost);
			 query.setString("ter", resources);
			 query.setString("ted1", duration);
			 query.setInteger("pb", priority_id);
			 query.setInteger("tmi", task_id);
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
	
	public boolean changeProjectUpdateNotification(int id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectUpdateNotificationBean set show_view = :sv where project_update_notification_id = :puni");
			 query.setInteger("sv", 1);
			 query.setInteger("puni", id);
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
	
	public boolean projectAllocationPercentageUpdate(String endDate , int id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectAllocationPercentageBean set allocation_end_date = :aed , allocation_status = :as where project_allocation_percentage_id = :papi");
			 query.setString("aed", endDate);
			 query.setInteger("papi", id);
			 query.setInteger("as", 0);
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
	
	public boolean projectEmplpoyeeDeAllocation(String endDate , int id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectAllocationPercentageBean set allocation_end_date = :aed , allocation_status = :as where project_allocation_percentage_id = :papi");
			 query.setString("aed", endDate);
			 query.setInteger("papi", id);
			 query.setInteger("as", 0);
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
	
	public boolean changeAllocationShowView(int id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AllocationNotificationBean set show_view = :sv where allocation_notification_id = :ani");
			 query.setInteger("sv", 1);
			 query.setInteger("ani", id);
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
	
	
	
	public boolean employeeAllUpdate(int employee_dummy_id,String firstname, String middlename, String lastname ,int employee_code, String salutation, String marital_status, String adress, String joining_date, String birth_date, int department_id , String sub_department, String gender , String gross_salary, String languages, String blood_group, String height, String weight, String identification_marks, int company_id, String password, String location, int role_id, int manager_id, String resource_cost, String email_id, String mob_num, String nationality, String basic_qualification, String special_qualification,int employee_status_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update EmployeeBean set firstname = :a, middlename = :b,  lastname = :c , employee_code = :d,  salutation = :e,  marital_status = :f,  adress = :g,  joining_date = :h,  birth_date = :i,  department_id = :j,  sub_department = :k,  gender= :l ,  gross_salary= :m,  languages= :n,  blood_group = :o,  height = :p,  weight= :q,  identification_marks = :r,  company_list_id= :s,  password = :t, location = :u,  role_id= :v, under_manager_id= :w, resource_cost= :x,  email_id= :y,  mob_num= :z,  nationality= :aa, basic_qualification = :ab ,special_qualification= :ac,employee_status_id = :es where employee_master_id= :emp_id ");
			 query.setString("a", firstname);
			 query.setString("b", middlename);
			 query.setString("c", lastname);
			 query.setInteger("d", employee_code);
			 query.setString("e", salutation);
			 query.setString("f", marital_status);
			 query.setString("g", adress);
			 query.setString("h",joining_date);
			 query.setString("i", birth_date);
			 query.setInteger("j", department_id);
			 query.setString("k", sub_department);
			 query.setString("l", gender);
			 query.setString("m", gross_salary);
			 query.setString("n", languages);
			 query.setString("o", blood_group);
			 query.setString("p", height);
			 query.setString("q", weight);
			 query.setString("r", identification_marks);
			 query.setInteger("s", company_id);
			 query.setString("t", password);
			 query.setString("u", location);
			 query.setInteger("v", role_id);
			 query.setInteger("w", manager_id);
			 query.setString("x", resource_cost);
			 query.setString("y", email_id);
			 query.setString("z", mob_num);
			 query.setString("aa", nationality);
			 query.setString("ab", basic_qualification);
			 query.setString("ac", special_qualification);
			 query.setInteger("es", employee_status_id);
			 query.setInteger("emp_id", employee_dummy_id);
			
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
	
	
	
	
	
	public boolean becomeInependantTask(int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set milestoneBean = :mb where task_master_id = :tmi");
			 query.setInteger("mb", 1);
			 query.setInteger("tmi", task_id);
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
	
	
	
	public boolean deallocateTask(int project_id,int emp_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectAllocationBean set allocation_status = :as where projectMasterBean = :pmb and employeeBean = :eb");
			 query.setInteger("as", 0);
			 query.setInteger("pmb", project_id);
			 query.setInteger("eb", emp_id);
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
	
	
	
	public boolean setMilestoneIdinTask(int milestone_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		  
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set milestoneBean = :mb where milestoneBean = :mb1");
			 query.setInteger("mb", 1);
			 query.setInteger("mb1", milestone_id);
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
	
	
	public boolean engFeasibilityUpdate(EngineeringFeasibilityBean engineeringFeasibilityBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(engineeringFeasibilityBean);
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
	
	
	public boolean costFeasibilityUpdate(CostFeasibilityBean costFeasibilityBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(costFeasibilityBean);
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
	
	
	public boolean manFeasibilityUpdate(ManufacturingFeasibilityBean manufacturingFeasibilityBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(manufacturingFeasibilityBean);
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
	
	
	public boolean fixFeasibilityUpdate(FixtureFeasibiltyBean fixtureFeasibiltyBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(fixtureFeasibiltyBean);
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
	
	
	public boolean qualFeasibilityUpdate(QualityFeasibilityBean qualityFeasibilityBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(qualityFeasibilityBean);
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
	
	
	
	public boolean projInputsHeadUpdateUpdate(ProjectDesignHeadBean projectDesignHeadBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(projectDesignHeadBean);
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
	
	public boolean projInputsBodyUpdateUpdate(ProjectDesignInputsBean projectDesignInputsBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(projectDesignInputsBean);
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
	
	
	public boolean taskDateUpdate(int task_id,String startDate,String endDate){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set task_planned_start_date = :tpsb,task_planned_end_date = :tpeb where task_master_id = :tmi");
			 query.setString("tpsb", startDate);
			 query.setString("tpeb", endDate);
			 query.setInteger("tmi", task_id);
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
	
	
	
	public boolean taskActualDateUpdate(int task_id,String startDate,String endDate){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set task_actual_start_date = :tpsb,task_actual_end_date = :tpeb where task_master_id = :tmi");
			 query.setString("tpsb", startDate);
			 query.setString("tpeb", endDate);
			 query.setInteger("tmi", task_id);
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
	
	
	
	
	
	public boolean milestoneDateUpdate(int milestone_id,String startDate,String endDate){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update MilestoneBean set planned_start_date = :tpsb,planned_end_date = :tpeb where milestone_id = :tmi");
			 query.setString("tpsb", startDate);
			 query.setString("tpeb", endDate);
			 query.setInteger("tmi", milestone_id);
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
	
	
	public boolean setMilestoneIdinTaskId(int taskId,int milestone_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		  
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set milestoneBean = :mb,task_id = :ti1 where task_id = :ti");
			 query.setInteger("mb", milestone_id);
			 query.setInteger("ti", taskId);
			 query.setInteger("ti1", 0);
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
	
	
	public boolean setMilestoneOrNot(int taskId){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		  
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set milestone_or_not = :mb where task_master_id = :ti");
			 query.setInteger("mb", 1);
			 query.setInteger("ti", taskId);
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
	
	
	public boolean setMilestoneToTask(int taskId){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		  
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set milestone_or_not = :mb where task_master_id = :ti");
			 query.setInteger("mb", 0);
			 query.setInteger("ti", taskId);
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
	
	
	public boolean setMasterTaskId(int masterTaskId,int task_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set master_task_id = :mti where task_master_id = :ti");
			 query.setInteger("mti", masterTaskId);
			 query.setInteger("ti", task_id);
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
	
	
	public boolean setMasterTaskIdToZero(int masterTaskId,int manager_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set master_task_id = :mti where master_task_id = :ti and managerBean = :mb");
			 query.setInteger("mti", 0);
			 query.setInteger("ti", masterTaskId);
			 query.setInteger("mb", manager_id);
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
	
	
	
	public boolean assignManagerIdUpdate(int assignId,int emp_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectAssignToManagerBean set employeeBean = :ei where project_assign_to_manager_id = :psmi");
			 query.setInteger("psmi", assignId);
			 query.setInteger("ei", emp_id);
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
	
	
	
	public boolean taskRemarkUpdate(int taskRemarkId,String remarks){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskRemarkBean set remarks = :rs where task_remark_id = :tri");
			 query.setInteger("tri", taskRemarkId);
			 query.setString("rs", remarks);
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
	
	
	public boolean taskNameUpdate(int task_id,String Name){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TaskMasterBean set task_master_name = :tmn where task_master_id = :tmi");
			 query.setString("tmn", Name);
			 query.setInteger("tmi", task_id);
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
	
	
	
	public boolean deallocateEmployeeFromTaskUpdate(int task_id,int employee_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		  
		 
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update ProjectAllocationBean set allocation_status = :as where task_master_id = :tmi and employeeBean = :eb");
			 query.setInteger("as", 0);
			 query.setInteger("tmi", task_id);
			 query.setInteger("eb", employee_id);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean appraisalUpdate(String achievement,String area_of_improvement,String emp_comment,String appraiser_comment,String reviewing_comment,int appraisal_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AppraisalBean set achievement = :a, area_of_improvement= :aoi ,emp_comment= :ec, appraiser_commnet = :ac ,reviewing_comment = :rc, status =:s where appraisal_id = :ai");
			query.setString("a", achievement);
			query.setString("aoi", area_of_improvement);
			query.setString("ec", emp_comment);
			query.setString("ac", appraiser_comment);
			query.setString("rc", reviewing_comment);
			if(appraiser_comment.equalsIgnoreCase("-")){
			query.setString("s", "pending");
			}else{
			query.setString("s", "approved");
			}
			query.setInteger("ai", appraisal_id);
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
	
	
	
	public boolean appraisalUpdate1(String appraiser_comment,String reviewing_comment,int appraisal_id,String status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AppraisalBean set appraiser_commnet = :ac ,reviewing_comment = :rc, status = :s where appraisal_id = :ai");
			query.setString("ac", appraiser_comment);
			query.setString("rc", reviewing_comment);
			query.setString("s", status);
			query.setInteger("ai", appraisal_id);
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
	
	public boolean appraisalLeaveUpdate(AppraisalLeaveBean appraisalLeaveBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(appraisalLeaveBean);
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
	
	public boolean appraisalKaizenUpdate(AppraisalKizenBean appraisalKizenBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(appraisalKizenBean);
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
	
	public boolean appraisal5sUpdate(Appraisal5sBean appraisal5sBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(appraisal5sBean);
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
	
	
	public boolean appraisalTrainingUpdate(AppraisalTrainingBean appraisalTrainingBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(appraisalTrainingBean);
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
	
	
	public boolean appraisalCriteriaGradeUpdate(AppraisalCriteriaGradeBean appraisalCriteriaGradeBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(appraisalCriteriaGradeBean);
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
	
	public boolean appraisalWhiteCollarUpdate(int criteria_id,String weightage,String comment, int grade_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AppraisalWhiteCollarGradeBean set weightage = :w, appraiser_comment= :ac ,appraisalGradeBean= :ag where appraisal_white_grade_id = :awgi");
			query.setString("w", weightage);
			query.setString("ac", comment);
			query.setInteger("ag", grade_id);
			query.setInteger("awgi", criteria_id);
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
	
	
	public boolean appraisalperUpdate(double per ,int appraisal_id){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AppraisalBean set per = :p where appraisal_id = :api");
			query.setDouble("p", per);
			query.setInteger("api", appraisal_id);
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
	
	
	public boolean monthlyGradeUpdate(MonthlyGoalDetailBean monthlyGoalDetailBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(monthlyGoalDetailBean);
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
	
	
	
	public boolean appraisalWhiteCollarSection1Update(AppraisalWhiteSection1Bean appraisalWhiteSection1Bean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(appraisalWhiteSection1Bean);
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
	
	public boolean appraisalWhiteCollarSection11Update(AppraisalWhiteCollarGradeBean appraisalWhiteCollarGradeBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(appraisalWhiteCollarGradeBean);
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
	
	
	public boolean workGradeUpdate(WorkGradeBean workGradeBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(workGradeBean);
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
	
	
	
	// Update Account Detail Of Employee
	// Update Account Detail Of Employee
			public boolean updateAccountDetail(int employee_master_id, String pan_no, String adhar_no, String pf_uan_no, String esic_no, String bank_acount_no, String bank_name, String pf_no, String ifsc_code){
				 Session session = HibernateUtil.openSession();
				 Transaction tx = null;	
				 
				 try {
					 tx = session.getTransaction();
					 tx.begin();
					 Query query = session.createQuery("update EmployeeBean set pan_no =:p ,adhar_no =:a, pf_no =:pf_no,pf_uan_no =:pn, esic_no =:en, bank_acount_no =:ba, bank_name =:bn, ifsc_code =:ic where employee_master_id = :e ");
					 query.setString("p", pan_no);
					 query.setString("a", adhar_no);
					 query.setString("pf_no", pf_no);
					 query.setString("pn", pf_uan_no);
					 query.setString("en", esic_no);
					 query.setString("ba", bank_acount_no);
					 query.setString("bn", bank_name);
					 query.setString("ic", ifsc_code);
					 query.setInteger("e", employee_master_id);
					 
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

	//Update data in family_detail_tbl
	//Date : 13-06-2017
		//Name : Bhoomi Patel

	public boolean familyDetailUpdate(FamilyDetailBean familyDetailBean){
			 Session session = HibernateUtil.openSession();
			 Transaction tx = null;	
			 try {
				 tx = session.getTransaction();
				 tx.begin();
				 session.update(familyDetailBean);
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
