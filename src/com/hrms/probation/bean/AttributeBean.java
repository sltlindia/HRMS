package com.hrms.probation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="probation_attributes_direct_tbl")
public class AttributeBean {
	
	//Probation Attribute(Direct) Bean for Adding,Updating,Deleting Attributes into table probation_attributes_direct_tbl
	//getter and setter for inserting of all column of probation_attributes_direct_tbl
	
	private int probation_attribute_id;
	private String probation_attribute_question;
	
	
	// Constructor for Attribute Bean using field probation_attribute_question (M1=Direct Employees)
	//for Updation of probation_attribute_question column 
	public AttributeBean(String probation_attribute_question) {
		super();
		this.probation_attribute_question = probation_attribute_question;
	}
	
	public AttributeBean() {
		super();
		// TODO Auto-generated constructor stub
		// Constructor for Attribute Bean
	}

	@Id
	@Column(name="probation_attribute_id")
    @GeneratedValue
    
    //getter and setter method for column probation_attribute_id of probation_attributes_direct_tbl
	public int getProbation_attribute_id() {
		return probation_attribute_id;
	}
	public void setProbation_attribute_id(int probation_attribute_id) {
		this.probation_attribute_id = probation_attribute_id;
	}
	
	@Column(name="probation_attribute_question")
	
	//getter and setter method for column probation_attribute_question of probation_attributes_direct_tbl
	public String getProbation_attribute_question() {
		return probation_attribute_question;
	}
	public void setProbation_attribute_question(String probation_attribute_question) {
		this.probation_attribute_question = probation_attribute_question;
	}
	
}
