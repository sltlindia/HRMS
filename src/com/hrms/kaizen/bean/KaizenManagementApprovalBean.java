package com.hrms.kaizen.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="kaizen_management_approval_tbl")
public class KaizenManagementApprovalBean {

	
	private int kaizen_management_approval_id;
	private String management_approval_status;
	private String management_rejection_reason;
	
	
	private EmployeeBean employeeBean;
	private KaizenBean kaizenBean;
	
	
	
	public KaizenManagementApprovalBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public KaizenManagementApprovalBean(String management_approval_status, String management_rejection_reason,
			EmployeeBean employeeBean,KaizenBean kaizenBean) {
		super();
		this.management_approval_status = management_approval_status;
		this.management_rejection_reason = management_rejection_reason;
		this.employeeBean = employeeBean;
		this.kaizenBean = kaizenBean;
	}
	
	
	
	


	@Id 
    @Column(name="kaizen_management_approval_id")
    @GeneratedValue
	public int getKaizen_management_approval_id() {
		return kaizen_management_approval_id;
	}


	public void setKaizen_management_approval_id(int kaizen_management_approval_id) {
		this.kaizen_management_approval_id = kaizen_management_approval_id;
	}


	public String getManagement_approval_status() {
		return management_approval_status;
	}


	public void setManagement_approval_status(String management_approval_status) {
		this.management_approval_status = management_approval_status;
	}


	public String getManagement_rejection_reason() {
		return management_rejection_reason;
	}


	public void setManagement_rejection_reason(String management_rejection_reason) {
		this.management_rejection_reason = management_rejection_reason;
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
	@JoinColumn(name="kaizen_id")
	public KaizenBean getKaizenBean() {
		return kaizenBean;
	}


	public void setKaizenBean(KaizenBean kaizenBean) {
		this.kaizenBean = kaizenBean;
	}
	
	
	
	
	
	
	
	
}
