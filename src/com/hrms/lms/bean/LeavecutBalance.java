package com.hrms.lms.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="leavecutbalance_tbl")
public class LeavecutBalance
{
	@Id
	@GeneratedValue
	private int leavecut_ID;
	private LeaveBean leaveBean;
	private double CO;
	private double PL;
	private double SL;
	private double LWP;
	private double Main_CO;
	private double Main_PL;
	private double Main_SL;
	private double Main_LWP;
	
	
	public LeavecutBalance()
	{
		
	}

	
	public LeavecutBalance(LeaveBean leaveBean , double CO , double PL , double SL , double LWP , double Main_CO , double Main_PL , double Main_SL , double Main_LWP)
	{
		this.leaveBean = leaveBean;
		this.CO = CO;
		this.PL = PL;
		this.SL = SL;
		this.LWP = LWP;
		this.Main_CO = Main_CO;
		this.Main_PL = Main_PL;
		this.Main_SL = Main_SL;
		this.Main_LWP = Main_LWP;
	}
	
	@Id 
	 @Column(name="leavecut_ID")
	 @GeneratedValue
	public int getLeavecut_ID() {
		return leavecut_ID;
	}

	public void setLeavecut_ID(int leavecut_ID) {
		this.leavecut_ID = leavecut_ID;
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


	public double getMain_CO() {
		return Main_CO;
	}


	public void setMain_CO(double main_CO) {
		Main_CO = main_CO;
	}


	public double getMain_PL() {
		return Main_PL;
	}


	public void setMain_PL(double main_PL) {
		Main_PL = main_PL;
	}


	public double getMain_SL() {
		return Main_SL;
	}


	public void setMain_SL(double main_SL) {
		Main_SL = main_SL;
	}


	public double getMain_LWP() {
		return Main_LWP;
	}


	public void setMain_LWP(double main_LWP) {
		Main_LWP = main_LWP;
	}
	
	
	
}
