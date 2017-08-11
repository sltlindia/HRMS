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
@Table(name="supplier_sr_no_tbl")
public class SupplierSrNoBean implements Serializable{

	private int supplier_sr_no_id;
	private String supplier_sr_no;
	private String status; 
	
	private StockMasterBean stockMasterBean;

	public SupplierSrNoBean() {
		// TODO Auto-generated constructor stub
	}
	
	//For Insert Of Data in to table using parameterised constructor
	public SupplierSrNoBean(String supplier_sr_no, String status, StockMasterBean stockMasterBean) {
		super();
		this.supplier_sr_no = supplier_sr_no;
		this.status = status;
		this.stockMasterBean = stockMasterBean;
	}
	
	
	
	@Id 
	@Column(name="supplier_sr_no_id")
	@GeneratedValue
	public int getSupplier_sr_no_id() {
		return supplier_sr_no_id;
	}

	public void setSupplier_sr_no_id(int supplier_sr_no_id) {
		this.supplier_sr_no_id = supplier_sr_no_id;
	}

	
	@Column(name="supplier_sr_no")
	public String getSupplier_sr_no() {
		return supplier_sr_no;
	}

	public void setSupplier_sr_no(String supplier_sr_no) {
		this.supplier_sr_no = supplier_sr_no;
	}

	
	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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