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
@Table(name="goal_employee_allocation_tbl")
public class GoalEmployeeAllocationBean implements Serializable{

		private int goal_employee_allocation_id;
		
		
		private SubGoalAllocationBean subGoalAllocationBean;
		private EmployeeBean employeeBean;
		
		public GoalEmployeeAllocationBean(SubGoalAllocationBean subGoalAllocationBean, EmployeeBean employeeBean) {
			this.subGoalAllocationBean = subGoalAllocationBean;
			this.employeeBean = employeeBean;
		
		}
		
		public GoalEmployeeAllocationBean() {
			// TODO Auto-generated constructor stub
		}
		
		@Id
		@Column(name="goal_employee_allocation_id")
	    @GeneratedValue
		public int getGoal_employee_allocation_id() {
			return goal_employee_allocation_id;
		}
		public void setGoal_employee_allocation_id(int goal_employee_allocation_id) {
			this.goal_employee_allocation_id = goal_employee_allocation_id;
		}
		
	
		
		
		@ManyToOne
		@JoinColumn(name="sub_goal_allocation_id")
		public SubGoalAllocationBean getSubGoalAllocationBean() {
			return subGoalAllocationBean;
		}
		
		public void setSubGoalAllocationBean(SubGoalAllocationBean subGoalAllocationBean) {
			this.subGoalAllocationBean = subGoalAllocationBean;
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
