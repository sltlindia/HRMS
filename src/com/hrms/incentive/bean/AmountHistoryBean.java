package com.hrms.incentive.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="amount_history_tbl")
public class AmountHistoryBean implements Serializable {
	
	private int amount_history_id;
	private double amount;
	private Date date;
	
	
	private IncentiveBean incentiveBean;
	
	
	public AmountHistoryBean() {
		// TODO Auto-generated constructor stub
	}


	public AmountHistoryBean(double amount, Date date, IncentiveBean incentiveBean) {
		super();
		this.amount = amount;
		this.date = date;
		this.incentiveBean = incentiveBean;
	}


	/**
	 * @return the amount_history_id
	 */
	
	@Id 
    @Column(name="amount_history_id")
    @GeneratedValue
	public int getAmount_history_id() {
		return amount_history_id;
	}


	/**
	 * @param amount_history_id the amount_history_id to set
	 */
	public void setAmount_history_id(int amount_history_id) {
		this.amount_history_id = amount_history_id;
	}


	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	/**
	 * @return the incentiveBean
	 */
	@ManyToOne
	@JoinColumn(name="incentive_id")	
	public IncentiveBean getIncentiveBean() {
		return incentiveBean;
	}


	/**
	 * @param incentiveBean the incentiveBean to set
	 */
	public void setIncentiveBean(IncentiveBean incentiveBean) {
		this.incentiveBean = incentiveBean;
	}


	
	
	
	

}
