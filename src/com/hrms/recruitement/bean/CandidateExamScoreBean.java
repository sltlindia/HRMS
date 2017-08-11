package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidate_exam_score_tbl")
public class CandidateExamScoreBean {

	@Id 
    @GeneratedValue
	private int candidate_exam_score_id;
	private String total_iq_score;
	private String total_technical_written_score;
	private String total_technical_interview_score;
	private String total_hr_interview_score;
	private String total_gd_score;
	private String obtained_iq_score;
	private String obtained_technical_written_score;
	private String obtained_technical_interview_score;
	private String obtained_hr_interview_score;
	private String obtained_gd_score;
	private Double average;
	private String total_personality_score;
	private String total_aptitude_score;
	private String obtained_personality_score;
	private String obtained_aptitude_score;
	
	private ResumeDataBean resumeDataBean;
	
	
	public CandidateExamScoreBean(){}
	

	public CandidateExamScoreBean(String total_iq_score, String total_technical_written_score,
			String total_technical_interview_score, String total_hr_interview_score, String total_gd_score,
			String obtained_iq_score, String obtained_technical_written_score,
			String obtained_technical_interview_score, String obtained_hr_interview_score, String obtained_gd_score,
			ResumeDataBean resumeDataBean,Double average,String total_personality_score,String total_aptitude_score,String obtained_personality_score,String obtained_aptitude_score) {

		this.total_iq_score = total_iq_score;
		this.total_technical_written_score = total_technical_written_score;
		this.total_technical_interview_score = total_technical_interview_score;
		this.total_hr_interview_score = total_hr_interview_score;
		this.total_gd_score = total_gd_score;
		this.obtained_iq_score = obtained_iq_score;
		this.obtained_technical_written_score = obtained_technical_written_score;
		this.obtained_technical_interview_score = obtained_technical_interview_score;
		this.obtained_hr_interview_score = obtained_hr_interview_score;
		this.obtained_gd_score = obtained_gd_score;
		this.resumeDataBean = resumeDataBean;
		this.average = average;
		this.total_personality_score = total_personality_score;
		this.total_aptitude_score = total_aptitude_score;
		this.obtained_personality_score = obtained_personality_score;
		this.obtained_aptitude_score = obtained_aptitude_score;
	}


	@Id
	@Column(name = "candidate_exam_score_id")
	@GeneratedValue
	public int getCandidate_exam_score_id() {
		return candidate_exam_score_id;
	}

	public void setCandidate_exam_score_id(int candidate_exam_score_id) {
		this.candidate_exam_score_id = candidate_exam_score_id;
	}


	public String getTotal_iq_score() {
		return total_iq_score;
	}


	public void setTotal_iq_score(String total_iq_score) {
		this.total_iq_score = total_iq_score;
	}



	public String getTotal_technical_written_score() {
		return total_technical_written_score;
	}




	public void setTotal_technical_written_score(String total_technical_written_score) {
		this.total_technical_written_score = total_technical_written_score;
	}




	public String getTotal_technical_interview_score() {
		return total_technical_interview_score;
	}




	public void setTotal_technical_interview_score(String total_technical_interview_score) {
		this.total_technical_interview_score = total_technical_interview_score;
	}




	public String getTotal_hr_interview_score() {
		return total_hr_interview_score;
	}




	public void setTotal_hr_interview_score(String total_hr_interview_score) {
		this.total_hr_interview_score = total_hr_interview_score;
	}




	public String getTotal_gd_score() {
		return total_gd_score;
	}




	public void setTotal_gd_score(String total_gd_score) {
		this.total_gd_score = total_gd_score;
	}




	public String getObtained_iq_score() {
		return obtained_iq_score;
	}




	public void setObtained_iq_score(String obtained_iq_score) {
		this.obtained_iq_score = obtained_iq_score;
	}




	public String getObtained_technical_written_score() {
		return obtained_technical_written_score;
	}




	public void setObtained_technical_written_score(String obtained_technical_written_score) {
		this.obtained_technical_written_score = obtained_technical_written_score;
	}




	public String getObtained_technical_interview_score() {
		return obtained_technical_interview_score;
	}




	public void setObtained_technical_interview_score(String obtained_technical_interview_score) {
		this.obtained_technical_interview_score = obtained_technical_interview_score;
	}




	public String getObtained_hr_interview_score() {
		return obtained_hr_interview_score;
	}




	public void setObtained_hr_interview_score(String obtained_hr_interview_score) {
		this.obtained_hr_interview_score = obtained_hr_interview_score;
	}




	public String getObtained_gd_score() {
		return obtained_gd_score;
	}




	public void setObtained_gd_score(String obtained_gd_score) {
		this.obtained_gd_score = obtained_gd_score;
	}

	


	








	public Double getAverage() {
		return average;
	}









	public void setAverage(Double average) {
		this.average = average;
	}









	public String getTotal_personality_score() {
		return total_personality_score;
	}


	public void setTotal_personality_score(String total_personality_score) {
		this.total_personality_score = total_personality_score;
	}


	public String getTotal_aptitude_score() {
		return total_aptitude_score;
	}


	public void setTotal_aptitude_score(String total_aptitude_score) {
		this.total_aptitude_score = total_aptitude_score;
	}


	public String getObtained_personality_score() {
		return obtained_personality_score;
	}


	public void setObtained_personality_score(String obtained_personality_score) {
		this.obtained_personality_score = obtained_personality_score;
	}


	public String getObtained_aptitude_score() {
		return obtained_aptitude_score;
	}


	public void setObtained_aptitude_score(String obtained_aptitude_score) {
		this.obtained_aptitude_score = obtained_aptitude_score;
	}


	@ManyToOne
	@JoinColumn(name="resume_data_id")
	public ResumeDataBean getResumeDataBean() {
		return resumeDataBean;
	}

	public void setResumeDataBean(ResumeDataBean resumeDataBean) {
		this.resumeDataBean = resumeDataBean;
	}

		
	
}
