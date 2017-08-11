package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interview_questiontype_tbl")
public class InterviewQuestiontypeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int interview_questiontype_id;
	private String interview_questiontype;
	
	
	
	public InterviewQuestiontypeBean() {

	}
	
	@Id
	@GeneratedValue
	public int getInterview_questiontype_id() {
		return interview_questiontype_id;
	}
	public void setInterview_questiontype_id(int interview_questiontype_id) {
		this.interview_questiontype_id = interview_questiontype_id;
	}
	public String getInterview_questiontype() {
		return interview_questiontype;
	}
	public void setInterview_questiontype(String interview_questiontype) {
		this.interview_questiontype = interview_questiontype;
	}
	
	
	

	
	
	
	
	
}
