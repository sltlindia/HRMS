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
@Table(name="yearly_goal_tbl")
public class YearlyGoalBean implements Serializable {

	private int yearly_goal_id;
	private double amount_of_goal;
	
	private GoalDefinitionBean goalDefinitionBean;
	private YearBean yearBean;
	private UnitOfMeasurementBean unitOfMeasurementBean;
	private EmployeeBean employeeBean;
	
	
	
	public YearlyGoalBean() {
		// TODO Auto-generated constructor stub
	}
	
	public YearlyGoalBean(double amount_of_goal,GoalDefinitionBean goalDefinitionBean,YearBean yearBean,UnitOfMeasurementBean unitOfMeasurementBean,EmployeeBean employeeBean) {

	this.amount_of_goal = amount_of_goal;
	this.goalDefinitionBean = goalDefinitionBean;
	this.yearBean = yearBean;
	this.unitOfMeasurementBean = unitOfMeasurementBean;
	this.employeeBean = employeeBean;
	
	}
	
	@Id
	@Column(name="yearly_goal_id")
    @GeneratedValue
	public int getYearly_goal_id() {
		return yearly_goal_id;
	}
	public void setYearly_goal_id(int yearly_goal_id) {
		this.yearly_goal_id = yearly_goal_id;
	}
	public double getAmount_of_goal() {
		return amount_of_goal;
	}
	public void setAmount_of_goal(double amount_of_goal) {
		this.amount_of_goal = amount_of_goal;
	}
	
	@ManyToOne
	@JoinColumn(name="goal_definition_id")
	public GoalDefinitionBean getGoalDefinitionBean() {
		return goalDefinitionBean;
	}
	public void setGoalDefinitionBean(GoalDefinitionBean goalDefinitionBean) {
		this.goalDefinitionBean = goalDefinitionBean;
	}
	
	@ManyToOne
	@JoinColumn(name="year_id")
	public YearBean getYearBean() {
		return yearBean;
	}
	public void setYearBean(YearBean yearBean) {
		this.yearBean = yearBean;
	}
	
	@ManyToOne
	@JoinColumn(name="unit_of_measurement_id")
	public UnitOfMeasurementBean getUnitOfMeasurementBean() {
		return unitOfMeasurementBean;
	}
	public void setUnitOfMeasurementBean(UnitOfMeasurementBean unitOfMeasurementBean) {
		this.unitOfMeasurementBean = unitOfMeasurementBean;
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
