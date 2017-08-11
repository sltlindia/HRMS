package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="task_date_history_tbl")
public class TaskDateHistoryBean implements Serializable{
	
	private int task_date_history_id;
	private String planned_old_end_date;
	private String planned_new_end_date;
	
	private TaskMasterBean taskMasterBean;
	
	public TaskDateHistoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public TaskDateHistoryBean(String planned_old_end_date, String planned_new_end_date,TaskMasterBean taskMasterBean) {
		super();
		this.planned_old_end_date = planned_old_end_date;
		this.planned_new_end_date = planned_new_end_date;
		this.taskMasterBean = taskMasterBean;
	}





	@Id
	@Column(name="task_date_history_id")
    @GeneratedValue
	public int getTask_date_history_id() {
		return task_date_history_id;
	}
	public void setTask_date_history_id(int task_date_history_id) {
		this.task_date_history_id = task_date_history_id;
	}
	public String getPlanned_old_end_date() {
		return planned_old_end_date;
	}
	public void setPlanned_old_end_date(String planned_old_end_date) {
		this.planned_old_end_date = planned_old_end_date;
	}
	public String getPlanned_new_end_date() {
		return planned_new_end_date;
	}
	public void setPlanned_new_end_date(String planned_new_end_date) {
		this.planned_new_end_date = planned_new_end_date;
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
