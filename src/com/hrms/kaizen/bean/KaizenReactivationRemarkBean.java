package com.hrms.kaizen.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;


@Entity
@Table(name="kaizen_reactivation_remark_tbl")
public class KaizenReactivationRemarkBean implements Serializable{

	private String kaizen_reactivation_remark_id;
	private String remarks;
	
	private KaizenBean kaizenBean;

	
	
	public KaizenReactivationRemarkBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @param remarks
	 * @param kaizenBean
	 */
	public KaizenReactivationRemarkBean(String remarks, KaizenBean kaizenBean) {
		super();
		this.remarks = remarks;
		this.kaizenBean = kaizenBean;
	}

	
	
	@Id 
    @Column(name="kaizen_reactivation_remark_id")
    @GeneratedValue
	public String getKaizen_reactivation_remark_id() {
		return kaizen_reactivation_remark_id;
	}

	public void setKaizen_reactivation_remark_id(String kaizen_reactivation_remark_id) {
		this.kaizen_reactivation_remark_id = kaizen_reactivation_remark_id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
