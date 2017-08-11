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
@Table(name="comment_task_tbl")
public class CommentTaskBean implements Serializable{
	
	private int comment_task_id;
	private String comment;
	private String time;
	
	private TaskMasterBean taskMasterBean;
	private EmployeeBean employeeBean;
	
	
	public CommentTaskBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CommentTaskBean(String comment, String time, TaskMasterBean taskMasterBean, EmployeeBean employeeBean) {
		super();
		this.comment = comment;
		this.time = time;
		this.taskMasterBean = taskMasterBean;
		this.employeeBean = employeeBean;
	}
	@Id
	@Column(name="comment_task_id")
    @GeneratedValue
	public int getComment_task_id() {
		return comment_task_id;
	}
	public void setComment_task_id(int comment_task_id) {
		this.comment_task_id = comment_task_id;
	}
	
	@Column(name="comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne
	@JoinColumn(name="task_master_id")
	public TaskMasterBean getTaskMasterBean() {
		return taskMasterBean;
	}
	public void setTaskMasterBean(TaskMasterBean taskMasterBean) {
		this.taskMasterBean = taskMasterBean;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
