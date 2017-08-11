package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="hand_over_approval_tbl")
public class HandOverApprovalBean {
	
	private int hand_over_approval_id;
	private String status;
	private String approval_date;
	

	private EmployeeBean employeeBean;
	private DetailsOfHandOverFormBean detailsOfHandOverFormBean;
	
	
	public HandOverApprovalBean() {

	}


	
	
	public HandOverApprovalBean(String status, String approval_date, EmployeeBean employeeBean,
			DetailsOfHandOverFormBean detailsOfHandOverFormBean) {
		super();
		this.status = status;
		this.approval_date = approval_date;
		this.employeeBean = employeeBean;
		this.detailsOfHandOverFormBean = detailsOfHandOverFormBean;
	}




	@Id 
    @Column(name="hand_over_approval_id")
    @GeneratedValue
	public int getHand_over_approval_id() {
		return hand_over_approval_id;
	}

	public void setHand_over_approval_id(int hand_over_approval_id) {
		this.hand_over_approval_id = hand_over_approval_id;
	}


	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="approval_date")
	public String getApproval_date() {
		return approval_date;
	}

	public void setApproval_date(String approval_date) {
		this.approval_date = approval_date;
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
	@JoinColumn(name="details_of_hand_over_form_id")
	public DetailsOfHandOverFormBean getDetailsOfHandOverFormBean() {
		return detailsOfHandOverFormBean;
	}

	public void setDetailsOfHandOverFormBean(DetailsOfHandOverFormBean detailsOfHandOverFormBean) {
		this.detailsOfHandOverFormBean = detailsOfHandOverFormBean;
	}
	
	
	
	
}
