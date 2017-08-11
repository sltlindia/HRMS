package com.hrms.lms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="leave_after_add_tbl")
public class LeaveAfterAddBean implements Serializable {

	
	private int leave_after_add_id;
	private LeaveBean leaveBean;
	private double CO;
	private double PL;
	private double SL;
	private double LWP;
	
	
	public LeaveAfterAddBean() {
		// TODO Auto-generated constructor stub
	}
	
	public LeaveAfterAddBean(double CO,double PL,double SL,double LWP,LeaveBean leaveBean) {

	this.CO = CO;
	this.PL = PL;
	this.SL = SL;
	this.LWP = LWP;
	this.leaveBean = leaveBean;
	}

	 @Id 
	 @Column(name="leave_after_add_id")
	 @GeneratedValue
	public int getLeave_after_add_id() {
		return leave_after_add_id;
	}

	public void setLeave_after_add_id(int leave_after_add_id) {
		this.leave_after_add_id = leave_after_add_id;
	}

	@ManyToOne
	@JoinColumn(name="leave_id")
	public LeaveBean getLeaveBean() {
		return leaveBean;
	}

	public void setLeaveBean(LeaveBean leaveBean) {
		this.leaveBean = leaveBean;
	}

	public double getCO() {
		return CO;
	}

	public void setCO(double cO) {
		CO = cO;
	}

	public double getPL() {
		return PL;
	}

	public void setPL(double pL) {
		PL = pL;
	}

	public double getSL() {
		return SL;
	}

	public void setSL(double sL) {
		SL = sL;
	}

	public double getLWP() {
		return LWP;
	}

	public void setLWP(double lWP) {
		LWP = lWP;
	}
	
	
	
}
