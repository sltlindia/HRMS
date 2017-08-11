package com.hrms.selfservice.bean;

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
@Table(name="complaint_verifiedby_tbl")
public class ComplaintVerifiedByBean implements Serializable{

	private int complaint_verifiedby_id;
	private ComplaintBean complaintBean;
	private EmployeeBean employeeBean;
	
	public ComplaintVerifiedByBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ComplaintVerifiedByBean(int complaint_verifiedby_id, ComplaintBean complaintBean,
			EmployeeBean employeeBean) {
		super();
		this.complaint_verifiedby_id = complaint_verifiedby_id;
		this.complaintBean = complaintBean;
		this.employeeBean = employeeBean;
	}
	
	
	public ComplaintVerifiedByBean(ComplaintBean complaintBean, EmployeeBean employeeBean) {
		super();
		this.complaintBean = complaintBean;
		this.employeeBean = employeeBean;
	}



	@Id 
    @Column(name="complaint_verifiedby_id")
    @GeneratedValue
	public int getComplaint_verifiedby_id() {
		return complaint_verifiedby_id;
	}
	public void setComplaint_verifiedby_id(int complaint_verifiedby_id) {
		this.complaint_verifiedby_id = complaint_verifiedby_id;
	}
	
	@ManyToOne
	@JoinColumn(name="complaint_id")
	public ComplaintBean getComplaintBean() {
		return complaintBean;
	}
	public void setComplaintBean(ComplaintBean complaintBean) {
		this.complaintBean = complaintBean;
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
