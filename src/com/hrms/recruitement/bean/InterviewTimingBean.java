package com.hrms.recruitement.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "interview_timing_tbl")
public class InterviewTimingBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int interview_timing_id;
	private String first_date_time;
	private String second_date_time;
	private String third_date_time;
	private int show_view;
	
	private ResumeDataBean resumeDataBean;
	private EmployeeBean employeeBean;

	public InterviewTimingBean() {
		// TODO Auto-generated constructor stub
	}

	public InterviewTimingBean(String first_date_time, String second_date_time, String third_date_time,
			EmployeeBean employeeBean, ResumeDataBean resumeDataBean,  String first_time,
			String second_time, String third_time, int show_view) {
		this.first_date_time = first_date_time;
		this.second_date_time = second_date_time;
		this.third_date_time = third_date_time;
		this.employeeBean = employeeBean;
		this.resumeDataBean = resumeDataBean;
		
		this.show_view = show_view;
	}

	@Id
	@Column(name = "interview_timing_id")
	@GeneratedValue
	public int getInterview_timing_id() {
		return interview_timing_id;
	}

	public void setInterview_timing_id(int interview_timing_id) {
		this.interview_timing_id = interview_timing_id;
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

	@ManyToOne
	@JoinColumn(name = "resume_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}

	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}

	@Column(name = "show_view")
	public int getShow_view() {
		return show_view;
	}

	public void setShow_view(int show_view) {
		this.show_view = show_view;
	}

	@ManyToOne
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

}
