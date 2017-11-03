package com.hrms.tds.bean;

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
@Table(name="tds_hr_tbl")
public class TDSHrBean implements Serializable{

	private int tds_hr_id;
	private String status;
	private String submission_date;
	private String period;
	private EmployeeBean employeeBean;
	
	public TDSHrBean() {}

	public TDSHrBean(String status, String submission_date, String period, EmployeeBean employeeBean) 
	{
		this.status = status;
		this.submission_date = submission_date;
		this.period = period;
		this.employeeBean = employeeBean;
	}
	
	public TDSHrBean(int tds_hr_id, String status, String submission_date, String period, EmployeeBean employeeBean) {
		super();
		this.tds_hr_id = tds_hr_id;
		this.status = status;
		this.submission_date = submission_date;
		this.period = period;
		this.employeeBean = employeeBean;
	}

	
	
	public TDSHrBean(String status, EmployeeBean employeeBean)
	{
		
		this.status = status;
		this.employeeBean = employeeBean;
	}
	
	
	
	@Id
	@GeneratedValue
	@Column(name="tds_hr_id")
	public int getTds_hr_id() {
		return tds_hr_id;
	}

	public void setTds_hr_id(int tds_hr_id) {
		this.tds_hr_id = tds_hr_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
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
