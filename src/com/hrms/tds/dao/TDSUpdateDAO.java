package com.hrms.tds.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.util.HibernateUtil;

public class TDSUpdateDAO {

	public boolean tdsStatusUpdate(int emp_id,String status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSBean set status =:s where employee_master_id =:eid");
			 query.setString("s","view");
			 query.setInteger("eid", emp_id);
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
	
	public boolean tdsStatusUpdateHrSide(int emp_id,String status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSHrBean set status =:s where employee_master_id =:eid");
			 query.setString("s","updated");
			 query.setInteger("eid", emp_id);
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
	
	public boolean tdsStatusLock(int emp_id,String status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSBean set status =:s where employee_master_id =:eid");
			 query.setString("s","LOCK");
			 query.setInteger("eid", emp_id);
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
	
	public boolean ischeckedUpdate(int id, String attachment_name, int ischecked){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSDocumentUploadBean set ischecked =:ic where employee_master_id =:eid AND attachment_name =:an");
			 query.setString("ic","1");
			 query.setInteger("eid", id);
			 query.setString("an", attachment_name);
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
	
	public boolean ischeckedUpdateuserside(int id, String attachment_name, int ischeckeduserside){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSDocumentUploadBean set ischeckeduserside =:icus where employee_master_id =:eid AND attachment_name =:an");
			 query.setString("icus","1");
			 query.setInteger("eid", id);
			 query.setString("an", attachment_name);
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
	
	public boolean ischeckedUpdateForTDSHistory(int id,int ischecked){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSHistoryBean set ischecked =:ic where tds_history_id =:eid");
			 query.setString("ic","1");
			 query.setInteger("eid", id);
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
	
	public boolean documentStatusChange(int tds_id,String name, String status){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSDocumentUploadBean set status =:s where tds_id =:td AND attachment_name =:an");
			 query.setString("s",status);
			 query.setString("an",name);
			 query.setInteger("td", tds_id);
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
	
	public boolean tdsPayrollSalaryDataUpdate(int employee_code, String companyName, double basicSalary, double hra, double conveyance, double medeical,  double educationAllw, double uniformAllw){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSPayrollSalaryDataBean set basic_salary =:bs, conveyance =:c, hra =:h, medical =:m, uni_allw =:ua, edu_allw =:ea"
			 		+ "where employee_code =:ec and company_name =:cn");
			 query.setDouble("bs", basicSalary);
			 query.setDouble("c", conveyance);
			 query.setDouble("h", hra);
			 query.setDouble("m", medeical);
			 query.setDouble("ua", uniformAllw);
			 query.setDouble("ea", educationAllw);
			 query.setInteger("ec", employee_code);
			 query.setString("cn", companyName);
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
	
	
	public boolean tdsTotalAUpdate(int tds_id, double annual_gross_salary, double bonus, double gross_salary, double incentive, double prvSalary, double performancePay, double totalA){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSTotalABean set annual_gross_salary =:ags, bonus =:b, leaveCount =:gs, incentive =:i, previous_employeed_salary =:pes, performance_pay =:pp, total_a =:ta where tds_id =:tid");
			 query.setDouble("ags", annual_gross_salary);
			 query.setDouble("b", bonus);
			 query.setDouble("gs", gross_salary);
			 query.setDouble("i", incentive);
			 query.setDouble("pes", prvSalary);
			 query.setDouble("pp", performancePay);
			 query.setDouble("ta", totalA);
			 query.setInteger("tid", tds_id);
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
	
	//(tds_id, a_conveyance, d_conveyance, annual_basic_salary, d_non_metro_total_basic, d_metro_total_basic, annual_hra, d_non_metro_hra, d_metro_hra, a_medical, d_medical, lta_during_year, d_lta, annual_ptax, annual_education_allw, annual_uni_allw_during_year, d_uni_allw )
	public boolean tdsTotalBUpdate(int tds_id, double a_conveyance, double d_conveyance, double annual_basic_salary, double d_non_metro_total_basic, 
								double d_metro_total_basic, double annual_hra, double d_non_metro_hra, double d_metro_hra, double a_medical, double d_medical, 
								double lta_during_year, double d_lta, double annual_ptax, double annual_uni_allw_during_year, double d_uni_allw, double meal_card ){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSTotalBBean set conveyance =:c, d_conveyance =:dc, a_total_basic =:atb, d_non_metro_total_basic =:nmtb, "
			 			+ "d_metro_total_basic =:mtb, a_hra =:ah, d_non_metro_hra =:nmh, d_non_metro_hra =:nmh, a_medical =:am, d_medical =:dm, lta_during_year =:ldy, d_lta =:dl, "
			 		  	+ "ptax =:ptax, uni_allw_during_year =:uady, d_uni_allw =:dua, meal_card =:mc where tds_id =:tid");
			 query.setDouble("c", a_conveyance);
			 query.setDouble("dc", d_conveyance);
			 query.setDouble("atb", annual_basic_salary);
			 query.setDouble("nmtb", d_non_metro_total_basic);
			 query.setDouble("mtb", d_metro_total_basic);
			 query.setDouble("ah", annual_hra);
			 query.setDouble("nmh", d_non_metro_hra);
			 query.setDouble("nmh", d_metro_hra);
			 query.setDouble("am", a_medical);
			 query.setDouble("dm", d_medical);
			 query.setDouble("ldy", lta_during_year);
			 query.setDouble("dl", d_lta);
			 query.setDouble("ptax", annual_ptax);
			 query.setDouble("uady", annual_uni_allw_during_year);
			 query.setDouble("dua", d_uni_allw);
			 query.setDouble("mc", meal_card);
			 query.setInteger("tid", tds_id);
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
	
	public boolean tdsTotalDUpdate(int tds_id, double pf){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSTotalDBean set EPF =:e where tds_id =:tid");
			 query.setDouble("e", pf);
			 query.setInteger("tid", tds_id);
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
	
	
	public boolean tdsTotalFUpdate(int tds_id, double april, double may, double june, double july, 
			double august, double september, double october, double november, double december, double january, 
			double february, double march, double tax_paid){
		Session session = HibernateUtil.openSession();
		Transaction tx = null;	
			try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("update TDSTotalFBean set april =:april, may =:may, june =:june, july =:july, "
					+ "august =:august, september =:september, october =:october, november =:november, december =:december, january =:january, february =:february, "
				  	+ "march =:march, tax_paid =:tax_paid where tds_id =:tid");
			query.setDouble("april", april);
			query.setDouble("may", may);
			query.setDouble("june", june);
			query.setDouble("july", july);
			query.setDouble("august", august);
			query.setDouble("september", september);
			query.setDouble("october", october);
			query.setDouble("november", november);
			query.setDouble("december", december);
			query.setDouble("january", january);
			query.setDouble("february", february);
			query.setDouble("march", march);
			query.setDouble("tax_paid", tax_paid);
			query.setInteger("tid", tds_id);
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
	
	public boolean tdsPayrollMasterUpdate(int tds_payroll_master_data_id, double annual_salary, double bonus, double leave, double incentive, 
			double previous_salary, double full_final_bonus, double full_final_leave, double performance, double ltc, double ptax, 
			double pf, double mealCard){
			System.err.println("ID :"+tds_payroll_master_data_id);
			Session session = HibernateUtil.openSession();
			Transaction tx = null;	
			try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("update TDSPayrollMasterDataBean set salary =:s, bonus =:b, leave_count =:l, full_final_bonus =:ffb, "
					+ "full_final_leave =:ffl, incentive =:i, previous_salary =:ps, performance =:p, mealcard =:m, lta =:lta, ptax =:ptax, epf =:pf "
				  	+ "where tds_payroll_master_data_id =:id");
			query.setDouble("s", annual_salary);
			query.setDouble("b", bonus);
			query.setDouble("l", leave);
			query.setDouble("ffb", full_final_bonus);
			query.setDouble("ffl", full_final_leave);
			query.setDouble("i", incentive);
			query.setDouble("ps", previous_salary);
			query.setDouble("p", performance);
			query.setDouble("m", mealCard);
			query.setDouble("lta", ltc);
			query.setDouble("ptax", ptax);
			query.setDouble("pf", pf);
			query.setInteger("id", tds_payroll_master_data_id);
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
	
	
	public boolean tdsPayrollBasicUpdate(int tds_payroll_id, double basicSalary, double conveyance, double medical, double uniAllw, 
			double eduAllw, double hra, double annualBasicSalary, double annualConveyance, double annualMedical, double annualUniAllow, 
			double annualEduAllow, double annualHra){
			System.err.println("ID :"+tds_payroll_id);
			Session session = HibernateUtil.openSession();
			Transaction tx = null;	
			try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("update TDSPayrollBean set basic_salary =:s, conveyance =:b, medical =:l, uni_allw =:ffb, "
					+ "edu_allw =:ffl, hra =:i, annual_basic_salary =:ps, annual_conveyance =:p, annual_medical =:m, annual_uni_allw =:lta, annual_edu_allw =:ptax, annual_hra =:pf "
				  	+ "where tds_payroll_id =:id");
			query.setDouble("s", basicSalary);
			query.setDouble("b", conveyance);
			query.setDouble("l", medical);
			query.setDouble("ffb", uniAllw);
			query.setDouble("ffl", eduAllw);
			query.setDouble("i", hra);
			query.setDouble("ps", annualBasicSalary);
			query.setDouble("p", annualConveyance);
			query.setDouble("m", annualMedical);
			query.setDouble("lta", annualUniAllow);
			query.setDouble("ptax", annualEduAllow);
			query.setDouble("pf", annualHra);
			query.setInteger("id", tds_payroll_id);
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
