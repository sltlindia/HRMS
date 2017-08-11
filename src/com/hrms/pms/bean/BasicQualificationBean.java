package com.hrms.pms.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="basic_qualification_tbl")
public class BasicQualificationBean implements Serializable{

	
	private int basic_qualification_id;
	private String basic_qualification;
	
	
	public BasicQualificationBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="basic_qualification_id")
    @GeneratedValue
	public int getBasic_qualification_id() {
		return basic_qualification_id;
	}
	public void setBasic_qualification_id(int basic_qualification_id) {
		this.basic_qualification_id = basic_qualification_id;
	}
	
	
	@Column(name="basic_qualification")
	public String getBasic_qualification() {
		return basic_qualification;
	}
	public void setBasic_qualification(String basic_qualification) {
		this.basic_qualification = basic_qualification;
	}
	
	
	
	
    
    
}
