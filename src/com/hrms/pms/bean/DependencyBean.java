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
@Table(name="dependency_tbl")
public class DependencyBean implements Serializable{

	private int dependency_id;
	private int dependent_id;

	private TaskMasterBean taskMasterBean;
	
	@Id 
	@Column(name="dependency_id")
	@GeneratedValue
	public int getDependency_id() {
		return dependency_id;
	}
	public void setDependency_id(int dependency_id) {
		this.dependency_id = dependency_id;
	}
	
	@Column(name="dependent_id")
	public int getDependent_id() {
		return dependent_id;
	}
	public void setDependent_id(int dependent_id) {
		this.dependent_id = dependent_id;
	}
	
	
	@ManyToOne
	@JoinColumn(name="task_master_id")
	public TaskMasterBean getTaskMasterBean() {
		return taskMasterBean;
	}
	public void setTaskMasterBean(TaskMasterBean taskMasterBean) {
		this.taskMasterBean = taskMasterBean;
	}
	
	
	
	
}
