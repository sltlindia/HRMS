package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="interview_question_tbl")
public class InterviewQuestionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private int interview_question_id;
	private String interview_question;
	
	private InterviewQuestiontypeBean interviewQuestiontypeBean;

	
	
	
	@Id
	@GeneratedValue
	public int getInterview_question_id() {
		return interview_question_id;
	}

	public void setInterview_question_id(int interview_question_id) {
		this.interview_question_id = interview_question_id;
	}

	public String getInterview_question() {
		return interview_question;
	}

	public void setInterview_question(String interview_question) {
		this.interview_question = interview_question;
	}

	@ManyToOne
	@JoinColumn(name="interview_questiontype_id")
	public InterviewQuestiontypeBean getInterviewQuestiontypeBean() {
		return interviewQuestiontypeBean;
	}

	public void setInterviewQuestiontypeBean(InterviewQuestiontypeBean interviewQuestiontypeBean) {
		this.interviewQuestiontypeBean = interviewQuestiontypeBean;
	}
	
	
	
	

}
