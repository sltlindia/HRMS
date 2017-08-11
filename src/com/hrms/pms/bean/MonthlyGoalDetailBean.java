package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="monthly_goal_detail_tbl")
public class MonthlyGoalDetailBean implements Serializable {
	
	private int monthly_goal_detail_id;
	private String goal;
	private String actual;
	private String comment;
	private String attachment;
	
	private GoalEmployeeAllocationBean goalEmployeeAllocationBean;
	private MonthBean monthBean;
	
	public MonthlyGoalDetailBean() {
		// TODO Auto-generated constructor stub
	}
	
	public MonthlyGoalDetailBean(String goal, String actual, GoalEmployeeAllocationBean goalEmployeeAllocationBean, MonthBean monthBean,String comment,String attachment) {
		this.goal = goal;
		this.actual = actual;
		this.goalEmployeeAllocationBean = goalEmployeeAllocationBean;
		this.monthBean = monthBean;
		this.comment = comment;
		this.attachment = attachment;
	}
	
	public MonthlyGoalDetailBean(String goal, String actual, GoalEmployeeAllocationBean goalEmployeeAllocationBean, MonthBean monthBean,int monthly_goal_detail_id,String comment,String attachment) {
		this.goal = goal;
		this.actual = actual;
		this.goalEmployeeAllocationBean = goalEmployeeAllocationBean;
		this.monthBean = monthBean;
		this.monthly_goal_detail_id = monthly_goal_detail_id;
		this.comment = comment;
		this.attachment = attachment;
	}
	
	
	@Id
	@Column(name="monthly_goal_detail_id")
    @GeneratedValue
	public int getMonthly_goal_detail_id() {
		return monthly_goal_detail_id;
	}
	public void setMonthly_goal_detail_id(int monthly_goal_detail_id) {
		this.monthly_goal_detail_id = monthly_goal_detail_id;
	}
	
	@Column(name="goal")
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	@Column(name="actual")
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	
	@ManyToOne
	@JoinColumn(name="goal_employee_allocation_id")
	public GoalEmployeeAllocationBean getGoalEmployeeAllocationBean() {
		return goalEmployeeAllocationBean;
	}
	public void setGoalEmployeeAllocationBean(GoalEmployeeAllocationBean goalEmployeeAllocationBean) {
		this.goalEmployeeAllocationBean = goalEmployeeAllocationBean;
	}
	
	@ManyToOne
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}
	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}
	@Column(name="comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(name="attachment")
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	

}
