package com.hrms.assetmanagement.bean;

/*Name : Bhoomi Patel
Action : For Connection Of asset_allocation_tbl*/
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset_master_tbl")
public class AssetMasterBean implements Serializable{

	
	
	private int asset_master_id;
	private String asset_name;
	
	public AssetMasterBean() {
		// TODO Auto-generated constructor stub
	}

	
	
	//For Insert Of Data in to table using parameterised constructor
	public AssetMasterBean(String asset_name) {
		super();
		this.asset_name = asset_name;
	}
	
	
	//For Update Data in to table using parameterised constructor
	public AssetMasterBean(int asset_master_id, String asset_name) {
		super();
		this.asset_master_id = asset_master_id;
		this.asset_name = asset_name;
	}

	@Id 
	@Column(name="asset_master_id")
	@GeneratedValue
	public int getAsset_master_id() {
		return asset_master_id;
	}

	public void setAsset_master_id(int asset_master_id) {
		this.asset_master_id = asset_master_id;
	}

	@Column(name="asset_name")
	public String getAsset_name() {
		return asset_name;
	}

	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	
	
	
}
