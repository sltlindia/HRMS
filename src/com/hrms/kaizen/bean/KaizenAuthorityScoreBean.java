package com.hrms.kaizen.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kaizen_authority_score_tbl")
public class KaizenAuthorityScoreBean implements Serializable{

	private int kaizen_authority_score_id;
	private int quality;
	private int cost;
	private int safety;
	private int productivity;
	private int delivery;
	private int horizontal_deployment;
	private int employee_master_id;
	private double total;
	private int year;
	private int month;
	
	private KaizenBean kaizenBean;
	
	
	
	public KaizenAuthorityScoreBean() {
		// TODO Auto-generated constructor stub
	}
	
	public KaizenAuthorityScoreBean(int quality, int cost, int safety, int productivity, int delivery,
			int horizontal_deployment, int employee_master_id, KaizenBean kaizenBean,int year,int month,
			double total) {
		super();
		this.quality = quality;
		this.cost = cost;
		this.safety = safety;
		this.productivity = productivity;
		this.delivery = delivery;
		this.horizontal_deployment = horizontal_deployment;
		this.employee_master_id = employee_master_id;
		this.kaizenBean = kaizenBean;
		this.year = year;
		this.month = month;
		this.total = total;
	}
	
	
	
	
	
	
	public KaizenAuthorityScoreBean(int kaizen_authority_score_id, int quality, int cost, int safety, int productivity,
			int delivery, int horizontal_deployment, int employee_master_id, KaizenBean kaizenBean,
			int year,int month,double total) {
		super();
		this.kaizen_authority_score_id = kaizen_authority_score_id;
		this.quality = quality;
		this.cost = cost;
		this.safety = safety;
		this.productivity = productivity;
		this.delivery = delivery;
		this.horizontal_deployment = horizontal_deployment;
		this.employee_master_id = employee_master_id;
		this.kaizenBean = kaizenBean;
		this.year = year;
		this.month = month;
		this.total = total;
	}






	@Id 
    @Column(name="kaizen_authority_score_id")
    @GeneratedValue
    public int getKaizen_authority_score_id() {
		return kaizen_authority_score_id;
	}

	public void setKaizen_authority_score_id(int kaizen_authority_score_id) {
		this.kaizen_authority_score_id = kaizen_authority_score_id;
	}
	
	
	
	
	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSafety() {
		return safety;
	}
	public void setSafety(int safety) {
		this.safety = safety;
	}
	public int getProductivity() {
		return productivity;
	}
	public void setProductivity(int productivity) {
		this.productivity = productivity;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getHorizontal_deployment() {
		return horizontal_deployment;
	}
	public void setHorizontal_deployment(int horizontal_deployment) {
		this.horizontal_deployment = horizontal_deployment;
	}
	
	
	
	
	public int getEmployee_master_id() {
		return employee_master_id;
	}
	public void setEmployee_master_id(int employee_master_id) {
		this.employee_master_id = employee_master_id;
	}
	
	
	
	
	
	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@ManyToOne
	@JoinColumn(name="kaizen_id")
	public KaizenBean getKaizenBean() {
		return kaizenBean;
	}
	public void setKaizenBean(KaizenBean kaizenBean) {
		this.kaizenBean = kaizenBean;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
	
	
	
	
	
	
	
}
