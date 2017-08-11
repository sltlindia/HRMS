package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="under_graduate_specification_tbl")
public class UnderGraduateSpecificationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public UnderGraduateSpecificationBean(){}
	
	private int under_graduate_specification_id;
	private String under_graduate_specification_name;
	private UnderGraduateQualificationBean underGraduateQualificationBean;


	@Id
	@GeneratedValue
	@Column(name="under_graduate_specification_id")
	public int getUnder_graduate_specification_id() {
		return under_graduate_specification_id;
	}
	public void setUnder_graduate_specification_id(int under_graduate_specification_id) {
		this.under_graduate_specification_id = under_graduate_specification_id;
	}
	
	@Column(name="under_graduate_specification_name")
	public String getUnder_graduate_specification_name() {
		return under_graduate_specification_name;
	}
	public void setUnder_graduate_specification_name(String under_graduate_specification_name) {
		this.under_graduate_specification_name = under_graduate_specification_name;
	}
	
	@ManyToOne
	@JoinColumn(name="under_graduate_qualification_id")
	public UnderGraduateQualificationBean getUnderGraduateQualificationBean() {
		return underGraduateQualificationBean;
	}
	public void setUnderGraduateQualificationBean(UnderGraduateQualificationBean underGraduateQualificationBean) {
		this.underGraduateQualificationBean = underGraduateQualificationBean;
	}
	
	
	
	
	
}
