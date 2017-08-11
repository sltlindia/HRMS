package com.hrms.incentive.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="akshar_new_history_tbl")
public class AksharNewHistoryBean implements Serializable{

	private int akshar_new_history_id;
	private double discount_to;
	private double discount_from;
	private double se_sse;
	private double asm;
	private double zsm;
	private String date;

	private AksharNewBean aksharNewBean;

	
	
	public AksharNewHistoryBean(double discount_to, double discount_from, double se_sse, double asm, double zsm,
			String date, AksharNewBean aksharNewBean) {
		super();
		this.discount_to = discount_to;
		this.discount_from = discount_from;
		this.se_sse = se_sse;
		this.asm = asm;
		this.zsm = zsm;
		this.date = date;
		this.aksharNewBean = aksharNewBean;
	}

	public AksharNewHistoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Id 
    @Column(name="akshar_new_history_id")
    @GeneratedValue
	public int getAkshar_new_history_id() {
		return akshar_new_history_id;
	}

	public void setAkshar_new_history_id(int akshar_new_history_id) {
		this.akshar_new_history_id = akshar_new_history_id;
	}

	
	@Column(name="discount_to")
	public double getDiscount_to() {
		return discount_to;
	}

	public void setDiscount_to(double discount_to) {
		this.discount_to = discount_to;
	}

	
	@Column(name="discount_from")
	public double getDiscount_from() {
		return discount_from;
	}

	public void setDiscount_from(double discount_from) {
		this.discount_from = discount_from;
	}

	@Column(name="se_sse")
	public double getSe_sse() {
		return se_sse;
	}

	public void setSe_sse(double se_sse) {
		this.se_sse = se_sse;
	}

	
	@Column(name="asm")
	public double getAsm() {
		return asm;
	}

	public void setAsm(double asm) {
		this.asm = asm;
	}

	
	@Column(name="zsm")
	public double getZsm() {
		return zsm;
	}

	public void setZsm(double zsm) {
		this.zsm = zsm;
	}

	
	
	/**
	 * @return the date
	 */
	@Column(name="date")
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name="akshar_new_id")
	public AksharNewBean getAksharNewBean() {
		return aksharNewBean;
	}

	public void setAksharNewBean(AksharNewBean aksharNewBean) {
		this.aksharNewBean = aksharNewBean;
	}
	
	
	
	
	
	
}
