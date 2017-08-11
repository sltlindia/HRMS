package com.hrms.lms.bean;

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
@Table(name="gate_pass_tbl")
public class GatePassBean implements Serializable {
	

	private int gate_pass_id;
	private String purpose_of_leave;
	private String reason;
	private String Returnable;
	private String out_time;
	private String status;
	private String security_out_time;
	private String security_in_time;
	private String submission_date_time;
	private String rejected_reason;
	private String approve_reject_date_time;
	private int approve_ID;
	private String CompanyName;
	private String Todec;
	private int gate_entry;
	private String destination_in_time;
	private String destination_out_time;
	private EmployeeBean employeeBean;
	private int other_manager_id;
	
	public GatePassBean() {
		
	}

	public GatePassBean(EmployeeBean employeeBean,String purpose_of_leave, String reason, String Returnable,  String out_time, String status, String submission_date_time,
			String CompanyName , String Todec,int gate_entry,int other_manager_id) {
		this.employeeBean = employeeBean;
		this.purpose_of_leave = purpose_of_leave;
		this.reason = reason;
		this.Returnable = Returnable;
		this.out_time = out_time;
		this.status = status;
		this.submission_date_time = submission_date_time;
		this.CompanyName = CompanyName;
		this.Todec = Todec;
		this.gate_entry = gate_entry;
		this.other_manager_id = other_manager_id;
	}
	
	@Id
	@Column(name="gate_pass_id")
    @GeneratedValue
	public int getGate_pass_id() {
		return gate_pass_id;
	}

	public void setGate_pass_id(int gate_pass_id) {
		this.gate_pass_id = gate_pass_id;
	}

	@Column(name="purpose_of_leave")
	public String getPurpose_of_leave() {
		return purpose_of_leave;
	}

	public void setPurpose_of_leave(String purpose_of_leave) {
		this.purpose_of_leave = purpose_of_leave;
	}

	@Column(name="reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	public String getReturnable() {
		return Returnable;
	}

	public void setReturnable(String returnable) {
		Returnable = returnable;
	}
	
	
	@Column(name="out_time")
	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="security_out_time")
	public String getSecurity_out_time() {
		return security_out_time;
	}

	public void setSecurity_out_time(String security_out_time) {
		this.security_out_time = security_out_time;
	}

	@Column(name="security_in_time")
	public String getSecurity_in_time() {
		return security_in_time;
	}

	public void setSecurity_in_time(String security_in_time) {
		this.security_in_time = security_in_time;
	}

	@Column(name="submission_date_time")
	public String getSubmission_date_time() {
		return submission_date_time;
	}

	public void setSubmission_date_time(String submission_date_time) {
		this.submission_date_time = submission_date_time;
	}

	@Column(name="rejected_reason")
	public String getRejected_reason() {
		return rejected_reason;
	}

	public void setRejected_reason(String rejected_reason) {
		this.rejected_reason = rejected_reason;
	}

	@Column(name="approve_reject_date_time")
	public String getApprove_reject_date_time() {
		return approve_reject_date_time;
	}

	public void setApprove_reject_date_time(String approve_reject_date_time) {
		this.approve_reject_date_time = approve_reject_date_time;
	}


	public int getApprove_ID() {
		return approve_ID;
	}

	public void setApprove_ID(int approve_ID) {
		this.approve_ID = approve_ID;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getTodec() {
		return Todec;
	}

	public void setTodec(String todec) {
		Todec = todec;
	}

	public int getGate_entry() {
		return gate_entry;
	}

	public void setGate_entry(int gate_entry) {
		this.gate_entry = gate_entry;
	}

	public String getDestination_in_time() {
		return destination_in_time;
	}

	public void setDestination_in_time(String destination_in_time) {
		this.destination_in_time = destination_in_time;
	}

	public String getDestination_out_time() {
		return destination_out_time;
	}

	public void setDestination_out_time(String destination_out_time) {
		this.destination_out_time = destination_out_time;
	}

	public int getOther_manager_id() {
		return other_manager_id;
	}

	public void setOther_manager_id(int other_manager_id) {
		this.other_manager_id = other_manager_id;
	}
	
	
	
	
	
}
