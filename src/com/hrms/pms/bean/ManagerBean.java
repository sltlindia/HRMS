package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="manager_tbl")
public class ManagerBean implements Serializable {

	private int manager_id;
	private String manager_name;
	private String employee_code;
	
	public ManagerBean() {
		// TODO Auto-generated constructor stub
	}
	public ManagerBean(String manager_name, String employee_code) {
		super();
		this.manager_name = manager_name;
		this.employee_code = employee_code;
	}
	
	@Id
	@Column(name="manager_id")
	@GeneratedValue
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
	
	@Column(name="emp_code")
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	
}
