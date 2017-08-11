package com.hrms.assetmanagement.bean;



/*Name : Akash Ramani
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
@Table(name="machine_check_points_tbl")
public class MachineCheckPointsBean implements Serializable{

	private int machine_check_points_id;
	private String description;
	private String status;
	private String remark;

	private MachineDetailBean machineDetailBean;
	
	public MachineCheckPointsBean() {
		// TODO Auto-generated constructor stub
	}

	//For Insert Of Data in to table using parameterised constructor
	public MachineCheckPointsBean(String description, String status, String remark, MachineDetailBean machineDetailBean) {
		super();
		this.description = description;
		this.status = status;
		this.remark = remark;
		this.machineDetailBean = machineDetailBean;
	}

	//For Update Of Data in to table using parameterised constructor
	public MachineCheckPointsBean(int machine_check_points_id, String description, String status, String remark,
			MachineDetailBean machineDetailBean) {
		super();
		this.machine_check_points_id = machine_check_points_id;
		this.description = description;
		this.status = status;
		this.remark = remark;
		this.machineDetailBean = machineDetailBean;
	}

	@Id 
	@Column(name="machine_check_points_id")
	@GeneratedValue
	public int getMachine_check_points_id() {
		return machine_check_points_id;
	}

	public void setMachine_check_points_id(int machine_check_points_id) {
		this.machine_check_points_id = machine_check_points_id;
	}

	
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@ManyToOne
	@JoinColumn(name="machine_detail_id")
	public MachineDetailBean getMachineDetailBean() {
		return machineDetailBean;
	}

	public void setMachineDetailBean(MachineDetailBean machineDetailBean) {
		this.machineDetailBean = machineDetailBean;
	}
	
	
	
	
	
	
	
}
