package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post_graduate_qualification_tbl")
public class PostGraduateQualificationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostGraduateQualificationBean(){}
	
	private int post_graduate_qualification_id;
	private String post_graduate_qualification_name;
	
	@Id
	@GeneratedValue
	@Column(name="post_graduate_qualification_id")
	public int getPost_graduate_qualification_id() {
		return post_graduate_qualification_id;
	}
	public void setPost_graduate_qualification_id(int post_graduate_qualification_id) {
		this.post_graduate_qualification_id = post_graduate_qualification_id;
	}
	
	@Column(name="post_graduate_qualification_name")
	public String getPost_graduate_qualification_name() {
		return post_graduate_qualification_name;
	}
	public void setPost_graduate_qualification_name(String post_graduate_qualification_name) {
		this.post_graduate_qualification_name = post_graduate_qualification_name;
	}
	
	

}
