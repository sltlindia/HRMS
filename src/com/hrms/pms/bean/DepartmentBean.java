package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department_tbl")
public class DepartmentBean implements Serializable{

	private int department_id;
	private String department_name;
	
	public DepartmentBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id 
	@Column(name="department_id")
	@GeneratedValue
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	@Column(name="department_name")
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	
	
}
