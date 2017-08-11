package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit_of_measurement_tbl")
public class UnitOfMeasurementBean implements Serializable {

	private static final long serialVersionUID = 1L;	
	private int unit_of_measurement_id;
	private String unit_of_measurement_name;
	
	
	 @Id
	 @Column(name="unit_of_measurement_id")
	 @GeneratedValue
	public int getUnit_of_measurement_id() {
		return unit_of_measurement_id;
	}
	public void setUnit_of_measurement_id(int unit_of_measurement_id) {
		this.unit_of_measurement_id = unit_of_measurement_id;
	}
	@Column(name="unit_of_measurement_name")
	public String getUnit_of_measurement_name() {
		return unit_of_measurement_name;
	}
	public void setUnit_of_measurement_name(String unit_of_measurement_name) {
		this.unit_of_measurement_name = unit_of_measurement_name;
	}
	



}
