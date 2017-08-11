package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="project_document_tbl")
public class ProjectDocumentBean implements Serializable {
	
	private int project_document_id;
	private String document_name;
	private String attachment;
	
	private ProjectMasterBean projectMasterBean;

	
	public ProjectDocumentBean() {
		// TODO Auto-generated constructor stub
	}
	
			
	public ProjectDocumentBean(String document_name, String attachment, ProjectMasterBean projectMasterBean) {
		super();
		this.document_name = document_name;
		this.attachment = attachment;
		this.projectMasterBean = projectMasterBean;
	}

	
	
	@Id
	@Column(name="project_document_id")
    @GeneratedValue
	public int getProject_document_id() {
		return project_document_id;
	}

	public void setProject_document_id(int project_document_id) {
		this.project_document_id = project_document_id;
	}

	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@ManyToOne
	@JoinColumn(name="project_master_id")
	public ProjectMasterBean getProjectMasterBean() {
		return projectMasterBean;
	}

	public void setProjectMasterBean(ProjectMasterBean projectMasterBean) {
		this.projectMasterBean = projectMasterBean;
	}
	
	
	

}
