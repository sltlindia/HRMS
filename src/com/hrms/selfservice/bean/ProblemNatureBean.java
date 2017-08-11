package com.hrms.selfservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="problem_nature_tbl")
public class ProblemNatureBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int problem_nature_id;
	private String problem_nature_name;
	
	public ProblemNatureBean() {
	}
	
	
	public ProblemNatureBean(int problem_nature_id, String problem_nature_name) {
		super();
		this.problem_nature_id = problem_nature_id;
		this.problem_nature_name = problem_nature_name;
	}


	public ProblemNatureBean(String problem_nature_name) {
		super();

		this.problem_nature_name = problem_nature_name;
	}

	@Id
	@GeneratedValue
	@Column(name="problem_nature_id")
	public int getProblem_nature_id() {
		return problem_nature_id;
	}
	public void setProblem_nature_id(int problem_nature_id) {
		this.problem_nature_id = problem_nature_id;
	}
	
	@Column(name="problem_nature_name")
	public String getProblem_nature_name() {
		return problem_nature_name;
	}
	public void setProblem_nature_name(String problem_nature_name) {
		this.problem_nature_name = problem_nature_name;
	}

}
