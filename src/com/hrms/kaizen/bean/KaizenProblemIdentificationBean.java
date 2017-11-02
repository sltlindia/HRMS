package com.hrms.kaizen.bean;

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
@Table(name="kaizen_problem_identification_tbl")
public class KaizenProblemIdentificationBean implements Serializable{

	
	private int kaizen_problem_identification_id;
	private String problem_description;
	private String category;
	private String date;
	
	private EmployeeBean employeeBean;
	
	
	
	public KaizenProblemIdentificationBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public KaizenProblemIdentificationBean(String problem_description, String category, EmployeeBean employeeBean,String date) {
		super();
		this.problem_description = problem_description;
		this.category = category;
		this.employeeBean = employeeBean;
		this.date = date;
	}
	
	
	
	
	
	public KaizenProblemIdentificationBean(int kaizen_problem_identification_id, String problem_description,
			String category, EmployeeBean employeeBean,String date) {
		super();
		this.kaizen_problem_identification_id = kaizen_problem_identification_id;
		this.problem_description = problem_description;
		this.category = category;
		this.employeeBean = employeeBean;
		this.date = date;
	}





	@Id 
    @Column(name="kaizen_problem_identification_id")
    @GeneratedValue
	public int getKaizen_problem_identification_id() {
		return kaizen_problem_identification_id;
	}
	public void setKaizen_problem_identification_id(int kaizen_problem_identification_id) {
		this.kaizen_problem_identification_id = kaizen_problem_identification_id;
	}
	public String getProblem_description() {
		return problem_description;
	}
	public void setProblem_description(String problem_description) {
		this.problem_description = problem_description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}

	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
