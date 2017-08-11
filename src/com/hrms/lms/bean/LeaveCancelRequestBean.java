package com.hrms.lms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="leave_cancel_request_tbl")
public class LeaveCancelRequestBean implements Serializable {
	
	private int leave_cancel_request_id;
	private int leave_cancel_type;
	private String reason;
	private String approved_status;
	private String updated_leave_from;
	private String updated_leave_to;
	private double updated_day_count;
	private String updated_from_half;
	private String updated_to_half;
	private int mail_view;
	
	
	private LeaveBean leaveBean;
	
	public LeaveCancelRequestBean() {
		// TODO Auto-generated constructor stub
	}




	public LeaveCancelRequestBean(int leave_cancel_type, String reason, String approved_status,
			String updated_leave_from, String updated_leave_to, double updated_day_count, String updated_from_half,
			String updated_to_half, LeaveBean leaveBean, int mail_view) {
		super();
		this.leave_cancel_type = leave_cancel_type;
		this.reason = reason;
		this.approved_status = approved_status;
		this.updated_leave_from = updated_leave_from;
		this.updated_leave_to = updated_leave_to;
		this.updated_day_count = updated_day_count;
		this.updated_from_half = updated_from_half;
		this.updated_to_half = updated_to_half;
		this.leaveBean = leaveBean;
		this.mail_view = mail_view;
	}





	@Id 
	 @Column(name="leave_cancel_request_id")
	 @GeneratedValue
	public int getLeave_cancel_request_id() {
		return leave_cancel_request_id;
	}

	public void setLeave_cancel_request_id(int leave_cancel_request_id) {
		this.leave_cancel_request_id = leave_cancel_request_id;
	}

	public int getLeave_cancel_type() {
		return leave_cancel_type;
	}

	public void setLeave_cancel_type(int leave_cancel_type) {
		this.leave_cancel_type = leave_cancel_type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	@ManyToOne
	@JoinColumn(name="leave_id")
	public LeaveBean getLeaveBean() {
		return leaveBean;
	}

	public void setLeaveBean(LeaveBean leaveBean) {
		this.leaveBean = leaveBean;
	}

	public String getApproved_status() {
		return approved_status;
	}

	public void setApproved_status(String approved_status) {
		this.approved_status = approved_status;
	}

	public String getUpdated_leave_from() {
		return updated_leave_from;
	}

	public void setUpdated_leave_from(String updated_leave_from) {
		this.updated_leave_from = updated_leave_from;
	}

	public String getUpdated_leave_to() {
		return updated_leave_to;
	}


	public void setUpdated_leave_to(String updated_leave_to) {
		this.updated_leave_to = updated_leave_to;
	}


	public double getUpdated_day_count() {
		return updated_day_count;
	}



	public void setUpdated_day_count(double updated_day_count) {
		this.updated_day_count = updated_day_count;
	}





	public String getUpdated_from_half() {
		return updated_from_half;
	}





	public void setUpdated_from_half(String updated_from_half) {
		this.updated_from_half = updated_from_half;
	}





	public String getUpdated_to_half() {
		return updated_to_half;
	}





	public void setUpdated_to_half(String updated_to_half) {
		this.updated_to_half = updated_to_half;
	}




	public int getMail_view() {
		return mail_view;
	}




	public void setMail_view(int mail_view) {
		this.mail_view = mail_view;
	}

	
	
	
}
