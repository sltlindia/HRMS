package com.hrms.exitformality.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="exit_interview_employee_tbl")
public class ExitInterviewEmployeeBean {
	
	private int exit_interview_employee_id;
	private String department;
	private String reporting_manager;
	private String designation;
	private String date_of_joining;
	private String termination_date;
	private String additional_comment;
	
	private EmployeeBean employeeBean;
	
	public ExitInterviewEmployeeBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ExitInterviewEmployeeBean(String department, String reporting_manager, String designation,
			String date_of_joining, String termination_date ,EmployeeBean employeeBean) {
		super();
		this.department = department;
		this.reporting_manager = reporting_manager;
		this.designation = designation;
		this.date_of_joining = date_of_joining;
		this.termination_date = termination_date;
		this.employeeBean = employeeBean;
	}



	@Id 
    @Column(name="exit_interview_employee_id")
    @GeneratedValue
	public int getExit_interview_employee_id() {
		return exit_interview_employee_id;
	}
	public void setExit_interview_employee_id(int exit_interview_employee_id) {
		this.exit_interview_employee_id = exit_interview_employee_id;
	}
	
	@Column(name="department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(name="reporting_manager")
	public String getReporting_manager() {
		return reporting_manager;
	}
	public void setReporting_manager(String reporting_manager) {
		this.reporting_manager = reporting_manager;
	}
	
	@Column(name="designation")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Column(name="date_of_joining")
	public String getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
	
	@Column(name="termination_date")
	public String getTermination_date() {
		return termination_date;
	}
	public void setTermination_date(String termination_date) {
		this.termination_date = termination_date;
	}


	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}



	public String getAdditional_comment() {
		return additional_comment;
	}


	public void setAdditional_comment(String additional_comment) {
		this.additional_comment = additional_comment;
	}



	
	
	
}