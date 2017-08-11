package com.hrms.pms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task_remark_tbl")
public class TaskRemarkBean {
	
	private int task_remark_id;
	private String remarks;
	
	private TaskMasterBean taskMasterBean;
	
	public TaskRemarkBean() {
		
	}
	
	
	public TaskRemarkBean(String remarks , TaskMasterBean taskMasterBean) {
		this.remarks = remarks;
		this.taskMasterBean = taskMasterBean;
	}





	@Id
	@Column(name="task_remark_id")
    @GeneratedValue
	public int getTask_remark_id() {
		return task_remark_id;
	}

	public void setTask_remark_id(int task_remark_id) {
		this.task_remark_id = task_remark_id;
	}

	
	@Column(name="remarks")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
