package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "academic_detail_check_tbl")
public class AcademicDetailCheckBean {
	
	
	public AcademicDetailCheckBean(){}
	private InterviewFeedbackBean interviewFeedbackBean;
	
	@Id
	@GeneratedValue
	private int academic_detail_check_id;
	private String qualification;
	private String mode_of_education;
	private String name_of_institute;
	private String name_of_university;
	private String roll_no;
	private String marks;
	private String from_date;
	private String to_date;
	
	
	
	
	@Id
	@Column(name = "academic_detail_check_id")
	@GeneratedValue
	public int getAcademic_detail_check_id() {
		return academic_detail_check_id;
	}
	
	public void setAcademic_detail_check_id(int academic_detail_check_id) {
		this.academic_detail_check_id = academic_detail_check_id;
	}
	
	@Column(name = "qualification")
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	@Column(name = "mode_of_education")
	public String getMode_of_education() {
		return mode_of_education;
	}
	public void setMode_of_education(String mode_of_education) {
		this.mode_of_education = mode_of_education;
	}
	
	@Column(name = "name_of_institute")
	public String getName_of_institute() {
		return name_of_institute;
	}
	public void setName_of_institute(String name_of_institute) {
		this.name_of_institute = name_of_institute;
	}
	
	@Column(name = "name_of_university")
	public String getName_of_university() {
		return name_of_university;
	}
	public void setName_of_university(String name_of_university) {
		this.name_of_university = name_of_university;
	}
	
	@Column(name = "roll_no")
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	
	@Column(name = "marks")
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	@Column(name = "from_date")
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	
	@Column(name = "to_date")
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name="interview_feedback_id")
	public InterviewFeedbackBean getInterviewFeedbackBean() {
		return interviewFeedbackBean;
	}
	public void setInterviewFeedbackBean(InterviewFeedbackBean interviewFeedbackBean) {
		this.interviewFeedbackBean = interviewFeedbackBean;
	}
	
	
	
	
	public AcademicDetailCheckBean(InterviewFeedbackBean interviewFeedbackBean, String qualification, String mode_of_education,
			String name_of_institute, String name_of_university, String roll_no, String marks, String from_date,
			String to_date) {
		super();
		this.interviewFeedbackBean = interviewFeedbackBean;
		this.qualification = qualification;
		this.mode_of_education = mode_of_education;
		this.name_of_institute = name_of_institute;
		this.name_of_university = name_of_university;
		this.roll_no = roll_no;
		this.marks = marks;
		this.from_date = from_date;
		this.to_date = to_date;
	}
	
	
	
}
