package com.hrms.kaizen.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.YearBean;


@Entity
@Table(name="kaizen_billboard_result_tbl")
public class KaizenBillboardResultBean implements Serializable{
	
	private int kaizen_billboard_result_id;
	private int year;
	private double total_score;
	
	private KaizenManagerScoreBean kaizenManagerScoreBean;
	private MonthBean monthBean;
	
	
	
	
	public KaizenBillboardResultBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	public KaizenBillboardResultBean(KaizenManagerScoreBean kaizenManagerScoreBean, MonthBean monthBean,
			int year, double total_score) {
		super();
		this.kaizenManagerScoreBean = kaizenManagerScoreBean;
		this.monthBean = monthBean;
		this.year = year;
		this.total_score = total_score;
	}





	@Id 
    @Column(name="kaizen_billboard_result_id")
    @GeneratedValue
	public int getKaizen_billboard_result_id() {
		return kaizen_billboard_result_id;
	}

	public void setKaizen_billboard_result_id(int kaizen_billboard_result_id) {
		this.kaizen_billboard_result_id = kaizen_billboard_result_id;
	}

	
	@ManyToOne
	@JoinColumn(name="kaizen_manager_score_id")
	public KaizenManagerScoreBean getKaizenManagerScoreBean() {
		return kaizenManagerScoreBean;
	}

	public void setKaizenManagerScoreBean(KaizenManagerScoreBean kaizenManagerScoreBean) {
		this.kaizenManagerScoreBean = kaizenManagerScoreBean;
	}

	
	@ManyToOne
	@JoinColumn(name="month_id")
	public MonthBean getMonthBean() {
		return monthBean;
	}

	public void setMonthBean(MonthBean monthBean) {
		this.monthBean = monthBean;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}





	public double getTotal_score() {
		return total_score;
	}





	public void setTotal_score(double total_score) {
		this.total_score = total_score;
	}








	

	
	

	
	
}
