package com.hrms.assetmanagement.bean;

/*Name : Bhoomi Patel
Action : For Connection Of asset_allocation_tbl*/


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="asset_configuration_tbl")
public class AssetConfigurationBean implements Serializable{

	private int asset_configuration_id;
	private String asset_configuration;
	
	private AssetMasterBean assetMasterBean;
	
	public AssetConfigurationBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	//For Insert Of Data in to table using parameterised constructor
	
	public AssetConfigurationBean(String asset_configuration, AssetMasterBean assetMasterBean) {
		super();
		this.asset_configuration = asset_configuration;
		this.assetMasterBean = assetMasterBean;
	}


	@Id 
	@Column(name="asset_configuration_id")
	@GeneratedValue
	public int getAsset_configuration_id() {
		return asset_configuration_id;
	}

	public void setAsset_configuration_id(int asset_configuration_id) {
		this.asset_configuration_id = asset_configuration_id;
	}

	@Column(name="asset_configuration")
	public String getAsset_configuration() {
		return asset_configuration;
	}

	public void setAsset_configuration(String asset_configuration) {
		this.asset_configuration = asset_configuration;
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
