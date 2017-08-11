package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currency_tbl")
public class CurrencyBean implements Serializable{

	private int currency_id;
	private String currency_type;
	
	
	@Id 
	@Column(name="currency_id")
	@GeneratedValue
	public int getCurrency_id() {
		return currency_id;
	}
	public void setCurrency_id(int currency_id) {
		this.currency_id = currency_id;
	}
	
	@Column(name="currency_type")
	public String getCurrency_type() {
		return currency_type;
	}
	public void setCurrency_type(String currency_type) {
		this.currency_type = currency_type;
	}
	
	
	
	
	
}
