package com.hrms.assetmanagement.dao;

/*Name : Bhoomi Patel;
Action : Delete methods for data delete from table */

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.assetmanagement.bean.AssetConfigurationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.recruitement.bean.CompanyListBean;

public class AllDeleteAssetDAO {

	
	/*Delete data from asset_configuration_tbl by asset_configuration_id*/
	
	public boolean configDelete(int config_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AssetConfigurationBean assetConfigurationBean = new AssetConfigurationBean();
			 assetConfigurationBean.setAsset_configuration_id(config_id);
			 session.delete(assetConfigurationBean);
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
	
	/*Delete data from asset_master_tbl by asset_master_id*/
	
	public boolean assetDelete(int asset_id){
		boolean result = false;
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 AssetMasterBean assetMasterBean = new AssetMasterBean();
			 assetMasterBean.setAsset_master_id(asset_id);
			 session.delete(assetMasterBean);
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
	
	
	/*Delete data from asset_configuration_tbl by asset_master_id*/
	
	public boolean assetConfigurationDelete(int asset_id)
	{
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 
		 try {
			
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("delete AssetConfigurationBean where assetMasterBean = :amb");
			 query.setInteger("amb",asset_id);
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
	
	
	
}
