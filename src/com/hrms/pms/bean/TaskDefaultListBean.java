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
@Table(name="task_default_list_tbl")
public class TaskDefaultListBean implements Serializable{
	
	private int task_default_list_id;
	private String task_default_list_name;
	
	private DepartmentBean departmentBean;
	
	
	public TaskDefaultListBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id 
	@Column(name="task_default_list_id")
	@GeneratedValue
	public int getTask_default_list_id() {
		return task_default_list_id;
	}
	public void setTask_default_list_id(int task_default_list_id) {
		this.task_default_list_id = task_default_list_id;
	}
	public String getTask_default_list_name() {
		return task_default_list_name;
	}
	public void setTask_default_list_name(String task_default_list_name) {
		this.task_default_list_name = task_default_list_name;
	}
	
	
	@ManyToOne
	@JoinColumn(name="department_id")
	public DepartmentBean getDepartmentBean() {
		return departmentBean;
	}
	public void setDepartmentBean(DepartmentBean departmentBean) {
		this.departmentBean = departmentBean;
	}
	
	
	
	

}
