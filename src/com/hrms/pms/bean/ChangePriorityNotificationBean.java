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
@Table(name="change_priority_notification_tbl")
public class ChangePriorityNotificationBean implements Serializable{
	
	private int change_priority_notification_id;
	private int show_notification;
	
	private ProjectMasterBean projectMasterBean;
	private MilestoneBean milestoneBean;
	private TaskMasterBean taskMasterBean;
	private PriorityBean priorityBean;
	private EmployeeBean employeeBean;
	
	public ChangePriorityNotificationBean() {
		// TODO Auto-generated constructor stub
	}
	
	 @Id
	 @Column(name="change_priority_notification_id")
	 @GeneratedValue
	public int getChange_priority_notification_id() {
		return change_priority_notification_id;
	}
	public void setChange_priority_notification_id(int change_priority_notification_id) {
		this.change_priority_notification_id = change_priority_notification_id;
	}
	
	 @Column(name="show_notification")
	public int getShow_notification() {
		return show_notification;
	}
	public void setShow_notification(int show_notification) {
		this.show_notification = show_notification;
	}
	
	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}
	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}
	
	@ManyToOne
	@JoinColumn(name="milestone_id")
	public MilestoneBean getMilestoneBean() {
		return milestoneBean;
	}
	public void setMilestoneBean(MilestoneBean milestoneBean) {
		this.milestoneBean = milestoneBean;
	}
	
	@ManyToOne
	@JoinColumn(name="task_master_id")
	public TaskMasterBean getTaskMasterBean() {
		return taskMasterBean;
	}
	public void setTaskMasterBean(TaskMasterBean taskMasterBean) {
		this.taskMasterBean = taskMasterBean;
	}
	
	@ManyToOne
	@JoinColumn(name="priority_id")
	public PriorityBean getPriorityBean() {
		return priorityBean;
	}
	public void setPriorityBean(PriorityBean priorityBean) {
		this.priorityBean = priorityBean;
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
