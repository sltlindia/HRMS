package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
@Entity
@Table(name = "vacancy_approval_tbl")
public class VacancyApprovalBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int vacancy_approval_id;
	private VacancyFormBean vacancyFormBean;
	private EmployeeBean employeeBean;
	private String approval_datetime;
	private String approval_status;
	private String reason;
	private int approval_number;
	private int show_view;
	
	public VacancyApprovalBean(){}

	@Id
	@Column(name = "vacancy_approval_id")
	@GeneratedValue
	public int getVacancy_approval_id() {
		return vacancy_approval_id;
	}

	public void setVacancy_approval_id(int vacancy_approval_id) {
		this.vacancy_approval_id = vacancy_approval_id;
	}

	@ManyToOne
	@JoinColumn(name = "vacancy_id")
	public VacancyFormBean getVacancyFormBean() {
		return vacancyFormBean;
	}

	public void setVacancyFormBean(VacancyFormBean vacancyFormBean) {
		this.vacancyFormBean = vacancyFormBean;
	}

	@ManyToOne
	@JoinColumn(name= "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	@Column(name = "approval_datetime")
	public String getApproval_datetime() {
		return approval_datetime;
	}

	public void setApproval_datetime(String approval_datetime) {
		this.approval_datetime = approval_datetime;
	}

	@Column(name = "approval_status")
	public String getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	
	@Column(name = "reason")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

	public int getApproval_number() {
		return approval_number;
	}

	public void setApproval_number(int approval_number) {
		this.approval_number = approval_number;
	}
	
	
	

	public int getShow_view() {
		return show_view;
	}

	public void setShow_view(int show_view) {
		this.show_view = show_view;
	}

	public VacancyApprovalBean(VacancyFormBean vacancyFormBean, EmployeeBean employeeBean, String approval_datetime,
			String approval_status, int approval_number, int show_view) {

		this.vacancyFormBean = vacancyFormBean;
		this.employeeBean = employeeBean;
		this.approval_datetime = approval_datetime;
		this.approval_status = approval_status;
		this.approval_number = approval_number;
		this.show_view = show_view;
	}

	

	
	
	
	
}
