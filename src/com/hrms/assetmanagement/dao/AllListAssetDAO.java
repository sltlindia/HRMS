package com.hrms.assetmanagement.dao;

/*Name : Bhoomi Patel;
Action : methods to get list from table*/


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrms.pms.bean.ProjectDesignHeadBean;
import com.hrms.pms.util.HibernateUtil;
import com.hrms.assetmanagement.bean.AssetAllocationBean;
import com.hrms.assetmanagement.bean.AssetConfigurationBean;
import com.hrms.assetmanagement.bean.AssetMasterBean;
import com.hrms.assetmanagement.bean.MachineCheckPointsBean;
import com.hrms.assetmanagement.bean.MachineCheckPointsDefaultBean;
import com.hrms.assetmanagement.bean.MachineDetailBean;
import com.hrms.assetmanagement.bean.MachineSystemDefaultBean;
import com.hrms.assetmanagement.bean.MachineSystemReportBean;
import com.hrms.assetmanagement.bean.StockConfigurationBean;
import com.hrms.assetmanagement.bean.StockMasterBean;
import com.hrms.assetmanagement.bean.SupplierSrNoBean;


public class AllListAssetDAO {

	/*Get List from asset_master_tbl by asset_master_id in descending order*/
	
	public List<AssetMasterBean> getListOfAssets(){
	    List<AssetMasterBean> listOfAssets = new ArrayList<AssetMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAssets = session.createQuery("FROM AssetMasterBean order by asset_master_id DESC").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAssets;
	    
	}
	
	
	/*Get List from asset_master_tbl by asset_master_id*/
	
	public List<AssetMasterBean> getListOfAssetsById(int asset_id){
	    List<AssetMasterBean> listOfAssets = new ArrayList<AssetMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAssets = session.createQuery("FROM AssetMasterBean where asset_master_id = '"+asset_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAssets;
	    
	}
	
	
	/*Get List from asset_configuration_tbl by asset_master_id*/
	
	public List<AssetConfigurationBean> getListOfAssetConfiguration(int asset_id){
	    List<AssetConfigurationBean> listOfAssetConfiguration = new ArrayList<AssetConfigurationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAssetConfiguration = session.createQuery("FROM AssetConfigurationBean where assetMasterBean = '"+asset_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAssetConfiguration;
	    
	}

	
	/*Get List from stock_master_tbl by fixed_asset_or_not*/
	
	public List<StockMasterBean> getListOfStockMaster(){
	    List<StockMasterBean> listOfStockMaster = new ArrayList<StockMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfStockMaster = session.createQuery("FROM StockMasterBean where fixed_asset_or_not = 0 ").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfStockMaster;
	    
	}
	
	
	/*Get List from stock_master_tbl by fixed_asset_or_not*/
	
	public List<StockMasterBean> getListOfFixedStockMaster(){
	    List<StockMasterBean> listOfStockMaster = new ArrayList<StockMasterBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfStockMaster = session.createQuery("FROM StockMasterBean where fixed_asset_or_not = 1").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfStockMaster;
	    
	}
	
	
	/*Get List from stock_master_tbl by stock_master_id*/
	
	public StockMasterBean getListOfStockMasterById(int stock_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		StockMasterBean stockMasterBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("FROM StockMasterBean where stock_master_id = '"+stock_id+"'");
		    stockMasterBean = (StockMasterBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return stockMasterBean;
		}
	
	
	/*Get List from stock_configuration_tbl by fixed_asset_id*/
	
	public List<StockConfigurationBean> getListOfFixStockConfiguration(int fix_id){
	    List<StockConfigurationBean> listOfStockConfiguration= new ArrayList<StockConfigurationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfStockConfiguration = session.createQuery("FROM StockConfigurationBean where fixedAssetBean = '"+fix_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfStockConfiguration;
	    
	}

	/*Get List from stock_configuration_tbl by stock_master_id*/
	
	public List<StockConfigurationBean> getListOfStockConfiguration(int stock_master_id){
	    List<StockConfigurationBean> listOfStockConfiguration= new ArrayList<StockConfigurationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfStockConfiguration = session.createQuery("FROM StockConfigurationBean where stockMasterBean = '"+stock_master_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfStockConfiguration;
	    
	}
	
	/*Get List from asset_allocation_tbl by status and supplier_sr_no's status*/
	
	public List<AssetAllocationBean> getListOfAssetAllocation(){
	    List<AssetAllocationBean> listOfAssetAllocation = new ArrayList<AssetAllocationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAssetAllocation = session.createQuery("FROM AssetAllocationBean where status != 'Return' and supplierSrNoBean.status != 'Scrap' ").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAssetAllocation;
	    
	}
	
	
	/*Get List from asset_allocation_tbl by employee_master_id*/
	
	public List<AssetAllocationBean> getListOfAssetAllocationByEmployee(int employee_master_id){
	    List<AssetAllocationBean> listOfAssetAllocation = new ArrayList<AssetAllocationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfAssetAllocation = session.createQuery("FROM AssetAllocationBean where employeeBean = '"+employee_master_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfAssetAllocation;
	    
	}
	
	
	/*Get List from asset_allocation_tbl by asset_allocation_id*/
	
	public AssetAllocationBean getListOfAssetAllocationById(int asset_allocation_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		AssetAllocationBean assetAllocationBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("FROM AssetAllocationBean where asset_allocation_id = '"+asset_allocation_id+"'");
		    assetAllocationBean = (AssetAllocationBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return assetAllocationBean;
		}
	
	
	/*Get List from stock_master_tbl by stock_master_id*/
	
	public StockMasterBean getListOfStockById(int stock_master_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		StockMasterBean stockMasterBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("FROM StockMasterBean where stock_master_id = '"+stock_master_id+"'");
		    stockMasterBean = (StockMasterBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return stockMasterBean;
		}
	
	
	
	/*Get List from supplier_sr_no_tbl by stock_master_id and status allocated*/
	
	public List<SupplierSrNoBean> getListOfSupplierSrNo(int stock_master_id){
	    List<SupplierSrNoBean> listOfSupplierSrNo = new ArrayList<SupplierSrNoBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSupplierSrNo = session.createQuery("FROM SupplierSrNoBean where stockMasterBean = '"+stock_master_id+"' and status != 'Allocated'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSupplierSrNo;
	    
	}
	
	
	/*Get List from supplier_sr_no_tbl by stock_master_id*/
	
	public List<SupplierSrNoBean> getListOfAllSupplierSrNo(int stock_master_id){
	    List<SupplierSrNoBean> listOfSupplierSrNo = new ArrayList<SupplierSrNoBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSupplierSrNo = session.createQuery("FROM SupplierSrNoBean where stockMasterBean = '"+stock_master_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSupplierSrNo;
	}	 
	
	
	
	/*Get List from machine_detail_tbl by machine_detail_id*/
	
	public MachineDetailBean getMachineDetail(int machine_detail_id) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		MachineDetailBean machineDetailBean = null;
		try {
		    tx = session.getTransaction();
		    tx.begin();
		    Query query = session.createQuery("FROM MachineDetailBean where machine_detail_id = '"+machine_detail_id+"'");
		    machineDetailBean = (MachineDetailBean)query.uniqueResult();
		    tx.commit();
		} catch (Exception e) {
		    if (tx != null) {
		        tx.rollback();
		    }
		    e.printStackTrace();
		} finally {
		    session.close();
		}
		return machineDetailBean;
		}
	
	
	/*
	 * Date : 09-06-2017
	 * Get List from machine_detail_tbl for all data*/
		
	public List<MachineDetailBean> getListOfMachineDetail(){
		    List<MachineDetailBean> listOfMachineDetail = new ArrayList<MachineDetailBean>();
		    Session session = HibernateUtil.openSession();
		    Transaction tx = null;        
		    try {
		        tx = session.getTransaction();
		        tx.begin();
		        listOfMachineDetail = session.createQuery("FROM MachineDetailBean").list();
		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		    return listOfMachineDetail;
		}	 
	
		
	/*
	 * Date : 09-06-2017
	 * Get List from machine_check_points_tbl by machine_detail_id*/
	
	public List<MachineCheckPointsBean> getListOfMachineCheckPoints(int machine_detail_id){
	    List<MachineCheckPointsBean> listOfMachineCheckPoints = new ArrayList<MachineCheckPointsBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfMachineCheckPoints = session.createQuery("FROM MachineCheckPointsBean where machineDetailBean='"+machine_detail_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfMachineCheckPoints;
	}	 
		
	
	/*
	 * Date : 09-06-2017
	 * Get List from machine_system_report_tbl by machine_detail_id*/
	
	public List<MachineSystemReportBean> getListOfSystemReport(int machine_detail_id){
	    List<MachineSystemReportBean> listOfSystemReport = new ArrayList<MachineSystemReportBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfSystemReport = session.createQuery("FROM MachineSystemReportBean where machineDetailBean='"+machine_detail_id+"'").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfSystemReport;
	}	
	
	
	/*
	 * Date : 09-06-2017
	 * Get List from machine_check_points_default_tbl*/
	
	public List<MachineCheckPointsDefaultBean> getListOfMachineCheckPointsDefault(){
	    List<MachineCheckPointsDefaultBean> listOfMachineCheckPointsDefault = new ArrayList<MachineCheckPointsDefaultBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfMachineCheckPointsDefault = session.createQuery("FROM MachineCheckPointsDefaultBean ").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfMachineCheckPointsDefault;
	}	
	
	
	/*
	 * Date : 09-06-2017
	 * Get List from machine_system_default_tbl*/
	
	public List<MachineSystemDefaultBean> getListOfMachineSystemDefault(){
	    List<MachineSystemDefaultBean> listOfMachineSystemDefault = new ArrayList<MachineSystemDefaultBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfMachineSystemDefault = session.createQuery("FROM MachineSystemDefaultBean ").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfMachineSystemDefault;
	}	
	
	

	/*
	 * Date : 12-06-2017
	 * Get List of scrap assets*/
	
	public List<AssetAllocationBean> getListOfScrapAsset(){
	    List<AssetAllocationBean> listOfMachineSystemDefault = new ArrayList<AssetAllocationBean>();
	    Session session = HibernateUtil.openSession();
	    Transaction tx = null;        
	    try {
	        tx = session.getTransaction();
	        tx.begin();
	        listOfMachineSystemDefault = session.createQuery("FROM AssetAllocationBean where supplierSrNoBean.status = 'Scrap' group by supplierSrNoBean	").list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listOfMachineSystemDefault;
	
}

}
