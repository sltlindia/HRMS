package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diploma_course_tbl")
public class DiplomaCourseBean implements Serializable{

	
	private int diploma_course_id;
	private String diploma_course;
	
	public DiplomaCourseBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@Column(name="diploma_course_id")
    @GeneratedValue
	public int getDiploma_course_id() {
		return diploma_course_id;
	}

	public void setDiploma_course_id(int diploma_course_id) {
		this.diploma_course_id = diploma_course_id;
	}

	
	@Column(name="diploma_course")
	public String getDiploma_course() {
		return diploma_course;
	}

	public void setDiploma_course(String diploma_course) {
		this.diploma_course = diploma_course;
	}
	
	
	
}
