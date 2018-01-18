package com.hrms.recruitement.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notify_to_candidate_tbl")
public class NotifyToCandidateBean {
	
	@Id
	@GeneratedValue
	private int notify_to_candidate_id;
	private String interview_date;
	private String interview_time;
	private String title_of_position;
	private String interview_location;
	private String interview_type;
	
	private ResumeDataBean resumeDataBean;
	
	
	@Id
	@GeneratedValue
	public int getNotify_to_candidate_id() {
		return notify_to_candidate_id;
	}
	public void setNotify_to_candidate_id(int notify_to_candidate_id) {
		this.notify_to_candidate_id = notify_to_candidate_id;
	}

	public String getInterview_date() {
		return interview_date;
	}
	public void setInterview_date(String interview_date) {
		this.interview_date = interview_date;
	}
	public String getInterview_time() {
		return interview_time;
	}
	public void setInterview_time(String interview_time) {
		this.interview_time = interview_time;
	}
	public String getTitle_of_position() {
		return title_of_position;
	}
	public void setTitle_of_position(String title_of_position) {
		this.title_of_position = title_of_position;
	}
	public String getInterview_location() {
		return interview_location;
	}
	public void setInterview_location(String interview_location) {
		this.interview_location = interview_location;
	}
	public NotifyToCandidateBean() {
	}
	public NotifyToCandidateBean(String interview_date, String interview_time,
			String title_of_position, String interview_location,ResumeDataBean resumeDataBean, String interview_type) {

		this.interview_date = interview_date;
		this.interview_time = interview_time;
		this.title_of_position = title_of_position;
		this.interview_location = interview_location;
		this.resumeDataBean = resumeDataBean;
		this.interview_type = interview_type;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name = "resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}
	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}
	
	
	public String getInterview_type() {
		return interview_type;
	}
	public void setInterview_type(String interview_type) {
		this.interview_type = interview_type;
	}
	
	

}
