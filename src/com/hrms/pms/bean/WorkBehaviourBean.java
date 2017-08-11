package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="work_behaviors_tbl")
public class WorkBehaviourBean implements Serializable{

	private int work_behaviors_id;
	private String work_behaviors_name;
	private String work_behaviors_desc;
	
	
	public WorkBehaviourBean() {
	}
	
	@Id
	@Column(name="work_behaviors_id")
    @GeneratedValue
	public int getWork_behaviors_id() {
		return work_behaviors_id;
	}
	public void setWork_behaviors_id(int work_behaviors_id) {
		this.work_behaviors_id = work_behaviors_id;
	}
	public String getWork_behaviors_name() {
		return work_behaviors_name;
	}
	public void setWork_behaviors_name(String work_behaviors_name) {
		this.work_behaviors_name = work_behaviors_name;
	}
	public String getWork_behaviors_desc() {
		return work_behaviors_desc;
	}
	public void setWork_behaviors_desc(String work_behaviors_desc) {
		this.work_behaviors_desc = work_behaviors_desc;
	}

	
	
	
}
