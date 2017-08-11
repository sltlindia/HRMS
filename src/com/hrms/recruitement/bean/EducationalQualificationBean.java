package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="educational_qualification_tbl")
public class EducationalQualificationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int educational_qualification_id;
	private String educational_qualification_name;
	
	public EducationalQualificationBean()
	{}

	@Id
	@Column(name = "educational_qualification_id")
	@GeneratedValue
	public int getEducational_qualification_id() {
		return educational_qualification_id;
	}

	public void setEducational_qualification_id(int educational_qualification_id) {
		this.educational_qualification_id = educational_qualification_id;
	}

	public String getEducational_qualification_name() {
		return educational_qualification_name;
	}

	public void setEducational_qualification_name(String educational_qualification_name) {
		this.educational_qualification_name = educational_qualification_name;
	}
	
	
	
}
