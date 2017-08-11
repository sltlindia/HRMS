package com.hrms.recruitement.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "candidate_exam_info_tbl")
public class CandidateExamInfoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int candidate_exam_info_id;
	private int iq_test;
	private int technical_written_test;
	private int technical_interview;
	private int hr_interview;
	private int group_discussion;
	private String required_time;
	private ResumeDataBean resumeDataBean;
	private String submission_date;
	private int personality_test;
	private int aptitude_test;
	
	public CandidateExamInfoBean(){}
	
	
	public CandidateExamInfoBean(int iq_test, int technical_written_test,
			int technical_interview, int hr_interview, int group_discussion, String required_time,
			ResumeDataBean resumeDataBean,String submission_date,int personality_test, int aptitude_test) {
		this.iq_test = iq_test;
		this.technical_written_test = technical_written_test;
		this.technical_interview = technical_interview;
		this.hr_interview = hr_interview;
		this.group_discussion = group_discussion;
		this.required_time = required_time;
		this.resumeDataBean = resumeDataBean;
		this.submission_date = submission_date;
		this.personality_test = personality_test;
		this.aptitude_test = aptitude_test;
	}
	
	@Id
	@Column(name = "candidate_exam_info_id")
	@GeneratedValue
	public int getCandidate_exam_info_id() {
		return candidate_exam_info_id;
	}

	public void setCandidate_exam_info_id(int candidate_exam_info_id) {
		this.candidate_exam_info_id = candidate_exam_info_id;
	}


	public int getIq_test() {
		return iq_test;
	}

	public void setIq_test(int iq_test) {
		this.iq_test = iq_test;
	}

	public int getTechnical_written_test() {
		return technical_written_test;
	}

	public void setTechnical_written_test(int technical_written_test) {
		this.technical_written_test = technical_written_test;
	}

	public int getTechnical_interview() {
		return technical_interview;
	}

	public void setTechnical_interview(int technical_interview) {
		this.technical_interview = technical_interview;
	}

	public int getHr_interview() {
		return hr_interview;
	}

	public void setHr_interview(int hr_interview) {
		this.hr_interview = hr_interview;
	}

	public int getGroup_discussion() {
		return group_discussion;
	}

	public void setGroup_discussion(int group_discussion) {
		this.group_discussion = group_discussion;
	}

	public String getRequired_time() {
		return required_time;
	}

	public void setRequired_time(String required_time) {
		this.required_time = required_time;
	}
	
	
	
	
	public int getPersonality_test() {
		return personality_test;
	}


	public void setPersonality_test(int personality_test) {
		this.personality_test = personality_test;
	}


	public int getAptitude_test() {
		return aptitude_test;
	}


	public void setAptitude_test(int aptitude_test) {
		this.aptitude_test = aptitude_test;
	}


	@ManyToOne
	@JoinColumn(name = "resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}

	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}


	public String getSubmission_date() {
		return submission_date;
	}


	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
