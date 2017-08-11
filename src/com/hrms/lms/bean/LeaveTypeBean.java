package com.hrms.lms.bean;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="leave_type_tbl")
public class LeaveTypeBean implements Serializable
{
	private int leave_type_id;
	private String leave_name;
	
	
	public LeaveTypeBean()
	{
		
	}
	
	@Id 
    @Column(name="leave_type_id")
    @GeneratedValue
	public int getLeave_type_id() {
		return leave_type_id;
	}


	public void setLeave_type_id(int leave_type_id) {
		this.leave_type_id = leave_type_id;
	}


	public String getLeave_name() {
		return leave_name;
	}


	public void setLeave_name(String leave_name) {
		this.leave_name = leave_name;
	}
	
	
	

}
