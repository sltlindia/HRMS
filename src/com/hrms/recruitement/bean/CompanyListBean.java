package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_list_tbl")
public class CompanyListBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int company_list_id;
	private String company_name;
	private String company_code;
	
	public CompanyListBean() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Id
	@Column(name="company_list_id")
	@GeneratedValue
	public int getCompany_list_id() {
		return company_list_id;
	}

	public void setCompany_list_id(int company_list_id) {
		this.company_list_id = company_list_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_code() {
		return company_code;
	}

	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}

	

}
