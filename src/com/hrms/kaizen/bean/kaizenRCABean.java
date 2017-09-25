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
@Table(name="kaizen_rca_tbl")
public class kaizenRCABean implements Serializable{

	
	private int kaizen_rca_id;
	private String rca_ans;
	
	private KaizenBean kaizenBean;

	public kaizenRCABean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public kaizenRCABean(String rca_ans, KaizenBean kaizenBean) {
		super();
		this.rca_ans = rca_ans;
		this.kaizenBean = kaizenBean;
	}

	
	
	@Id 
    @Column(name="kaizen_rca_id")
    @GeneratedValue
	public int getKaizen_rca_id() {
		return kaizen_rca_id;
	}

	public void setKaizen_rca_id(int kaizen_rca_id) {
		this.kaizen_rca_id = kaizen_rca_id;
	}

	public String getRca_ans() {
		return rca_ans;
	}

	public void setRca_ans(String rca_ans) {
		this.rca_ans = rca_ans;
	}

	@ManyToOne
	@JoinColumn(name="kaizen_id")
	public KaizenBean getKaizenBean() {
		return kaizenBean;
	}

	public void setKaizenBean(KaizenBean kaizenBean) {
		this.kaizenBean = kaizenBean;
	}
	
	
	
	
}
