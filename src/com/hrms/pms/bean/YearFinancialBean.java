package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="yearly_financial_goal_tbl")
public class YearFinancialBean implements Serializable {

	private int yearly_financial_goal_id;
	private String goal_details;
	private String operating_defination;
	private String target;
	
	private ScoreAreaBean scoreAreaBean;
	private UnitOfMeasurementBean unitOfMeasurementBean;
	private YearBean yearBean;
	private EmployeeBean employeeBean;
	private GoalDepartmentBean goalDepartmentBean;
	
	public YearFinancialBean() {

	}
	
	
	public YearFinancialBean(String goal_details,
			String operating_defination, String target, ScoreAreaBean scoreAreaBean, UnitOfMeasurementBean unitOfMeasurementBean,YearBean yearBean,EmployeeBean employeeBean, GoalDepartmentBean goalDepartmentBean) {
		this.goal_details = goal_details;
		this.operating_defination = operating_defination;
		this.target = target;
		this.scoreAreaBean = scoreAreaBean;
		this.unitOfMeasurementBean = unitOfMeasurementBean;
		this.yearBean = yearBean;
		this.employeeBean = employeeBean;
		this.goalDepartmentBean = goalDepartmentBean;
		
	}


	 @Id
	 @Column(name="yearly_financial_goal_id")
	 @GeneratedValue
	public int getYearly_financial_goal_id() {
		return yearly_financial_goal_id;
	}


	public void setYearly_financial_goal_id(int yearly_financial_goal_id) {
		this.yearly_financial_goal_id = yearly_financial_goal_id;
	}

	 @Column(name="goal_details")
	public String getGoal_details() {
		return goal_details;
	}


	public void setGoal_details(String goal_details) {
		this.goal_details = goal_details;
	}


	public String getOperating_defination() {
		return operating_defination;
	}


	public void setOperating_defination(String operating_defination) {
		this.operating_defination = operating_defination;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public ScoreAreaBean getScoreAreaBean() {
		return scoreAreaBean;
	}


	public void setScoreAreaBean(ScoreAreaBean scoreAreaBean) {
		this.scoreAreaBean = scoreAreaBean;
	}


	public UnitOfMeasurementBean getUnitOfMeasurementBean() {
		return unitOfMeasurementBean;
	}


	public void setUnitOfMeasurementBean(UnitOfMeasurementBean unitOfMeasurementBean) {
		this.unitOfMeasurementBean = unitOfMeasurementBean;
	}


	public YearBean getYearBean() {
		return yearBean;
	}


	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}


	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}


	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}


	public GoalDepartmentBean getGoalDepartmentBean() {
		return goalDepartmentBean;
	}


	public void setGoalDepartmentBean(GoalDepartmentBean goalDepartmentBean) {
		this.goalDepartmentBean = goalDepartmentBean;
	}


	
	
	
	
	
	

}
