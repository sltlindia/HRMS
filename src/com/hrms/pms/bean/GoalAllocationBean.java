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
@Table(name="goal_allocation_tbl")
public class GoalAllocationBean implements Serializable {

	private int goal_allocation_id;
	
	private YearlyGoalBean yearlyGoalBean;
	private EmployeeBean employeeBean;
	
	
	public GoalAllocationBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GoalAllocationBean(YearlyGoalBean yearlyGoalBean,EmployeeBean employeeBean) {
		this.yearlyGoalBean = yearlyGoalBean;
		this.employeeBean = employeeBean;
	}
	
	
	@Id
	@Column(name="goal_allocation_id")
    @GeneratedValue
	public int getGoal_allocation_id() {
		return goal_allocation_id;
	}
	public void setGoal_allocation_id(int goal_allocation_id) {
		this.goal_allocation_id = goal_allocation_id;
	}
	
	@ManyToOne
	@JoinColumn(name="yearly_goal_id")
	public YearlyGoalBean getYearlyGoalBean() {
		return yearlyGoalBean;
	}
	public void setYearlyGoalBean(YearlyGoalBean yearlyGoalBean) {
		this.yearlyGoalBean = yearlyGoalBean;
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
