package com.hrms.corehr.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="and_extno_tbl")
public class ExtentionNumberBean implements Serializable{

	public int ID;
	public String Name;
	public String Department_name;
	public String Ext_No;
	public String companyname;
	public ExtentionNumberBean(int iD, String name, String department_name, String ext_No, String companyname) {
		super();
		ID = iD;
		Name = name;
		Department_name = department_name;
		Ext_No = ext_No;
		companyname = companyname;
	}
	
	public ExtentionNumberBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
    @Column(name="id")
    @GeneratedValue
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Column(name="name")
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Column(name="departmentname")
	public String getDepartment_name() {
		return Department_name;
	}
	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}
	@Column(name="extno")
	public String getExt_No() {
		return Ext_No;
	}
	public void setExt_No(String ext_No) {
		Ext_No = ext_No;
	}

	@Column(name="companyname")
	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	
	
}
