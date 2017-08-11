package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.DepartmentBean;

@Entity
@Table(name = "department_designation_tbl")
public class DepartmentDesignationBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int department_designation_id;
	private String designation_name;
	
	private DepartmentBean departmentBean;

	
	
	public DepartmentDesignationBean() {
	}

	public DepartmentDesignationBean(String designation_name,
			DepartmentBean departmentBean) {

		this.designation_name = designation_name;
		this.departmentBean = departmentBean;
	}

	@Id
	@GeneratedValue
	public int getDepartment_designation_id() {
		return department_designation_id;
	}

	public void setDepartment_designation_id(int department_designation_id) {
		this.department_designation_id = department_designation_id;
	}

	public String getDesignation_name() {
		return designation_name;
	}

	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

	
	@ManyToOne
	@JoinColumn(name = "department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}

	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}
	
	
	
	
	
}
