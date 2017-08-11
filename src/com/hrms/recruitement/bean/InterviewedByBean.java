package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.dao.LoginDAO;
import com.hrms.recruitement.dao.VacancyFormDAO;
import java.io.Serializable;

@Entity
@Table(name = "interviewed_by_tbl")

public class InterviewedByBean {

	@Id
	@GeneratedValue
	private int interviewed_by_id;
	
	private VacancyFormBean vacancyFormBean;
	private EmployeeBean employeeBean;
	
	
	
	@Id
	@Column(name = "interviewed_by_id")
	@GeneratedValue
	public int getInterviewed_by_id() {
		return interviewed_by_id;
	}
	public void setInterviewed_by_id(int interviewed_by_id) {
		this.interviewed_by_id = interviewed_by_id;
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
	@JoinColumn(name = "employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
}
