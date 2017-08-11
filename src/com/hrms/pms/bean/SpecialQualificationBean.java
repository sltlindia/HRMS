package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="special_qualification_tbl")
public class SpecialQualificationBean implements Serializable{

	
	private int special_qualification_id;
	private String special_qualification;
	
	
	public SpecialQualificationBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@Column(name="special_qualification_id")
    @GeneratedValue
	public int getSpecial_qualification_id() {
		return special_qualification_id;
	}

	public void setSpecial_qualification_id(int special_qualification_id) {
		this.special_qualification_id = special_qualification_id;
	}
	
	
	@Column(name="special_qualification")
	public String getSpecial_qualification() {
		return special_qualification;
	}

	public void setSpecial_qualification(String special_qualification) {
		this.special_qualification = special_qualification;
	}
	
	
	
}
