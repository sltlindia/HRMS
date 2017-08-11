package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "phil_test_tbl")
public class PhilTestBean {

	public PhilTestBean() {}
	
	@Id
	@GeneratedValue
	private int phil_test_id;
	private String candidate;
	private String position;
	private String q1;
	private String q2;
	private String q3;
	private String q4;
	private String q5;
	private String q6;
	private String q7;
	private String q8;
	private String q9;
	private String q10;
	private String submission_date;
	
	
	
	public PhilTestBean(String candidate, String position, String q1, String q2, String q3, String q4, String q5,
			String q6, String q7, String q8, String q9, String q10, String submission_date) {

		this.candidate = candidate;
		this.position = position;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.q5 = q5;
		this.q6 = q6;
		this.q7 = q7;
		this.q8 = q8;
		this.q9 = q9;
		this.q10 = q10;
		this.submission_date = submission_date;
	}
	
	@Id
	@Column(name= "phil_test_id")
	@GeneratedValue
	public int getPhil_test_id() {
		return phil_test_id;
	}
	public void setPhil_test_id(int phil_test_id) {
		this.phil_test_id = phil_test_id;
	}
	@Column(name= "candidate")
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	@Column(name= "position")
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Column(name= "q1")
	public String getQ1() {
		return q1;
	}
	public void setQ1(String q1) {
		this.q1 = q1;
	}
	@Column(name= "q2")
	public String getQ2() {
		return q2;
	}
	public void setQ2(String q2) {
		this.q2 = q2;
	}
	@Column(name= "q3")
	public String getQ3() {
		return q3;
	}
	public void setQ3(String q3) {
		this.q3 = q3;
	}
	@Column(name= "q4")
	public String getQ4() {
		return q4;
	}
	public void setQ4(String q4) {
		this.q4 = q4;
	}
	@Column(name= "q5")
	public String getQ5() {
		return q5;
	}
	public void setQ5(String q5) {
		this.q5 = q5;
	}
	@Column(name= "q6")
	public String getQ6() {
		return q6;
	}
	public void setQ6(String q6) {
		this.q6 = q6;
	}
	@Column(name= "q7")
	public String getQ7() {
		return q7;
	}
	public void setQ7(String q7) {
		this.q7 = q7;
	}
	@Column(name= "q8")
	public String getQ8() {
		return q8;
	}
	public void setQ8(String q8) {
		this.q8 = q8;
	}
	@Column(name= "q9")
	public String getQ9() {
		return q9;
	}
	public void setQ9(String q9) {
		this.q9 = q9;
	}
	@Column(name= "q10")
	public String getQ10() {
		return q10;
	}
	public void setQ10(String q10) {
		this.q10 = q10;
	}
	@Column(name= "submission_date")
	public String getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	
	
}
