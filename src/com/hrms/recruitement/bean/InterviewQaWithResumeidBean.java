package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="interview_qa_with_resumeid_tbl")
public class InterviewQaWithResumeidBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public InterviewQaWithResumeidBean() {

	}
	
	
	
	
	
	
	
	public InterviewQaWithResumeidBean(String answer, String rating, InterviewQuestionBean interviewQuestionBean,
			ResumeDataBean resumeDataBean) {
		super();
		this.answer = answer;
		this.rating = rating;
		this.interviewQuestionBean = interviewQuestionBean;
		this.resumeDataBean = resumeDataBean;
	}







	@Id
	@GeneratedValue
	private int interview_qa_with_resumeid_id;
	private String answer;
	private String rating;
	
	private InterviewQuestionBean interviewQuestionBean;
	private ResumeDataBean resumeDataBean;
	
	@Id
	@GeneratedValue
	public int getInterview_qa_with_resumeid_id() {
		return interview_qa_with_resumeid_id;
	}
	public void setInterview_qa_with_resumeid_id(int interview_qa_with_resumeid_id) {
		this.interview_qa_with_resumeid_id = interview_qa_with_resumeid_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@ManyToOne
	@JoinColumn(name="interview_question_id")
	public InterviewQuestionBean getInterviewQuestionBean() {
		return interviewQuestionBean;
	}
	public void setInterviewQuestionBean(InterviewQuestionBean interviewQuestionBean) {
		this.interviewQuestionBean = interviewQuestionBean;
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
