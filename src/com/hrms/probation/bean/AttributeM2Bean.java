package com.hrms.probation.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="probation_attributes_Indirect_tbl")
public class AttributeM2Bean {
	
	//Probation Attribute M2(Indirect) Bean for Adding,Updating,Deleting Attributes into table probation_attributes_indirect_tbl
		//getter and setter for inserting of all column of probation_attributes_indirect_tbl
	private int probation_attribute_M2_id;
	private String probation_attribute_M2_question;
	private int employee_role;
	
	public AttributeM2Bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Constructor for Attribute M2(Indirect) Bean using field probation_attribute_M2_question (M2=Indirect Employees)
		//for Updation of probation_attribute_M2_question column
	public AttributeM2Bean(String probation_attribute_M2_question,int employee_role) {
		super();
		this.probation_attribute_M2_question = probation_attribute_M2_question;
		this.employee_role = employee_role;
	}
	@Id
	@Column(name="probation_attributes_m2_id")
    @GeneratedValue
    
    
  //getter and setter method for column probation_attribute_M2_id of probation_attributes_direct_tbl
	public int getProbation_attribute_M2_id() {
		return probation_attribute_M2_id;
	}
	public void setProbation_attribute_M2_id(int probation_attribute_M2_id) {
		this.probation_attribute_M2_id = probation_attribute_M2_id;
	}
	
	//getter and setter method for column probation_attribute_M2_question of probation_attributes_direct_tbl
	@Column(name="probation_attributes_m2_question")
	public String getProbation_attribute_M2_question() {
		return probation_attribute_M2_question;
	}
	public void setProbation_attribute_M2_question(String probation_attribute_M2_question) {
		this.probation_attribute_M2_question = probation_attribute_M2_question;
	}

	@Column(name="employee_role")
	public int getEmployee_role() {
		return employee_role;
	}

	public void setEmployee_role(int employee_role) {
		this.employee_role = employee_role;
	}
	

	
	
	
}
