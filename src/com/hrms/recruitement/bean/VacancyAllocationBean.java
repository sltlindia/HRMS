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
@Table(name="vacancy_allocation_tbl")
public class VacancyAllocationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int vacancy_allocation_id;
	private int show_view;
	
	private VacancyFormBean vacancyFormBean;
	private EmployeeBean employeeBean;
	private String allocated_date;
	private String remark;
	public VacancyAllocationBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public VacancyAllocationBean(VacancyFormBean vacancyFormBean, EmployeeBean employeeBean, int show_view, String allocated_date, String remark)
	{
		super();
		this.show_view = show_view;
		this.vacancyFormBean = vacancyFormBean;
		this.employeeBean = employeeBean;
		this.allocated_date = allocated_date;
		this.remark = remark;
	}





	@Id
	@Column(name="vacancy_allocation_id")
	@GeneratedValue
	public int getVacancy_allocation_id() {
		return vacancy_allocation_id;
	}
	public void setVacancy_allocation_id(int vacancy_allocation_id) {
		this.vacancy_allocation_id = vacancy_allocation_id;
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

	@Column(name="show_view")
	public int getShow_view() {
		return show_view;
	}

	public void setShow_view(int show_view) {
		this.show_view = show_view;
	}





	public String getAllocated_date() {
		return allocated_date;
	}





	public void setAllocated_date(String allocated_date) {
		this.allocated_date = allocated_date;
	}





	public String getRemark() {
		return remark;
	}





	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
