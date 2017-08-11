package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="under_graduate_qualification_tbl")
public class UnderGraduateQualificationBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int under_graduate_qualification_id;
	private String under_graduate_qualification_name;
	
	public UnderGraduateQualificationBean(){}

	
	@Id
	@GeneratedValue
	@Column(name="under_graduate_qualification_id")
	public int getUnder_graduate_qualification_id() {
		return under_graduate_qualification_id;
	}

	public void setUnder_graduate_qualification_id(int under_graduate_qualification_id) {
		this.under_graduate_qualification_id = under_graduate_qualification_id;
	}

	@Column(name="under_graduate_qualification_name")
	public String getUnder_graduate_qualification_name() {
		return under_graduate_qualification_name;
	}

	public void setUnder_graduate_qualification_name(String under_graduate_qualification_name) {
		this.under_graduate_qualification_name = under_graduate_qualification_name;
	}
	
	

}
