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
@Table(name="brahmastra_repeat_history_tbl")
public class BrahmastraRepeatHistoryBean implements Serializable{

	
	private int brahmastra_repeat_history_id;
	private double discount_to;
	private double discount_from;
	private double se_sse;
	private double asm;
	private double zsm;
	private double service;
	private String date;
	
	private BrahmastraRepeatBean brahmastraRepeatBean;

	public BrahmastraRepeatHistoryBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BrahmastraRepeatHistoryBean(double discount_to, double discount_from, double se_sse, double asm, double zsm,
			double service, String date, BrahmastraRepeatBean brahmastraRepeatBean) {
		super();
		this.discount_to = discount_to;
		this.discount_from = discount_from;
		this.se_sse = se_sse;
		this.asm = asm;
		this.zsm = zsm;
		this.service = service;
		this.date = date;
		this.brahmastraRepeatBean = brahmastraRepeatBean;
	}

	/**
	 * @return the brahmastra_repeat_history_id
	 */
	@Id 
    @Column(name="brahmastra_repeat_history_id")
    @GeneratedValue
	public int getBrahmastra_repeat_history_id() {
		return brahmastra_repeat_history_id;
	}

	/**
	 * @param brahmastra_repeat_history_id the brahmastra_repeat_history_id to set
	 */
	public void setBrahmastra_repeat_history_id(int brahmastra_repeat_history_id) {
		this.brahmastra_repeat_history_id = brahmastra_repeat_history_id;
	}

	/**
	 * @return the discount_to
	 */
	public double getDiscount_to() {
		return discount_to;
	}

	/**
	 * @param discount_to the discount_to to set
	 */
	public void setDiscount_to(double discount_to) {
		this.discount_to = discount_to;
	}

	/**
	 * @return the discount_from
	 */
	public double getDiscount_from() {
		return discount_from;
	}

	/**
	 * @param discount_from the discount_from to set
	 */
	public void setDiscount_from(double discount_from) {
		this.discount_from = discount_from;
	}

	/**
	 * @return the se_sse
	 */
	public double getSe_sse() {
		return se_sse;
	}

	/**
	 * @param se_sse the se_sse to set
	 */
	public void setSe_sse(double se_sse) {
		this.se_sse = se_sse;
	}

	/**
	 * @return the asm
	 */
	public double getAsm() {
		return asm;
	}

	/**
	 * @param asm the asm to set
	 */
	public void setAsm(double asm) {
		this.asm = asm;
	}

	/**
	 * @return the zsm
	 */
	public double getZsm() {
		return zsm;
	}

	/**
	 * @param zsm the zsm to set
	 */
	public void setZsm(double zsm) {
		this.zsm = zsm;
	}

	/**
	 * @return the service
	 */
	public double getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(double service) {
		this.service = service;
	}

	/**
	 * @return the date
	 */
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
	 * @return the brahmastraRepeatBean
	 */
	@ManyToOne
	@JoinColumn(name="brahmastra_repeat_id")
	public BrahmastraRepeatBean getBrahmastraRepeatBean() {
		return brahmastraRepeatBean;
	}

	/**
	 * @param brahmastraRepeatBean the brahmastraRepeatBean to set
	 */
	public void setBrahmastraRepeatBean(BrahmastraRepeatBean brahmastraRepeatBean) {
		this.brahmastraRepeatBean = brahmastraRepeatBean;
	}

	
	
	
	
	
	
	
	
}
