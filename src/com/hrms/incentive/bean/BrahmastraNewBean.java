package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brahmastra_new_tbl")
public class BrahmastraNewBean implements Serializable{

	private int brahmastra_new_id;
	private double discount_to;
	private double discount_from;
	private double rsm;
	private double am;
	private double zsm;
	
	public BrahmastraNewBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public BrahmastraNewBean(int brahmastra_new_id, double discount_to, double discount_from, double rsm, double am,
			double zsm) {
		super();
		this.brahmastra_new_id = brahmastra_new_id;
		this.discount_to = discount_to;
		this.discount_from = discount_from;
		this.rsm = rsm;
		this.am = am;
		this.zsm = zsm;
	}




	@Id 
    @Column(name="brahmastra_new_id")
    @GeneratedValue
	public int getBrahmastra_new_id() {
		return brahmastra_new_id;
	}
	public void setBrahmastra_new_id(int brahmastra_new_id) {
		this.brahmastra_new_id = brahmastra_new_id;
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


	public double getRsm() {
		return rsm;
	}


	public void setRsm(double rsm) {
		this.rsm = rsm;
	}


	
	
	/**
	 * @return the am
	 */
	public double getAm() {
		return am;
	}




	/**
	 * @param am the am to set
	 */
	public void setAm(double am) {
		this.am = am;
	}




	public double getZsm() {
		return zsm;
	}
	public void setZsm(double zsm) {
		this.zsm = zsm;
	}
	
	
	
	
}
