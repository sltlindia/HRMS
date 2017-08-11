package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="otp_tbl")
public class OTPBean implements Serializable{

	private int otp_id;
	private int otp;
	private String date_time;
	
	private EmployeeBean employeeBean;
	
	public OTPBean() {
		// TODO Auto-generated constructor stub
	}
	
	public OTPBean(int otp, String date_time, EmployeeBean employeeBean) {
		this.otp = otp;
		this.date_time = date_time;
		this.employeeBean = employeeBean;
	}

	
	@Id
	@Column(name="otp_id")
    @GeneratedValue
	public int getOtp_id() {
		return otp_id;
	}

	public void setOtp_id(int otp_id) {
		this.otp_id = otp_id;
	}

	@Column(name="otp")
	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	
	@Column(name="date_time")
	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
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
