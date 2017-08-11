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
@Table(name="post_graduate_specification_tbl")
public class PostGraduateSpecificationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostGraduateSpecificationBean(){}
	
	private PostGraduateQualificationBean postGraduateQualificationBean;
	
	private int post_graduate_specification_id;
	private String post_graduate_specification_name;

	@ManyToOne
	@JoinColumn(name="post_graduate_qualification_id")
	public PostGraduateQualificationBean getPostGraduateQualificationBean() {
		return postGraduateQualificationBean;
	}
	public void setPostGraduateQualificationBean(PostGraduateQualificationBean postGraduateQualificationBean) {
		this.postGraduateQualificationBean = postGraduateQualificationBean;
	}

	@Id
	@GeneratedValue
	@Column(name="post_graduate_specification_id")
	public int getPost_graduate_specification_id() {
		return post_graduate_specification_id;
	}
	public void setPost_graduate_specification_id(int post_graduate_specification_id) {
		this.post_graduate_specification_id = post_graduate_specification_id;
	}
	public String getPost_graduate_specification_name() {
		return post_graduate_specification_name;
	}
	public void setPost_graduate_specification_name(String post_graduate_specification_name) {
		this.post_graduate_specification_name = post_graduate_specification_name;
	}
	
	
	
}
