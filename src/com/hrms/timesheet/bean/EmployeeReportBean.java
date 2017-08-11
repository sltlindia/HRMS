package com.hrms.timesheet.bean;

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
public class EmployeeReportBean {

	private int employee_report_id;
	private String total_hrs;
	
	private EmployeeBean employeebean;
	private ProjectMasterBean projectMasterBean;
	
	
	@Id
	@Column(name="employee_report_id")
	@GeneratedValue
	public int getEmployee_report_id() {
		return employee_report_id;
	}
	public void setEmployee_report_id(int employee_report_id) {
		this.employee_report_id = employee_report_id;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeebean() {
		return employeebean;
	}
	
	public void setEmployeebean(EmployeeBean employeebean) {
		this.employeebean = employeebean;
	}
	
	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}
	
	
	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}
	public void setTotal_hrs(String total_hrs) {
		this.total_hrs = total_hrs;
	}
	
	
	@Column(name="total_hrs")
	public String getTotal_hrs() {
		return total_hrs;
	}
	
	
	
}
