package com.hrms.tds.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tds_totale_tbl")
public class TDSTotalEBean implements Serializable{
	
	private int tds_totale_id;
	private double a_NPS;
	private double d_NPS;
	private double a_RGESS;
	private double d_RGESS;
	private double total_NPS_RGESS;
	private double total_e;
	private double payable_total_e;
	
	private TDSBean tdsBean;

	public TDSTotalEBean() {
		// TODO Auto-generated constructor stub
	}
	
	public TDSTotalEBean(double a_NPS, double d_NPS, double a_RGESS, double d_RGESS, double total_NPS_RGESS,
			double total_e, double payable_total_e, TDSBean tdsBean) {
		super();
		this.a_NPS = a_NPS;
		this.d_NPS = d_NPS;
		this.a_RGESS = a_RGESS;
		this.d_RGESS = d_RGESS;
		this.total_NPS_RGESS = total_NPS_RGESS;
		this.total_e = total_e;
		this.payable_total_e = payable_total_e;
		this.tdsBean = tdsBean;
	}
	
	public TDSTotalEBean(int tds_totale_id, double a_NPS, double d_NPS, double a_RGESS, double d_RGESS,
			double total_NPS_RGESS, double total_e, double payable_total_e, TDSBean tdsBean) {
		super();
		this.tds_totale_id = tds_totale_id;
		this.a_NPS = a_NPS;
		this.d_NPS = d_NPS;
		this.a_RGESS = a_RGESS;
		this.d_RGESS = d_RGESS;
		this.total_NPS_RGESS = total_NPS_RGESS;
		this.total_e = total_e;
		this.payable_total_e = payable_total_e;
		this.tdsBean = tdsBean;
	}

	@Id
	@Column(name="tds_totale_id")
	@GeneratedValue
	public int getTds_totale_id() {
		return tds_totale_id;
	}

	public void setTds_totale_id(int tds_totale_id) {
		this.tds_totale_id = tds_totale_id;
	}

	public double getA_NPS() {
		return a_NPS;
	}

	public void setA_NPS(double a_NPS) {
		this.a_NPS = a_NPS;
	}

	public double getD_NPS() {
		return d_NPS;
	}

	public void setD_NPS(double d_NPS) {
		this.d_NPS = d_NPS;
	}

	public double getA_RGESS() {
		return a_RGESS;
	}

	public void setA_RGESS(double a_RGESS) {
		this.a_RGESS = a_RGESS;
	}

	public double getD_RGESS() {
		return d_RGESS;
	}

	public void setD_RGESS(double d_RGESS) {
		this.d_RGESS = d_RGESS;
	}

	public double getTotal_NPS_RGESS() {
		return total_NPS_RGESS;
	}

	public void setTotal_NPS_RGESS(double total_NPS_RGESS) {
		this.total_NPS_RGESS = total_NPS_RGESS;
	}

	public double getTotal_e() {
		return total_e;
	}

	public void setTotal_e(double total_e) {
		this.total_e = total_e;
	}
	
	public double getPayable_total_e() {
		return payable_total_e;
	}

	public void setPayable_total_e(double payable_total_e) {
		this.payable_total_e = payable_total_e;
	}

	@ManyToOne
	@JoinColumn(name="tds_id")
	public TDSBean getTdsBean() {
		return tdsBean;
	}

	public void setTdsBean(TDSBean tdsBean) {
		this.tdsBean = tdsBean;
	}
	
	
}
