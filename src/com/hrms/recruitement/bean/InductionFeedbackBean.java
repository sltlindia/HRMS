package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="induction_feedback_tbl")
public class InductionFeedbackBean {
	
	public InductionFeedbackBean(){}
	
	
	@Id
	@GeneratedValue
	private int induction_feedback_id;
	private String induction_feedback_q1;
	private String induction_feedback_q2;
	private String induction_feedback_q3;
	private String induction_feedback_q4;
	private String induction_feedback_q5;
	private String induction_feedback_q6;
	private String induction_feedback_q7;
	private String induction_feedback_q8;
	private String induction_feedback_q9;
	private String induction_feedback_q10;
	private String suggestion;
	
	private EmployeeBean employeeBean;
	
	public InductionFeedbackBean(String induction_feedback_q1, String induction_feedback_q2,
			String induction_feedback_q3, String induction_feedback_q4, String induction_feedback_q5,
			String induction_feedback_q6, String induction_feedback_q7, String induction_feedback_q8,
			String induction_feedback_q9, String induction_feedback_q10, String suggestion, EmployeeBean employeeBean) {
		this.induction_feedback_q1 = induction_feedback_q1;
		this.induction_feedback_q2 = induction_feedback_q2;
		this.induction_feedback_q3 = induction_feedback_q3;
		this.induction_feedback_q4 = induction_feedback_q4;
		this.induction_feedback_q5 = induction_feedback_q5;
		this.induction_feedback_q6 = induction_feedback_q6;
		this.induction_feedback_q7 = induction_feedback_q7;
		this.induction_feedback_q8 = induction_feedback_q8;
		this.induction_feedback_q9 = induction_feedback_q9;
		this.induction_feedback_q10 = induction_feedback_q10;
		this.suggestion = suggestion;
		this.employeeBean = employeeBean;
	}


	@Id 
	@Column(name = "induction_feedback_id")
    @GeneratedValue
	public int getInduction_feedback_id() {
		return induction_feedback_id;
	}

	public void setInduction_feedback_id(int induction_feedback_id) {
		this.induction_feedback_id = induction_feedback_id;
	}

	public String getInduction_feedback_q1() {
		return induction_feedback_q1;
	}

	public void setInduction_feedback_q1(String induction_feedback_q1) {
		this.induction_feedback_q1 = induction_feedback_q1;
	}

	public String getInduction_feedback_q2() {
		return induction_feedback_q2;
	}

	public void setInduction_feedback_q2(String induction_feedback_q2) {
		this.induction_feedback_q2 = induction_feedback_q2;
	}

	public String getInduction_feedback_q3() {
		return induction_feedback_q3;
	}

	public void setInduction_feedback_q3(String induction_feedback_q3) {
		this.induction_feedback_q3 = induction_feedback_q3;
	}

	public String getInduction_feedback_q4() {
		return induction_feedback_q4;
	}

	public void setInduction_feedback_q4(String induction_feedback_q4) {
		this.induction_feedback_q4 = induction_feedback_q4;
	}

	public String getInduction_feedback_q5() {
		return induction_feedback_q5;
	}

	public void setInduction_feedback_q5(String induction_feedback_q5) {
		this.induction_feedback_q5 = induction_feedback_q5;
	}

	public String getInduction_feedback_q6() {
		return induction_feedback_q6;
	}

	public void setInduction_feedback_q6(String induction_feedback_q6) {
		this.induction_feedback_q6 = induction_feedback_q6;
	}

	public String getInduction_feedback_q7() {
		return induction_feedback_q7;
	}

	public void setInduction_feedback_q7(String induction_feedback_q7) {
		this.induction_feedback_q7 = induction_feedback_q7;
	}

	public String getInduction_feedback_q8() {
		return induction_feedback_q8;
	}

	public void setInduction_feedback_q8(String induction_feedback_q8) {
		this.induction_feedback_q8 = induction_feedback_q8;
	}

	public String getInduction_feedback_q9() {
		return induction_feedback_q9;
	}

	public void setInduction_feedback_q9(String induction_feedback_q9) {
		this.induction_feedback_q9 = induction_feedback_q9;
	}

	public String getInduction_feedback_q10() {
		return induction_feedback_q10;
	}

	public void setInduction_feedback_q10(String induction_feedback_q10) {
		this.induction_feedback_q10 = induction_feedback_q10;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	
	@ManyToOne	
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
	
	
	
}
