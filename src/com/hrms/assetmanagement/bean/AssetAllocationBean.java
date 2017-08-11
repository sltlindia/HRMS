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

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="asset_allocation_tbl")
public class AssetAllocationBean implements Serializable{

	private int asset_allocation_id;
	private String asset_sltl_sr_no;
	private String issue_date;
	private int quantity;
	private String status;
	private String remark;
	private String location;
	
	private StockMasterBean stockMasterBean;
	private EmployeeBean employeeBean;
	private SupplierSrNoBean supplierSrNoBean;
	
	public AssetAllocationBean() {
		// TODO Auto-generated constructor stub
	}


	
	//For Insert Of Data in to table using parameterised constructor
	
	public AssetAllocationBean(String asset_sltl_sr_no, String issue_date, int quantity, String status, String remark,
			String location, StockMasterBean stockMasterBean, EmployeeBean employeeBean,
			SupplierSrNoBean supplierSrNoBean) {
		super();
		this.asset_sltl_sr_no = asset_sltl_sr_no;
		this.issue_date = issue_date;
		this.quantity = quantity;
		this.status = status;
		this.remark = remark;
		this.location = location;
		this.stockMasterBean = stockMasterBean;
		this.employeeBean = employeeBean;
		this.supplierSrNoBean = supplierSrNoBean;
	}


	@Id 
	@Column(name="asset_allocation_id")
	@GeneratedValue
	public int getAsset_allocation_id() {
		return asset_allocation_id;
	}

	public void setAsset_allocation_id(int asset_allocation_id) {
		this.asset_allocation_id = asset_allocation_id;
	}

	
	@Column(name="asset_sltl_sr_no")
	public String getAsset_sltl_sr_no() {
		return asset_sltl_sr_no;
	}

	public void setAsset_sltl_sr_no(String asset_sltl_sr_no) {
		this.asset_sltl_sr_no = asset_sltl_sr_no;
	}

	
	@Column(name="issue_date")
	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Column(name="location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}




	@ManyToOne
	@JoinColumn(name="stock_master_id")
	public StockMasterBean getStockMasterBean() {
		return stockMasterBean;
	}

	public void setStockMasterBean(StockMasterBean stockMasterBean) {
		this.stockMasterBean = stockMasterBean;
	}

	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}


	@ManyToOne
	@JoinColumn(name="supplier_sr_no_id")
	public SupplierSrNoBean getSupplierSrNoBean() {
		return supplierSrNoBean;
	}


	public void setSupplierSrNoBean(SupplierSrNoBean supplierSrNoBean) {
		this.supplierSrNoBean = supplierSrNoBean;
	}
	
	
}
