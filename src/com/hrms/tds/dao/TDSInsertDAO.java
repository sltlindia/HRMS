package com.hrms.tds.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.tds.bean.TDSBean;
import com.hrms.tds.bean.TDSDocumentUploadBean;
import com.hrms.tds.bean.TDSHistoryBean;
import com.hrms.tds.bean.TDSHrBean;
import com.hrms.tds.bean.TDSHrHistoryBean;
import com.hrms.tds.bean.TDSHrTotalABean;
import com.hrms.tds.bean.TDSHrTotalBBean;
import com.hrms.tds.bean.TDSHrTotalCBean;
import com.hrms.tds.bean.TDSHrTotalDBean;
import com.hrms.tds.bean.TDSHrTotalEBean;
import com.hrms.tds.bean.TDSHrTotalFBean;
import com.hrms.tds.bean.TDSPayrollBean;
import com.hrms.tds.bean.TDSPayrollSalaryDataBean;
import com.hrms.tds.bean.TDSTaxBean;
import com.hrms.tds.bean.TDSTotalABean;
import com.hrms.tds.bean.TDSTotalBBean;
import com.hrms.tds.bean.TDSTotalCBean;
import com.hrms.tds.bean.TDSTotalDBean;
import com.hrms.tds.bean.TDSTotalEBean;
import com.hrms.tds.bean.TDSTotalFBean;
import com.hrms.tds.util.HibernateUtil;



public class TDSInsertDAO {
	
	public boolean tdsPayrollInsert(TDSPayrollBean tdsPayrollBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsPayrollBean);
			 System.out.println("In TDSPayroll Data inserted");
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
	
	public boolean tdsPayrollSalaryDataInsert(TDSPayrollSalaryDataBean tdsPayrollSalaryDataBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.save(tdsPayrollSalaryDataBean);
			 System.out.println("In TDSPayroll Salary Data inserted");
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
	
	
	
	public boolean tdsInsert(TDSBean tdsBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsBean);
			 System.out.println("inserted");
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
	
	public boolean tdsTotalAInsert(TDSTotalABean tdsTotalABean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsTotalABean);
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

	
	public boolean tdsTotalBInsert(TDSTotalBBean bBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(bBean);
			 System.out.println("inserted");
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
	
	public boolean tdsTotalCInsert(TDSTotalCBean cBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(cBean);
			 System.out.println("inserted");
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
	
	public boolean tdsTotalDInsert(TDSTotalDBean dBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(dBean);
			 System.out.println("inserted");
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
	
	public boolean tdsTotalEInsert(TDSTotalEBean eBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(eBean);
			 System.out.println("inserted");
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
	
	public boolean tdsTotalFInsert(TDSTotalFBean fBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(fBean);
			 System.out.println("inserted");
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
	
	public boolean tdsTaxInsert(TDSTaxBean tdsTaxBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsTaxBean);
			 System.out.println("In TDSTaxBean Data inserted");
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
	
	public boolean tdsHrInsert(TDSHrBean tdsHrBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsHrBean);
			 System.out.println("inserted");
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
	
	public boolean tdsHrTotalAInsert(TDSHrTotalABean hraBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(hraBean);
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

	
	public boolean tdsHrTotalBInsert(TDSHrTotalBBean hrbBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(hrbBean);
			 System.out.println("inserted");
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
	
	public boolean tdsHrTotalCInsert(TDSHrTotalCBean hrcBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(hrcBean);
			 System.out.println("inserted");
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
	
	public boolean tdsHrTotalDInsert(TDSHrTotalDBean hrdBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(hrdBean);
			 System.out.println("inserted");
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
	
	public boolean tdsHrTotalEInsert(TDSHrTotalEBean hreBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(hreBean);
			 System.out.println("inserted");
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
	
	public boolean tdsHrTotalFInsert(TDSHrTotalFBean hrfBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(hrfBean);
			 System.out.println("inserted");
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
	
	public boolean tdsDocumentInsert(TDSDocumentUploadBean tdsDocumentUploadBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsDocumentUploadBean);
			 System.out.println("inserted");
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
	
	public boolean tdsHistoryInsert(TDSHistoryBean tdsHistoryBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsHistoryBean);
			 System.out.println("inserted");
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
	
	public boolean tdsHrHistoryInsert(TDSHrHistoryBean tdsHrHistoryBean)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(tdsHrHistoryBean);
			 System.out.println("inserted");
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
