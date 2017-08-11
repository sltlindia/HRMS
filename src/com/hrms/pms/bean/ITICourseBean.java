package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iti_course_tbl")
public class ITICourseBean implements Serializable{

	
	private int iti_course_id;
	private String iti_course;
	
	public ITICourseBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name="iti_course_id")
    @GeneratedValue
	public int getIti_course_id() {
		return iti_course_id;
	}
	public void setIti_course_id(int iti_course_id) {
		this.iti_course_id = iti_course_id;
	}
	
	
	@Column(name="iti_course")
	public String getIti_course() {
		return iti_course;
	}
	public void setIti_course(String iti_course) {
		this.iti_course = iti_course;
	}
	
	
	
}
