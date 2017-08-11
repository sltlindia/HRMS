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
@Table(name="vacancy_payroll_hr_info_tbl")
public class VacancyPayrollHrInfoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public VacancyPayrollHrInfoBean(){}
	
	private VacancyFormBean vacancyFormBean;
	private VacancyGradeLevelBean vacancyGradeLevelBean;
	private EmployeeBean employeeBean;
	
	private String targated_closed_date;
	private String payroll_company;
	private String payroll_type;
	private int vacancy_payroll_hr_info_id;

	@ManyToOne
	@JoinColumn(name="vacancy_id")
	public VacancyFormBean getVacancyFormBean() {
		return vacancyFormBean;
	}
	public void setVacancyFormBean(VacancyFormBean vacancyFormBean) {
		this.vacancyFormBean = vacancyFormBean;
	}
	
	@ManyToOne
	@JoinColumn(name="vacancy_grade_level_id")
	public VacancyGradeLevelBean getVacancyGradeLevelBean() {
		return vacancyGradeLevelBean;
	}
	public void setVacancyGradeLevelBean(VacancyGradeLevelBean vacancyGradeLevelBean) {
		this.vacancyGradeLevelBean = vacancyGradeLevelBean;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	public String getTargated_closed_date() {
		return targated_closed_date;
	}
	public void setTargated_closed_date(String targated_closed_date) {
		this.targated_closed_date = targated_closed_date;
	}
	
	public String getPayroll_company() {
		return payroll_company;
	}
	public void setPayroll_company(String payroll_company) {
		this.payroll_company = payroll_company;
	}
	
	public String getPayroll_type() {
		return payroll_type;
	}
	public void setPayroll_type(String payroll_type) {
		this.payroll_type = payroll_type;
	}
	
	@Id
	@GeneratedValue
	@Column(name="vacancy_payroll_hr_info_id")
	public int getVacancy_payroll_hr_info_id() {
		return vacancy_payroll_hr_info_id;
	}
	public void setVacancy_payroll_hr_info_id(int vacancy_payroll_hr_info_id) {
		this.vacancy_payroll_hr_info_id = vacancy_payroll_hr_info_id;
	}
	public VacancyPayrollHrInfoBean(VacancyFormBean vacancyFormBean, VacancyGradeLevelBean vacancyGradeLevelBean,
			EmployeeBean employeeBean, String targated_closed_date, String payroll_company, String payroll_type) {
		super();
		this.vacancyFormBean = vacancyFormBean;
		this.vacancyGradeLevelBean = vacancyGradeLevelBean;
		this.employeeBean = employeeBean;
		this.targated_closed_date = targated_closed_date;
		this.payroll_company = payroll_company;
		this.payroll_type = payroll_type;
	}
	
	
	

}
