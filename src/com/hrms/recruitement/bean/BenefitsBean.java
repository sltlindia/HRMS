package com.hrms.recruitement.bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="benefits_tbl")
public class BenefitsBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int benefit_id;
	private String benefit_name;
	
	public BenefitsBean() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="benefit_id")
	@GeneratedValue
	public int getBenefit_id() {
		return benefit_id;
	}

	public void setBenefit_id(int benefit_id) {
		this.benefit_id = benefit_id;
	}

	public String getBenefit_name() {
		return benefit_name;
	}

	public void setBenefit_name(String benefit_name) {
		this.benefit_name = benefit_name;
	}

	
	
			


}
