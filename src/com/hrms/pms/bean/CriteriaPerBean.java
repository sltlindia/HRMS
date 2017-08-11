package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="default_criteria_per_tbl")
public class CriteriaPerBean implements Serializable
{

	@Id @GeneratedValue
    private int default_criteria_per_id;
    private int technical_per;
    private int softskill_per;
    
    
    public CriteriaPerBean() {
		// TODO Auto-generated constructor stub
    }




	public int getDefault_criteria_per_id() {
		return default_criteria_per_id;
	}




	public void setDefault_criteria_per_id(int default_criteria_per_id) {
		this.default_criteria_per_id = default_criteria_per_id;
	}




	public int getTechnical_per() {
		return technical_per;
	}


	public void setTechnical_per(int technical_per) {
		this.technical_per = technical_per;
	}


	public int getSoftskill_per() {
		return softskill_per;
	}


	public void setSoftskill_per(int softskill_per) {
		this.softskill_per = softskill_per;
	}
	
    
    
}
