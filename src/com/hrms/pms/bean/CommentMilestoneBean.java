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
@Table(name="comment_milestone_tbl")
public class CommentMilestoneBean implements Serializable{
	
	private int comment_milestone_id;
	private String comment;
	private String time;
	
	private MilestoneBean milestoneBean;
	private EmployeeBean employeeBean;
	
	
	public CommentMilestoneBean() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentMilestoneBean(String comment, String time, MilestoneBean milestoneBean, EmployeeBean employeeBean) {
		super();
		this.comment = comment;
		this.time = time;
		this.milestoneBean = milestoneBean;
		this.employeeBean = employeeBean;
	}
	
	
	
	@Id
	@Column(name="comment_milestone_id")
    @GeneratedValue
	public int getComment_milestone_id() {
		return comment_milestone_id;
	}
	public void setComment_milestone_id(int comment_milestone_id) {
		this.comment_milestone_id = comment_milestone_id;
	}
	
	@Column(name="comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@ManyToOne
	@JoinColumn(name="milestone_id")
	public MilestoneBean getMilestoneBean() {
		return milestoneBean;
	}
	public void setMilestoneBean(MilestoneBean milestoneBean) {
		this.milestoneBean = milestoneBean;
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
