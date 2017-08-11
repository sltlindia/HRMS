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
@Table(name="goal_department_tbl")
public class GoalDepartmentBean implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int goal_department_id;
	private String goal_department_name;
	
	
	
	public  GoalDepartmentBean() {
		// TODO Auto-generated constructor stub
	}
	 @Id
	 @Column(name="goal_department_id")
	 @GeneratedValue
	public int getGoal_department_id() {
		return goal_department_id;
	}
	public void setGoal_department_id(int goal_department_id) {
		this.goal_department_id = goal_department_id;
	}
	@Column(name="goal_department_name")
	public String getGoal_department_name() {
		return goal_department_name;
	}
	public void setGoal_department_name(String goal_department_name) {
		this.goal_department_name = goal_department_name;
	}

	
}
