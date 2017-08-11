package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_status_tbl")
public class EmployeeStatusBean implements Serializable{

	
	private int employee_status_id;
	private String employee_status_name;
	
	
	public EmployeeStatusBean() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeStatusBean(int employee_status_id, String employee_status_name) {
		super();
		this.employee_status_id = employee_status_id;
		this.employee_status_name = employee_status_name;
	}


	@Id 
	@Column(name="employee_status_id")
	@GeneratedValue
	public int getEmployee_status_id() {
		return employee_status_id;
	}

	public void setEmployee_status_id(int employee_status_id) {
		this.employee_status_id = employee_status_id;
	}

	@Column(name="employee_status_name")
	public String getEmployee_status_name() {
		return employee_status_name;
	}

	public void setEmployee_status_name(String employee_status_name) {
		this.employee_status_name = employee_status_name;
	}
	
	
	 
	
}
