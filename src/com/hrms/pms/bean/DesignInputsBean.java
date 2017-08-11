package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="design_inputs_tbl")
public class DesignInputsBean implements Serializable{

	private int design_inputs_id;
	private String design_inputs_name;
	
	public DesignInputsBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="design_inputs_id")
    @GeneratedValue
	public int getDesign_inputs_id() {
		return design_inputs_id;
	}
	public void setDesign_inputs_id(int design_inputs_id) {
		this.design_inputs_id = design_inputs_id;
	}

	public String getDesign_inputs_name() {
		return design_inputs_name;
	}

	public void setDesign_inputs_name(String design_inputs_name) {
		this.design_inputs_name = design_inputs_name;
	}
	
	
	
	
	
	
}
