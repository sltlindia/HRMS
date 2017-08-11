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
@Table(name="project_admin_task_tbl")
public class ProjectAdminTaskBean implements Serializable{

	
	private int project_admin_task_id;
	private String task_name;
	
	
	
	public ProjectAdminTaskBean() {
		// TODO Auto-generated constructor stub
	}
	


	@Id
	@Column(name="project_admin_task_id")
    @GeneratedValue
	public int getProject_admin_task_id() {
		return project_admin_task_id;
	}
	public void setProject_admin_task_id(int project_admin_task_id) {
		this.project_admin_task_id = project_admin_task_id;
	}



	@Column(name="task_name")
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}







	
	
    
    


	
	
}
