package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade_master_tbl")
public class GradeMasterBean implements Serializable
{

	
    private int grade_master_id;
	private String grade_master_name;
    private String grade_master_desc;
    
    
    public GradeMasterBean() {
		// TODO Auto-generated constructor stub
    }

    @Id
    @Column(name="grade_master_id")
    @GeneratedValue
	public int getGrade_master_id() {
		return grade_master_id;
	}


	public void setGrade_master_id(int grade_master_id) {
		this.grade_master_id = grade_master_id;
	}

	@Column(name="grade_master_name")
	public String getGrade_master_name() {
		return grade_master_name;
	}


	public void setGrade_master_name(String grade_master_name) {
		this.grade_master_name = grade_master_name;
	}

	@Column(name="grade_master_desc")
	public String getGrade_master_desc() {
		return grade_master_desc;
	}


	public void setGrade_master_desc(String grade_master_desc) {
		this.grade_master_desc = grade_master_desc;
	}

    
    
    
}