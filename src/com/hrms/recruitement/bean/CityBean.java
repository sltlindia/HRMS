package com.hrms.recruitement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city_tbl")
public class CityBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int city_id;
	private String city_name;
	
	private StateBean stateBean;
	public CityBean(){}
	
	@Id
	@GeneratedValue
	@Column(name="city_id")
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
	
	@ManyToOne
	@JoinColumn(name="state_id")
	public StateBean getStateBean() {
		return stateBean;
	}
	public void setStateBean(StateBean stateBean) {
		this.stateBean = stateBean;
	}
	
	
	

}
