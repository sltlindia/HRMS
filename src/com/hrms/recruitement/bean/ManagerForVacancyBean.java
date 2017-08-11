package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="manager_for_vacancy_tbl")
public class ManagerForVacancyBean implements Serializable{
	
	private int manager_for_vacancy_id;
	private int manager_id;
	private String manager_name;
	private int dept_id;
	
	
	public ManagerForVacancyBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name="manager_for_vacancy_id")
	@GeneratedValue
	public int getManager_for_vacancy_id() {
		return manager_for_vacancy_id;
	}
	public void setManager_for_vacancy_id(int manager_for_vacancy_id) {
		this.manager_for_vacancy_id = manager_for_vacancy_id;
	}
	
	
	@Column(name="manager_id")
	public int getManager_id() {
		return manager_id;
		
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	
	
	@Column(name="manager_name")
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	
	
	@Column(name="dept_id")
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	

}
