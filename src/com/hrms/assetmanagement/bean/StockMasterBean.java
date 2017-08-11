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
@Table(name="stock_master_tbl")
public class StockMasterBean implements Serializable{

	private int stock_master_id;
	private String make;
	private String quantity;
	private String date;
	private String store_name;
	private String model_no;
	private String life_time;
	private int fixed_asset_or_not;
	
	private AssetMasterBean assetMasterBean;
	
	
	public StockMasterBean() {
		// TODO Auto-generated constructor stub
	}

	//For Insert Of Data in to table using parameterised constructor
	public StockMasterBean(String make, String quantity, String date, String store_name, String model_no,
			String life_time, int fixed_asset_or_not, AssetMasterBean assetMasterBean) {
		super();
		this.make = make;
		this.quantity = quantity;
		this.date = date;
		this.store_name = store_name;
		this.model_no = model_no;
		this.life_time = life_time;
		this.fixed_asset_or_not = fixed_asset_or_not;
		this.assetMasterBean = assetMasterBean;
	}



	@Id 
	@Column(name="stock_master_id")
	@GeneratedValue
	public int getStock_master_id() {
		return stock_master_id;
	}

	public void setStock_master_id(int stock_master_id) {
		this.stock_master_id = stock_master_id;
	}


	@Column(name="make")
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}


	@Column(name="quantity")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	@Column(name="date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name="model_no")
	public String getModel_no() {
		return model_no;
	}


	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	
	@Column(name="life_time")
	public String getLife_time() {
		return life_time;
	}

	public void setLife_time(String life_time) {
		this.life_time = life_time;
	}


	@Column(name="store_name")
	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	

	@Column(name="fixed_asset_or_not")
	public int getFixed_asset_or_not() {
		return fixed_asset_or_not;
	}

	public void setFixed_asset_or_not(int fixed_asset_or_not) {
		this.fixed_asset_or_not = fixed_asset_or_not;
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
