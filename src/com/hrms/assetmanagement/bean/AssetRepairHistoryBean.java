package com.hrms.assetmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asset_repair_history_tbl")
public class AssetRepairHistoryBean implements Serializable{

	private int asset_repair_history_id;
	private String repair_date;
	private String repairing_cost;
	private String store;
	private String remark;
	
	private AssetAllocationBean assetAllocationBean;
	private AssetMasterBean assetMasterBean;
	
	
	public AssetRepairHistoryBean() {
		// TODO Auto-generated constructor stub
	}


	public AssetRepairHistoryBean(String repair_date, String repairing_cost, String store, String remark,
			AssetAllocationBean assetAllocationBean, AssetMasterBean assetMasterBean) {
		super();
		this.repair_date = repair_date;
		this.repairing_cost = repairing_cost;
		this.store = store;
		this.remark = remark;
		this.assetAllocationBean = assetAllocationBean;
		this.assetMasterBean = assetMasterBean;
	}



	@Id 
	@Column(name="asset_repair_history_id")
	@GeneratedValue
	public int getAsset_repair_history_id() {
		return asset_repair_history_id;
	}


	public void setAsset_repair_history_id(int asset_repair_history_id) {
		this.asset_repair_history_id = asset_repair_history_id;
	}


	@Column(name="repair_date")
	public String getRepair_date() {
		return repair_date;
	}


	public void setRepair_date(String repair_date) {
		this.repair_date = repair_date;
	}


	@Column(name="repairing_cost")
	public String getRepairing_cost() {
		return repairing_cost;
	}


	public void setRepairing_cost(String repairing_cost) {
		this.repairing_cost = repairing_cost;
	}


	@Column(name="store")
	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@ManyToOne
	@JoinColumn(name="asset_allocation_id")
	public AssetAllocationBean getAssetAllocationBean() {
		return assetAllocationBean;
	}


	public void setAssetAllocationBean(AssetAllocationBean assetAllocationBean) {
		this.assetAllocationBean = assetAllocationBean;
	}


	
	@ManyToOne
	@JoinColumn(name="asset_master_id")
	public AssetMasterBean getAssetMasterBean() {
		return assetMasterBean;
	}


	public void setAssetMasterBean(AssetMasterBean assetMasterBean) {
		this.assetMasterBean = assetMasterBean;
	}
	
	
	
}
