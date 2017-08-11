package com.hrms.assetmanagement.dao;

/*Name : Bhoomi Patel;
Action : Update methods */

import javax.mail.internet.NewsAddress;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.assetmanagement.bean.AssetAllocationBean;
import com.hrms.assetmanagement.bean.AssetConfigurationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.bean.MachineCheckPointsBean;
import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.MachineSystemReportBean;
import com.hrms.assetmanagement.bean.StockMasterBean;
import com.hrms.assetmanagement.bean.SupplierSrNoBean;
import com.hrms.lms.bean.IntervieweeBean;
import com.hrms.pms.util.HibernateUtil;

public class AllUpdateAssetDAO {

	/*Update data from asset_master_tbl by using assetMasterBean*/
	
	public boolean assetUpdate(AssetMasterBean assetMasterBean){
		 Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(assetMasterBean);
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
	
	
	/*Update quantity in stock_master_tbl by stock_master_id*/
	
	public boolean stockQuantityUpdate(int stock_master_id, int quantity)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 StockMasterBean stockMasterBean = new StockMasterBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update StockMasterBean set quantity =:q where stock_master_id = :id");
			 query.setInteger("q" ,quantity);
			 query.setInteger("id",stock_master_id);
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

	
	/*Update status in supplier_sr_no_tbl by supplier_sr_no_id*/
	
	public boolean supplierSrNoStatusUpdate(int stock_master_id, String status)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 SupplierSrNoBean supplierSrNoBean = new SupplierSrNoBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update SupplierSrNoBean set status =:s where supplier_sr_no_id = :id");
			 query.setString("s" ,status);
			 query.setInteger("id",stock_master_id);
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
	
	
	/*Update employee_master_id, issue_date, location in asset_allocation_tbl by asset_allocation_id*/
	
	public boolean assetTransferDetailUpdate(int asset_allocation_id, int employee_master_id, String issue_date, String location)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 AssetAllocationBean assetAllocationBean = new AssetAllocationBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AssetAllocationBean set employeeBean =:e, issue_date=:i, location =:l where asset_allocation_id = :id");
			 query.setInteger("e" ,employee_master_id);
			 query.setString("i", issue_date);
			 query.setString("l", location);
			 query.setInteger("id",asset_allocation_id);
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
	
	
	/*Update status in asset_allocation_tbl by asset_allocation_id*/
	
	public boolean assetAllocationStatusUpdate(int asset_allocation_id, String status)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 AssetAllocationBean assetAllocationBean = new AssetAllocationBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AssetAllocationBean set status =:s where asset_allocation_id = :id");
			 query.setString("s" ,status);
			 query.setInteger("id",asset_allocation_id);
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
	
	
	/*Update quantity in stock_master_tbl by stock_master_id*/
	
	public boolean assetQuantityUpdate(int stock_master_id, int quantity)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 StockMasterBean stockMasterBean = new StockMasterBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update StockMasterBean set quantity =:q where stock_master_id = :id");
			 query.setInteger("q" ,quantity);
			 query.setInteger("id",stock_master_id);
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
	
	
	/*Update asset_configuration in asset_configuration_tbl by asset_configuration_id*/
	
	public boolean configUpdate(int config_id, String config_name)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 AssetConfigurationBean assetConfigurationBean = new AssetConfigurationBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AssetConfigurationBean set asset_configuration =:ac where asset_configuration_id = :id");
			 query.setString("ac", config_name);
			 query.setInteger("id",config_id);
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
	
	
	/*Update asset_name in asset_master_tbl by asset_master_id*/
	
	public boolean assetUpdate(int asset_id, String asset_name)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 AssetMasterBean assetMasterBean = new AssetMasterBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update AssetMasterBean set asset_name =:an where asset_master_id = :id");
			 query.setString("an", asset_name);
			 query.setInteger("id",asset_id);
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
	
	/*Update status in supplier_sr_no_tbl by supplier_sr_no_id*/
	
	public boolean statusUpdate(int supplier_sr_no_id, String status)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 SupplierSrNoBean supplierSrNoBean = new SupplierSrNoBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update SupplierSrNoBean set status =:s where supplier_sr_no_id = :id");
			 query.setString("s", status);
			 query.setInteger("id",supplier_sr_no_id);
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
	
	
	/*Update fixed_asset_or_not in stock_master_tbl by stock_master_id*/
	
	public boolean fixedToStockUpdate(int fixed_asset_or_not, int stock_master_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 StockMasterBean stockMasterBean = new StockMasterBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update StockMasterBean set fixed_asset_or_not =:f where stock_master_id = :id");
			 query.setInteger("f",fixed_asset_or_not);
			 query.setInteger("id",stock_master_id);
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
	
	
	
	/*Update machine Detail in machine_detail_tbl by machine_detail_id*/
	
	public boolean machinerDetailUpdate(int checked_by,int authorised_by,int recieved_by, int recieved_authorised_by, String checked_by_date, String authorised_by_date, String recieved_by_date, String recieved_authorised_by_date,int machine_detail_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 MachineDetailBean machineDetailBean = new MachineDetailBean();
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("update MachineDetailBean set checked_by =:cb, authorised_by =:ab,checked_by_date =:cbd, authoised_by_date =:abd, received_by =:rb, received_by_date =:rbd, received_authorised_by =:rab, received_authorised_by_date =:rabd where machine_detail_id = :id");
			 query.setInteger("cb",checked_by);
			 query.setInteger("ab",authorised_by);
			 query.setInteger("rb",recieved_by);
			 query.setInteger("rab",recieved_authorised_by);
			 query.setString("cbd",checked_by_date);
			 query.setString("abd",authorised_by_date);
			 query.setString("rbd",recieved_by_date);
			 query.setString("rabd",recieved_authorised_by_date);
			 query.setInteger("id",machine_detail_id);
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
	
	/*Update machine Detail in machine_detail_tbl using MachineDetailBean*/
	
	public boolean allMachinerDetailUpdate(MachineDetailBean machineDetailBean)
	{
		Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(machineDetailBean);
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
	
	
/*Update machine check point Detail in machine_check_point_tbl using MachineCheckPointsBean*/
	
	public boolean updateCheckPoints(MachineCheckPointsBean machineCheckPointsBean)
	{
		Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(machineCheckPointsBean);
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
	
	
/*Update machine system report Detail in machine_system_report_tbl using MachineSystemReportBean*/
	
	public boolean updateMachineSystemReportDetail(MachineSystemReportBean machineSystemReportBean)
	{
		Session session = HibernateUtil.openSession();
		int id =0;
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.update(machineSystemReportBean);
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
