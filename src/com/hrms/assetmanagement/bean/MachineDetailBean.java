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
@Table(name="machine_detail_tbl")
public class MachineDetailBean implements Serializable{

	private int machine_detail_id;
	private String machine_type;
	private String party_name;
	private String machine_no;
	private String project_no;
	private String place;
	private String sltl_sr_no;
	private String pc_sr_no;
	private int checked_by;
	private String checked_by_date;
	private int authorised_by;
	private String authoised_by_date;
	private int received_by;
	private String received_by_date;
	private int received_authorised_by;
	private String received_authorised_by_date;
	private String system_type;
	private String supply;
	
	
	public MachineDetailBean() {
		// TODO Auto-generated constructor stub
	}

	//For Insert Of Data in to table using parameterised constructor
	public MachineDetailBean(String machine_type, String party_name, String machine_no, String project_no, String place,
			String sltl_sr_no, String pc_sr_no, String system_type, String supply) {
		super();
		this.machine_type = machine_type;
		this.party_name = party_name;
		this.machine_no = machine_no;
		this.project_no = project_no;
		this.place = place;
		this.sltl_sr_no = sltl_sr_no;
		this.pc_sr_no = pc_sr_no;
		this.system_type = system_type;
		this.supply = supply;
	}

	

	

	public MachineDetailBean(int machine_detail_id, String machine_type, String party_name, String machine_no,
			String project_no, String place, String sltl_sr_no, String pc_sr_no, int checked_by, String checked_by_date,
			int authorised_by, String authoised_by_date, int received_by, String received_by_date,
			int received_authorised_by, String received_authorised_by_date, String system_type, String supply) {
		super();
		this.machine_detail_id = machine_detail_id;
		this.machine_type = machine_type;
		this.party_name = party_name;
		this.machine_no = machine_no;
		this.project_no = project_no;
		this.place = place;
		this.sltl_sr_no = sltl_sr_no;
		this.pc_sr_no = pc_sr_no;
		this.checked_by = checked_by;
		this.checked_by_date = checked_by_date;
		this.authorised_by = authorised_by;
		this.authoised_by_date = authoised_by_date;
		this.received_by = received_by;
		this.received_by_date = received_by_date;
		this.received_authorised_by = received_authorised_by;
		this.received_authorised_by_date = received_authorised_by_date;
		this.system_type = system_type;
		this.supply = supply;
	}

	@Id 
	@Column(name="machine_detail_id")
	@GeneratedValue
	public int getMachine_detail_id() {
		return machine_detail_id;
	}


	public void setMachine_detail_id(int machine_detail_id) {
		this.machine_detail_id = machine_detail_id;
	}


	@Column(name="machine_type")
	public String getMachine_type() {
		return machine_type;
	}


	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}


	@Column(name="party_name")
	public String getParty_name() {
		return party_name;
	}


	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}


	@Column(name="machine_no")
	public String getMachine_no() {
		return machine_no;
	}


	public void setMachine_no(String machine_no) {
		this.machine_no = machine_no;
	}


	@Column(name="project_no")
	public String getProject_no() {
		return project_no;
	}


	public void setProject_no(String project_no) {
		this.project_no = project_no;
	}


	@Column(name="place")
	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	@Column(name="sltl_sr_no")
	public String getSltl_sr_no() {
		return sltl_sr_no;
	}


	public void setSltl_sr_no(String sltl_sr_no) {
		this.sltl_sr_no = sltl_sr_no;
	}


	@Column(name="pc_sr_no")
	public String getPc_sr_no() {
		return pc_sr_no;
	}

	public void setPc_sr_no(String pc_sr_no) {
		this.pc_sr_no = pc_sr_no;
	}


	@Column(name="checked_by")
	public int getChecked_by() {
		return checked_by;
	}


	public void setChecked_by(int checked_by) {
		this.checked_by = checked_by;
	}


	@Column(name="checked_by_date")
	public String getChecked_by_date() {
		return checked_by_date;
	}


	public void setChecked_by_date(String checked_by_date) {
		this.checked_by_date = checked_by_date;
	}


	@Column(name="authorised_by")
	public int getAuthorised_by() {
		return authorised_by;
	}


	public void setAuthorised_by(int authorised_by) {
		this.authorised_by = authorised_by;
	}


	@Column(name="authoised_by_date")
	public String getAuthoised_by_date() {
		return authoised_by_date;
	}


	public void setAuthoised_by_date(String authoised_by_date) {
		this.authoised_by_date = authoised_by_date;
	}


	@Column(name="received_by")
	public int getReceived_by() {
		return received_by;
	}


	public void setReceived_by(int received_by) {
		this.received_by = received_by;
	}


	@Column(name="received_by_date")
	public String getReceived_by_date() {
		return received_by_date;
	}


	public void setReceived_by_date(String received_by_date) {
		this.received_by_date = received_by_date;
	}


	@Column(name="received_authorised_by")
	public int getReceived_authorised_by() {
		return received_authorised_by;
	}


	public void setReceived_authorised_by(int received_authorised_by) {
		this.received_authorised_by = received_authorised_by;
	}


	@Column(name="received_authorised_by_date")
	public String getReceived_authorised_by_date() {
		return received_authorised_by_date;
	}


	public void setReceived_authorised_by_date(String received_authorised_by_date) {
		this.received_authorised_by_date = received_authorised_by_date;
	}


	@Column(name="system_type")
	public String getSystem_type() {
		return system_type;
	}


	public void setSystem_type(String system_type) {
		this.system_type = system_type;
	}


	@Column(name="supply")
	public String getSupply() {
		return supply;
	}


	public void setSupply(String supply) {
		this.supply = supply;
	}


	
	
	
}
