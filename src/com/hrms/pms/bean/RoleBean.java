package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="role_tbl")
public class RoleBean implements Serializable{

	private int role_id;
	private String role_type;
	private String role_authority;
	private String level;
	private String level_name;
	
	
	@Id 
    @Column(name="role_id")
    @GeneratedValue
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	@Column(name="role_type")
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	
	@Column(name="role_authority")
	public String getRole_authority() {
		return role_authority;
	}
	public void setRole_authority(String role_authority) {
		this.role_authority = role_authority;
	}
	
	@Column(name="level")
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	@Column(name="level_name")
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	
	
	
}
