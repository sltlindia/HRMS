package com.hrms.recruitement.bean;

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
@Table(name="resume_share_tbl")
public class ResumeShareBean implements Serializable{

	private ResumeDataBean resumeDataBean;
	private EmployeeBean employeeBean;
	private int resume_share_id;
	private String status;
	private String reason;
	private String shared_date;
	private String reply_date;
	private String first_date_time;
	private String second_date_time;
	private String third_date_time;
	private String show_view;
	private String first_interview_type;
	private String second_interview_type;
	private String third_interview_type;
	
	
	
	
	
	public ResumeShareBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ResumeShareBean(ResumeDataBean resumeDataBean, EmployeeBean employeeBean, String status, String reason,
			String shared_date, String reply_date) {
		super();
		this.resumeDataBean = resumeDataBean;
		this.employeeBean = employeeBean;
		this.status = status;
		this.reason = reason;
		this.shared_date = shared_date;
		this.reply_date = reply_date;
	}
	@ManyToOne
	@JoinColumn(name="resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}
	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	@Id
	@GeneratedValue
	@Column(name="resume_share_id")
	public int getResume_share_id() {
		return resume_share_id;
	}
	public void setResume_share_id(int resume_share_id) {
		this.resume_share_id = resume_share_id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getShared_date() {
		return shared_date;
	}
	public void setShared_date(String shared_date) {
		this.shared_date = shared_date;
	}
	
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}

	public String getFirst_date_time() {
		return first_date_time;
	}

	public void setFirst_date_time(String first_date_time) {
		this.first_date_time = first_date_time;
	}

	public String getSecond_date_time() {
		return second_date_time;
	}

	public void setSecond_date_time(String second_date_time) {
		this.second_date_time = second_date_time;
	}

	public String getThird_date_time() {
		return third_date_time;
	}

	public void setThird_date_time(String third_date_time) {
		this.third_date_time = third_date_time;
	}

	public String getShow_view() {
		return show_view;
	}

	public void setShow_view(String show_view) {
		this.show_view = show_view;
	}
	
	public String getFirst_interview_type() {
		return first_interview_type;
	}

	public void setFirst_interview_type(String first_interview_type) {
		this.first_interview_type = first_interview_type;
	}

	public String getSecond_interview_type() {
		return second_interview_type;
	}

	public void setSecond_interview_type(String second_interview_type) {
		this.second_interview_type = second_interview_type;
	}

	public String getThird_interview_type() {
		return third_interview_type;
	}

	public void setThird_interview_type(String third_interview_type) {
		this.third_interview_type = third_interview_type;
	}

	public ResumeShareBean(ResumeDataBean resumeDataBean, EmployeeBean employeeBean, String status, String reason,
			String shared_date, String reply_date, String first_date_time, String second_date_time,
			String third_date_time, String show_view, String first_interview_type, String second_interview_type, String third_interview_type) {
		super();
		this.resumeDataBean = resumeDataBean;
		this.employeeBean = employeeBean;
		this.status = status;
		this.reason = reason;
		this.shared_date = shared_date;
		this.reply_date = reply_date;
		this.first_date_time = first_date_time;
		this.second_date_time = second_date_time;
		this.third_date_time = third_date_time;
		this.show_view = show_view;
	}
	
	
	
	
}
