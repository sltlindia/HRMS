package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="graduate_degree_tbl")
public class GraduateDegreeBean implements Serializable{

	
	private int graduate_degree_id;
	private String graduate_degree;
	
	public GraduateDegreeBean() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="graduate_degree_id")
    @GeneratedValue
	public int getGraduate_degree_id() {
		return graduate_degree_id;
	}

	public void setGraduate_degree_id(int graduate_degree_id) {
		this.graduate_degree_id = graduate_degree_id;
	}

	
	@Column(name="graduate_degree")	
	public String getGraduate_degree() {
		return graduate_degree;
	}

	public void setGraduate_degree(String graduate_degree) {
		this.graduate_degree = graduate_degree;
	}
	
	
	
}
