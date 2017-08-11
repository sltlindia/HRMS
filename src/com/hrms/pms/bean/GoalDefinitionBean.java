package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="goal_definition_tbl")
public class GoalDefinitionBean implements Serializable {

	
	private int goal_definition_id;
	private String goal_definition_name;
	private String goal_definition;
	
	private EmployeeBean employeeBean;
	private ScoreAreaBean scoreAreaBean;
	
	public GoalDefinitionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public GoalDefinitionBean(String goal_definition_name,String goal_definition,EmployeeBean employeeBean,ScoreAreaBean scoreAreaBean) {
		this.goal_definition_name = goal_definition_name;
		this.goal_definition = goal_definition;
		this.employeeBean = employeeBean;
		this.scoreAreaBean = scoreAreaBean;
	}

	@Id
	@Column(name="goal_definition_id")
    @GeneratedValue
	public int getGoal_definition_id() {
		return goal_definition_id;
	}

	public void setGoal_definition_id(int goal_definition_id) {
		this.goal_definition_id = goal_definition_id;
	}

	@Column(name="goal_definition_name")
	public String getGoal_definition_name() {
		return goal_definition_name;
	}

	public void setGoal_definition_name(String goal_definition_name) {
		this.goal_definition_name = goal_definition_name;
	}

	@Column(name="goal_definition")
	public String getGoal_definition() {
		return goal_definition;
	}

	public void setGoal_definition(String goal_definition) {
		this.goal_definition = goal_definition;
	}

	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@ManyToOne
	@JoinColumn(name="score_area_id")
	public ScoreAreaBean getScoreAreaBean() {
		return scoreAreaBean;
	}

	public void setScoreAreaBean(ScoreAreaBean scoreAreaBean) {
		this.scoreAreaBean = scoreAreaBean;
	}
	
	
	
	
	
}
