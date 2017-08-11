package com.hrms.pms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_update_notification_tbl")
public class ProjectUpdateNotificationBean {

	
	private int project_update_notification_id;
	private int start_date_change;
	private int end_date_change;
	private int resource_change;
	private int show_view;
	
	private EmployeeBean employeeBean;
	private ProjectMasterBean projectMasterBean;
	private TaskMasterBean taskMasterBean;
	
	 @Id
	 @Column(name="project_update_notification_id")
	 @GeneratedValue
	public int getProject_update_notification_id() {
		return project_update_notification_id;
	}
	public void setProject_update_notification_id(int project_update_notification_id) {
		this.project_update_notification_id = project_update_notification_id;
	}
	
	 @Column(name="start_date_change")
	public int getStart_date_change() {
		return start_date_change;
	}
	public void setStart_date_change(int start_date_change) {
		this.start_date_change = start_date_change;
	}
	
	 @Column(name="end_date_change")
	public int getEnd_date_change() {
		return end_date_change;
	}
	public void setEnd_date_change(int end_date_change) {
		this.end_date_change = end_date_change;
	}
	
	 @Column(name="resource_change")
	public int getResource_change() {
		return resource_change;
	}
	public void setResource_change(int resource_change) {
		this.resource_change = resource_change;
	}
	
	 @Column(name="show_view")
	public int getShow_view() {
		return show_view;
	}
	public void setShow_view(int show_view) {
		this.show_view = show_view;
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
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}
	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}
	
	@ManyToOne
	@JoinColumn(name="task_master_id")
	public TaskMasterBean getTaskMasterBean() {
		return taskMasterBean;
	}
	public void setTaskMasterBean(TaskMasterBean taskMasterBean) {
		this.taskMasterBean = taskMasterBean;
	}
	
	
	
	
	
	
}
