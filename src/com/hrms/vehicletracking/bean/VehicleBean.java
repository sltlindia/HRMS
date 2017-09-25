package com.hrms.vehicletracking.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_master_tbl")
public class VehicleBean implements Serializable{
	
public VehicleBean() {
		
	}
	
	
	
	private int vehicle_master_id;
	private String vehicle_name;
	private String vehicle_no;
	
	private VehicleTypeBean vehicleTypeBean;
	
	
	
	public VehicleBean(String vehicle_name, String vehicle_no, VehicleTypeBean vehicleTypeBean) {
		super();
		this.vehicle_name = vehicle_name;
		this.vehicle_no = vehicle_no;
		this.vehicleTypeBean = vehicleTypeBean;
	}

	@Id
	@GeneratedValue
	@Column(name="vehicle_master_id")
	public int getVehicle_master_id() {
		return vehicle_master_id;
	}

	public void setVehicle_master_id(int vehicle_master_id) {
		this.vehicle_master_id = vehicle_master_id;
	}

	@Column(name="vehicle_name")
	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	@Column(name="vehicle_no")
	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	@ManyToOne
	@JoinColumn(name="vehicle_type_id")
	public VehicleTypeBean getVehicleTypeBean() {
		return vehicleTypeBean;
	}

	public void setVehicleTypeBean(VehicleTypeBean vehicleTypeBean) {
		this.vehicleTypeBean = vehicleTypeBean;
	}
	
	
}
