/*Name : Bhoomi Patel;
Action : Bean for machine_system_report_tbl */

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
@Table(name="machine_system_report_tbl")
public class MachineSystemReportBean implements Serializable {

	
	private int machine_system_report_id;
	private String description;
	private String company;
	private String type;
	private String capacity;
	private String sr_no;
	
	private MachineDetailBean machineDetailBean;
	
	public MachineSystemReportBean() {
		// TODO Auto-generated constructor stub
	}

	
	/*Parameterised Constructor for insertion*/
	public MachineSystemReportBean(String description, String company, String type, String capacity, String sr_no,
			MachineDetailBean machineDetailBean) {
		super();
		this.description = description;
		this.company = company;
		this.type = type;
		this.capacity = capacity;
		this.sr_no = sr_no;
		this.machineDetailBean = machineDetailBean;
	}

	// For update machine_system_report_tbl using constructor
	public MachineSystemReportBean(int machine_system_report_id, String description, String company, String type,
			String capacity, String sr_no, MachineDetailBean machineDetailBean) {
		super();
		this.machine_system_report_id = machine_system_report_id;
		this.description = description;
		this.company = company;
		this.type = type;
		this.capacity = capacity;
		this.sr_no = sr_no;
		this.machineDetailBean = machineDetailBean;
	}


	@Id 
	@Column(name="machine_system_report_id")
	@GeneratedValue
	public int getMachine_system_report_id() {
		return machine_system_report_id;
	}

	public void setMachine_system_report_id(int machine_system_report_id) {
		this.machine_system_report_id = machine_system_report_id;
	}

	
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Column(name="company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@Column(name="capacity")
	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	
	@Column(name="sr_no")
	public String getSr_no() {
		return sr_no;
	}

	public void setSr_no(String sr_no) {
		this.sr_no = sr_no;
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
