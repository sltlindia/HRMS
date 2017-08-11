package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="source_of_resume_tbl")
public class SourceOfResumeBean implements Serializable{

	@Id 
    @GeneratedValue
	private int source_of_resume_id;
	private String source_of_resume_name;
	
	public SourceOfResumeBean(){
		
	}
	
	@Id
	@Column(name = "source_of_resume_id")
	@GeneratedValue
	public int getSource_of_resume_id() {
		return source_of_resume_id;
	}
	public void setSource_of_resume_id(int source_of_resume_id) {
		this.source_of_resume_id = source_of_resume_id;
	}
	@Column(name = "source_of_resume_name")
	public String getSource_of_resume_name() {
		return source_of_resume_name;
	}
	public void setSource_of_resume_name(String source_of_resume_name) {
		this.source_of_resume_name = source_of_resume_name;
	}
	
	
	
	
	
}
