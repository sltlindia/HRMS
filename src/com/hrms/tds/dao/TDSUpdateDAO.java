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
								double lta_during_year, double d_lta, double annual_ptax, double annual_uni_allw_during_year, double d_uni_allw ){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update TDSTotalBBean set conveyance =:c, d_conveyance =:dc, a_total_basic =:atb, d_non_metro_total_basic =:nmtb, "
			 			+ "d_metro_total_basic =:mtb, a_hra =:ah, d_non_metro_hra =:nmh, d_non_metro_hra =:nmh, a_medical =:am, d_medical =:dm, lta_during_year =:ldy, d_lta =:dl, "
			 		  	+ "ptax =:ptax, uni_allw_during_year =:uady, d_uni_allw =:dua where tds_id =:tid");
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
}
