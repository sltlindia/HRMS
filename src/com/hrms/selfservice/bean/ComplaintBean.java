package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="complaint_tbl")
public class ComplaintBean {

	private int complaint_id;
	private String location;
	private int extension;
	private String description;
	private String date;
	private String correction;
	private String correction_datetime;
	private String status;
	private int verified_by;
	private String remarks;
	private String date_of_resolve;
	private int cartigeCount;
	
	
	
	private EmployeeBean employeeBean;
	private ProblemNatureBean problemNatureBean;
	
	
	
	public ComplaintBean(int complaint_id,
			String correction, String correction_datetime, String status, int verified_by, String remarks) {
		super();
		this.complaint_id = complaint_id;
		this.correction = correction;
		this.correction_datetime = correction_datetime;
		this.status = status;
		this.verified_by = verified_by;
		this.remarks = remarks;
	}
	
	public ComplaintBean(String location, int extension, String description, String date, String status, EmployeeBean employeeBean,
			ProblemNatureBean problemNatureBean,int cartigeCount) {
		super();
		this.location = location;
		this.extension = extension;
		this.description = description;
		this.date = date;
		this.status = status;
		this.employeeBean = employeeBean;
		this.problemNatureBean = problemNatureBean;
		this.cartigeCount = cartigeCount;
	}


	public ComplaintBean(int complaint_id, String location, int extension, String description, String date,
			String status, EmployeeBean employeeBean, ProblemNatureBean problemNatureBean,int cartigeCount) {
		super();
		this.complaint_id = complaint_id;
		this.location = location;
		this.extension = extension;
		this.description = description;
		this.date = date;
		this.status = status;
		this.employeeBean = employeeBean;
		this.problemNatureBean = problemNatureBean;
		this.cartigeCount = cartigeCount;
	}

	public ComplaintBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id 
    @Column(name="complaint_id")
    @GeneratedValue
	public int getComplaint_id() {
		return complaint_id;
	}
	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}
	@Column(name="location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name="extension")
	public int getExtension() {
		return extension;
	}
	public void setExtension(int extension) {
		this.extension = extension;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name="correction")
	public String getCorrection() {
		return correction;
	}
	public void setCorrection(String correction) {
		this.correction = correction;
	}
	@Column(name="correction_datetime")
	public String getCorrection_datetime() {
		return correction_datetime;
	}
	public void setCorrection_datetime(String correction_datetime) {
		this.correction_datetime = correction_datetime;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="verified_by")
	public int getVerified_by() {
		return verified_by;
	}


	public void setVerified_by(int verified_by) {
		this.verified_by = verified_by;
	}

	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}
	

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Column(name="date_of_resolve")
	public String getDate_of_resolve() {
		return date_of_resolve;
	}


	public void setDate_of_resolve(String date_of_resolve) {
		this.date_of_resolve = date_of_resolve;
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
	@JoinColumn(name="problem_nature_id")
	public ProblemNatureBean getProblemNatureBean() {
		return problemNatureBean;
	}
	public void setProblemNatureBean(ProblemNatureBean problemNatureBean) {
		this.problemNatureBean = problemNatureBean;
	}

	public int getCartigeCount() {
		return cartigeCount;
	}

	public void setCartigeCount(int cartigeCount) {
		this.cartigeCount = cartigeCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
