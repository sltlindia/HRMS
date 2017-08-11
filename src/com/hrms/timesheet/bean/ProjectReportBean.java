package com.hrms.timesheet.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;

@Entity
@Table(name="employee_reort")
public class ProjectReportBean implements Serializable {
	
	private int project_report_id;
	private String no_of_employees;
	
	private EmployeeBean employeeBean;
	private ProjectMasterBean projectMasterBean;
	
	@Id
	@Column(name="project_report_id")
	@GeneratedValue
	public int getProject_report_id() {
		return project_report_id;
	}
	public void setProject_report_id(int project_report_id) {
		this.project_report_id = project_report_id;
	}
	
	@Column(name="no_of_employees")
	public String getNo_of_employees() {
		return no_of_employees;
	}
	public void setNo_of_employees(String no_of_employees) {
		this.no_of_employees = no_of_employees;
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
	
	
}
