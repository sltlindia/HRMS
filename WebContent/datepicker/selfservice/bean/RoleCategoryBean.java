package com.hrms.selfservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role_category_tbl")
public class RoleCategoryBean {
	
	private int role_category_id;
	private String role_category_name;
	public RoleCategoryBean(String role_category_name) {
		super();
		this.role_category_name = role_category_name;
	}
	public RoleCategoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id 
    @Column(name="role_category_id")
	public int getRole_category_id() {
		return role_category_id;
	}
	public void setRole_category_id(int role_category_id) {
		this.role_category_id = role_category_id;
	}
	 @Column(name="role_category_name")
	public String getRole_category_name() {
		return role_category_name;
	}
	public void setRole_category_name(String role_category_name) {
		this.role_category_name = role_category_name;
	}
	
}
