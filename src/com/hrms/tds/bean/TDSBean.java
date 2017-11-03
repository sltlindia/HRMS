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
@Table(name="tds_tbl")
public class TDSBean implements Serializable{
	
	private int tds_id;
	private String status;
	private String submission_date;
	private String period;
	
	private EmployeeBean employeeBean;
	
	public TDSBean() {
		// TODO Auto-generated constructor stub
	}
	
	public TDSBean(String status,String submission_date,String period , EmployeeBean employeeBean)
	{
		this.status = status;
		this.submission_date = submission_date;
		this.period = period;
		this.employeeBean = employeeBean;
	}
	
	
	public TDSBean(int tds_id, String status, String submission_date, String period, EmployeeBean employeeBean) {
		super();
		this.tds_id = tds_id;
		this.status = status;
		this.submission_date = submission_date;
		this.period = period;
		this.employeeBean = employeeBean;
	}

	@Id
	@GeneratedValue
	@Column(name="tds_id")
	public int getTds_id() {
		return tds_id;
	}

	public void setTds_id(int tds_id) {
		this.tds_id = tds_id;
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
