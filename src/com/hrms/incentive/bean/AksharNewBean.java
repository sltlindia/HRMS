package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="akshar_new_tbl")
public class AksharNewBean implements Serializable{

	private int akshar_new_id;
	private double discount_to;
	private double discount_from;
	private double se_sse;
	private double asm;
	private double zsm;
	
	
	public AksharNewBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public AksharNewBean(int akshar_new_id, double discount_to, double discount_from, double se_sse, double asm,
			double zsm) {
		super();
		this.akshar_new_id = akshar_new_id;
		this.discount_to = discount_to;
		this.discount_from = discount_from;
		this.se_sse = se_sse;
		this.asm = asm;
		this.zsm = zsm;
	}




	@Id 
    @Column(name="akshar_new_id")
    @GeneratedValue
	public int getAkshar_new_id() {
		return akshar_new_id;
	}
	public void setAkshar_new_id(int akshar_new_id) {
		this.akshar_new_id = akshar_new_id;
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
	
	
	
	
}
