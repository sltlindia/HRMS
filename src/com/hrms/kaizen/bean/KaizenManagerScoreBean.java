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
@Table(name="kaizen_manager_score_tbl")
public class KaizenManagerScoreBean implements Serializable{

	private int kaizen_manager_score_id;
	private int quality;
	private int cost;
	private int safety;
	private int productivity;
	private int delivery;
	private int horizontal_deployment;
	private int employee_master_id;
	private int total;
	
	private KaizenBean kaizenBean;
	
	
	
	public KaizenManagerScoreBean() {
		// TODO Auto-generated constructor stub
	}
	
	public KaizenManagerScoreBean(int quality, int cost, int safety, int productivity, int delivery,
			int horizontal_deployment, int employee_master_id, KaizenBean kaizenBean) {
		super();
		this.quality = quality;
		this.cost = cost;
		this.safety = safety;
		this.productivity = productivity;
		this.delivery = delivery;
		this.horizontal_deployment = horizontal_deployment;
		this.employee_master_id = employee_master_id;
		this.kaizenBean = kaizenBean;
	}
	
	
	
	
	
	
	public KaizenManagerScoreBean(int kaizen_manager_score_id, int quality, int cost, int safety, int productivity,
			int delivery, int horizontal_deployment, int employee_master_id, KaizenBean kaizenBean) {
		super();
		this.kaizen_manager_score_id = kaizen_manager_score_id;
		this.quality = quality;
		this.cost = cost;
		this.safety = safety;
		this.productivity = productivity;
		this.delivery = delivery;
		this.horizontal_deployment = horizontal_deployment;
		this.employee_master_id = employee_master_id;
		this.kaizenBean = kaizenBean;
	}






	@Id 
    @Column(name="kaizen_manager_score_id")
    @GeneratedValue
	public int getKaizen_manager_score_id() {
		return kaizen_manager_score_id;
	}
	public void setKaizen_manager_score_id(int kaizen_manager_score_id) {
		this.kaizen_manager_score_id = kaizen_manager_score_id;
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
	
	
	
	
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
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
	
	
	
	
	
	
	
	
	
}
