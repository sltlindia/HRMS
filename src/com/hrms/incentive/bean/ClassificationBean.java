package com.hrms.incentive.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="classification_tbl")
public class ClassificationBean {

	private int classification_id;
	private String Classification_name;
	
	/*private ProductMasterBean productMasterBean;*/

	public ClassificationBean() {
		super();
	}

	public ClassificationBean(String classification_name) {
		super();
		Classification_name = classification_name;
	}

	
	
	
	
	
	public ClassificationBean(int classification_id, String classification_name) {
		super();
		this.classification_id = classification_id;
		Classification_name = classification_name;
	}

	@Id 
    @Column(name="classification_id")
    @GeneratedValue
	public int getClassification_id() {
		return classification_id;
	}

	public void setClassification_id(int classification_id) {
		this.classification_id = classification_id;
	}

	@Column(name="classification_name")
	public String getClassification_name() {
		return Classification_name;
	}

	public void setClassification_name(String classification_name) {
		Classification_name = classification_name;
	}

	
	
	
	
}
