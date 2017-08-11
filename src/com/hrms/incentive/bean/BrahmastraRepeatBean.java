package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brahmastra_repeat_tbl")
public class BrahmastraRepeatBean implements Serializable{
	
	private int brahmastra_repeat_id;
	private double discount_to;
	private double discount_from;
	private double se_sse;
	private double asm;
	private double zsm;
	private double service;
	
	public BrahmastraRepeatBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public BrahmastraRepeatBean(int brahmastra_repeat_id, double discount_to, double discount_from, double se_sse,
			double asm, double zsm, double service) {
		super();
		this.brahmastra_repeat_id = brahmastra_repeat_id;
		this.discount_to = discount_to;
		this.discount_from = discount_from;
		this.se_sse = se_sse;
		this.asm = asm;
		this.zsm = zsm;
		this.service = service;
	}





	@Id 
    @Column(name="brahmastra_repeat_id")
    @GeneratedValue
	public int getBrahmastra_repeat_id() {
		return brahmastra_repeat_id;
	}
	public void setBrahmastra_repeat_id(int brahmastra_repeat_id) {
		this.brahmastra_repeat_id = brahmastra_repeat_id;
	}
	public double getDiscount_to() {
		return discount_to;
	}
	public void setDiscount_to(double discount_to) {
		this.discount_to = discount_to;
	}
	
	public double getDiscount_from() {
		return discount_from;
	}


	public void setDiscount_from(double discount_from) {
		this.discount_from = discount_from;
	}


	public double getSe_sse() {
		return se_sse;
	}
	public void setSe_sse(double se_sse) {
		this.se_sse = se_sse;
	}
	public double getAsm() {
		return asm;
	}
	public void setAsm(double asm) {
		this.asm = asm;
	}
	public double getZsm() {
		return zsm;
	}
	public void setZsm(double zsm) {
		this.zsm = zsm;
	}
	public double getService() {
		return service;
	}
	public void setService(double service) {
		this.service = service;
	}
	

}
