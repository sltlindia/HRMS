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
@Table(name="brahmastra_new_history_tbl")
public class BrahmastraNewHistoryBean implements Serializable{

	private int brahmastra_new_history_id;
	private double discount_to;
	private double discount_from;
	private double rsm;
	private double am;
	private double zsm;
	private String date;
	
	private BrahmastraNewBean brahmastraNewBean;
	
	
	
	
	
	
	public BrahmastraNewHistoryBean(double discount_to, double discount_from, double rsm, double am, double zsm,
			String date, BrahmastraNewBean brahmastraNewBean) {
		super();
		this.discount_to = discount_to;
		this.discount_from = discount_from;
		this.rsm = rsm;
		this.am = am;
		this.zsm = zsm;
		this.date = date;
		this.brahmastraNewBean = brahmastraNewBean;
	}


	public BrahmastraNewHistoryBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Id 
    @Column(name="brahmastra_new_history_id")
    @GeneratedValue
	public int getBrahmastra_new_history_id() {
		return brahmastra_new_history_id;
	}

	public void setBrahmastra_new_history_id(int brahmastra_new_history_id) {
		this.brahmastra_new_history_id = brahmastra_new_history_id;
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

	
	@Column(name="rsm")
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


	
	
	/**
	 * @return the brahmastraNewBean
	 */
	@ManyToOne
	@JoinColumn(name="brahmastra_new_id")
	public BrahmastraNewBean getBrahmastraNewBean() {
		return brahmastraNewBean;
	}
	


	/**
	 * @param brahmastraNewBean the brahmastraNewBean to set
	 */
	public void setBrahmastraNewBean(BrahmastraNewBean brahmastraNewBean) {
		this.brahmastraNewBean = brahmastraNewBean;
	}


	
	
	
	
	
	
}
