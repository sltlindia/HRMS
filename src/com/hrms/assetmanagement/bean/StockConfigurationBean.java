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
@Table(name="stock_configuration_detail_tbl")
public class StockConfigurationBean implements Serializable {

	private int stock_configuration_detail_id;
	private String stock_configuration_detail;

	private AssetConfigurationBean assetConfigurationBean;
	private StockMasterBean stockMasterBean;
	
	
	public StockConfigurationBean() {
		// TODO Auto-generated constructor stub
	}

	//For Insert Of Data in to table using parameterised constructor
	public StockConfigurationBean(String stock_configuration_detail, AssetConfigurationBean assetConfigurationBean,
			StockMasterBean stockMasterBean) {
		super();
		this.stock_configuration_detail = stock_configuration_detail;
		this.assetConfigurationBean = assetConfigurationBean;
		this.stockMasterBean = stockMasterBean;
	}

	@Id 
	@Column(name="stock_configuration_detail_id")
	@GeneratedValue
	public int getStock_configuration_detail_id() {
		return stock_configuration_detail_id;
	}

	public void setStock_configuration_detail_id(int stock_configuration_detail_id) {
		this.stock_configuration_detail_id = stock_configuration_detail_id;
	}


	@Column(name="stock_configuration_detail")
	public String getStock_configuration_detail() {
		return stock_configuration_detail;
	}

	public void setStock_configuration_detail(String stock_configuration_detail) {
		this.stock_configuration_detail = stock_configuration_detail;
	}


	@ManyToOne
	@JoinColumn(name="asset_configuration_id")
	public AssetConfigurationBean getAssetConfigurationBean() {
		return assetConfigurationBean;
	}

	public void setAssetConfigurationBean(AssetConfigurationBean assetConfigurationBean) {
		this.assetConfigurationBean = assetConfigurationBean;
	}


	@ManyToOne
	@JoinColumn(name="stock_master_id")
	public StockMasterBean getStockMasterBean() {
		return stockMasterBean;
	}

	public void setStockMasterBean(StockMasterBean stockMasterBean) {
		this.stockMasterBean = stockMasterBean;
	}
	
	
	
	
	
}
