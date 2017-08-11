package com.hrms.timesheet.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="timesheet_unplan_project_tbl")
public class UnplanProjectBean implements Serializable {

	private int timesheet_unplan_project_id;
	private String project_name;
	private String task_name;
	private double worked_hours;
	private double percentage_completed;
	private String employee_comment;
	private String manager_comment;
	private String task_time_status;
	private String approval_status;
	private String rejection_reason;
	private String date;
	
	private EmployeeBean employeeBean;
	private DayBean dayBean;
	
	public UnplanProjectBean() {

	}
	



	public UnplanProjectBean(String project_name, String task_name, double worked_hours, String employee_comment,
			String task_time_status, String approval_status, String date, EmployeeBean employeeBean, DayBean dayBean, double percentage_completed) {
		super();
		this.project_name = project_name;
		this.task_name = task_name;
		this.worked_hours = worked_hours;
		this.employee_comment = employee_comment;
		this.task_time_status = task_time_status;
		this.approval_status = approval_status;
		this.date = date;
		this.employeeBean = employeeBean;
		this.dayBean = dayBean;
		this.percentage_completed = percentage_completed;
	}




	@Id
	@Column(name="timesheet_unplan_project_id")
	@GeneratedValue
	public int getTimesheet_unplan_project_id() {
		return timesheet_unplan_project_id;
	}
	public void setTimesheet_unplan_project_id(int timesheet_unplan_project_id) {
		this.timesheet_unplan_project_id = timesheet_unplan_project_id;
	}
	
	@Column(name="project_name")
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	@Column(name="task_name")
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	@Column(name="worked_hours")
	public double getWorked_hours() {
		return worked_hours;
	}
	public void setWorked_hours(double worked_hours) {
		this.worked_hours = worked_hours;
	}
	
	@Column(name="employee_comment")
	public String getEmployee_comment() {
		return employee_comment;
	}
	public void setEmployee_comment(String employee_comment) {
		this.employee_comment = employee_comment;
	}
	
	@Column(name="manager_comment")
	public String getManager_comment() {
		return manager_comment;
	}
	public void setManager_comment(String manager_comment) {
		this.manager_comment = manager_comment;
	}
	
	@Column(name="task_time_status")
	public String getTask_time_status() {
		return task_time_status;
	}
	public void setTask_time_status(String task_time_status) {
		this.task_time_status = task_time_status;
	}
	
	@Column(name="approval_status")
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	
	@Column(name="rejection_reason")
	public String getRejection_reason() {
		return rejection_reason;
	}
	public void setRejection_reason(String rejection_reason) {
		this.rejection_reason = rejection_reason;
	}

	@Column(name="date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	@JoinColumn(name="day_id")
	public DayBean getDayBean() {
		return dayBean;
	}
	public void setDayBean(DayBean dayBean) {
		this.dayBean = dayBean;
	}

	@Column(name="percentage_completed")
	public double getPercentage_completed() {
		return percentage_completed;
	}
	
	public void setPercentage_completed(double percentage_completed) {
		this.percentage_completed = percentage_completed;
	}
	
	
	
	
	
}
