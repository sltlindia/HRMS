package com.hrms.recruitement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="softskill_criteria_tbl")
public class SoftskillCriteriaBean {

	private int softskill_criteria_id;
	private String softskill_criteria_name;
	
	public SoftskillCriteriaBean(){}
	
	
	

	public SoftskillCriteriaBean( String softskill_criteria_name) {
		this.softskill_criteria_name = softskill_criteria_name;
	}



	@Id 
	@Column(name="softskill_criteria_id")
	@GeneratedValue
	public int getSoftskill_criteria_id() {
		return softskill_criteria_id;
	}

	public void setSoftskill_criteria_id(int softskill_criteria_id) {
		this.softskill_criteria_id = softskill_criteria_id;
	}

	@Column(name="softskill_criteria_name")
	public String getSoftskill_criteria_name() {
		return softskill_criteria_name;
	}

	public void setSoftskill_criteria_name(String softskill_criteria_name) {
		this.softskill_criteria_name = softskill_criteria_name;
	}
	
	
}
