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
@Table(name="sub_goal_allocation_tbl")
public class SubGoalAllocationBean  implements Serializable{
	 
	private int sub_goal_allocation_id;
	private String sub_goal_name;
	
	private GoalAllocationBean goalAllocationBean;
	
	public SubGoalAllocationBean() {
		// TODO Auto-generated constructor stub
	}
	
	public SubGoalAllocationBean(String sub_goal_name,GoalAllocationBean goalAllocationBean) {
		this.sub_goal_name = sub_goal_name;
		this.goalAllocationBean = goalAllocationBean;
		
	}

	@Id
	@Column(name="sub_goal_allocation_id")
    @GeneratedValue
	public int getSub_goal_allocation_id() {
		return sub_goal_allocation_id;
	}

	public void setSub_goal_allocation_id(int sub_goal_allocation_id) {
		this.sub_goal_allocation_id = sub_goal_allocation_id;
	}

	@Column(name="sub_goal_name")
	public String getSub_goal_name() {
		return sub_goal_name;
	}

	public void setSub_goal_name(String sub_goal_name) {
		this.sub_goal_name = sub_goal_name;
	}

	
	@ManyToOne
	@JoinColumn(name="goal_allocation_id")
	public GoalAllocationBean getGoalAllocationBean() {
		return goalAllocationBean;
	}

	public void setGoalAllocationBean(GoalAllocationBean goalAllocationBean) {
		this.goalAllocationBean = goalAllocationBean;
	}


	
	
	
	
	
}
