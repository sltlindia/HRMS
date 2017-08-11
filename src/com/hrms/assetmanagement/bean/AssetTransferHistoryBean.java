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
@Table(name="asset_transfer_history_tbl")
public class AssetTransferHistoryBean implements Serializable{

	private int asset_transfer_history_id;
	private String issue_date;
	private String transfer_date;
	private int transfer_from;
	private String asset_transfer_from_location;
	private String asset_transfer_to_location;
	
	private EmployeeBean employeeBean;
	private AssetAllocationBean assetAllocationBean;

	
	//For Insert Of Data in to table using parameterised constructor
	
	public AssetTransferHistoryBean(String issue_date, String transfer_date, int transfer_from,
			String asset_transfer_from_location, String asset_transfer_to_location, EmployeeBean employeeBean,
			AssetAllocationBean assetAllocationBean) {
		super();
		this.issue_date = issue_date;
		this.transfer_date = transfer_date;
		this.transfer_from = transfer_from;
		this.asset_transfer_from_location = asset_transfer_from_location;
		this.asset_transfer_to_location = asset_transfer_to_location;
		this.employeeBean = employeeBean;
		this.assetAllocationBean = assetAllocationBean;
	}
	
	

	@Id 
	@Column(name="asset_transfer_history_id")
	@GeneratedValue
	public int getAsset_transfer_history_id() {
		return asset_transfer_history_id;
	}

	public void setAsset_transfer_history_id(int asset_transfer_history_id) {
		this.asset_transfer_history_id = asset_transfer_history_id;
	}

	
	@Column(name="issue_date")
	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	
	@Column(name="transfer_date")
	public String getTransfer_date() {
		return transfer_date;
	}

	public void setTransfer_date(String transfer_date) {
		this.transfer_date = transfer_date;
	}

	
	@Column(name="transfer_from")
	public int getTransfer_from() {
		return transfer_from;
	}


	public void setTransfer_from(int transfer_from) {
		this.transfer_from = transfer_from;
	}
	
	
	@Column(name="asset_transfer_from_location")
	public String getAsset_transfer_from_location() {
		return asset_transfer_from_location;
	}

	public void setAsset_transfer_from_location(String asset_transfer_from_location) {
		this.asset_transfer_from_location = asset_transfer_from_location;
	}

	
	@Column(name="asset_transfer_to_location")
	public String getAsset_transfer_to_location() {
		return asset_transfer_to_location;
	}

	public void setAsset_transfer_to_location(String asset_transfer_to_location) {
		this.asset_transfer_to_location = asset_transfer_to_location;
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
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
	
}
