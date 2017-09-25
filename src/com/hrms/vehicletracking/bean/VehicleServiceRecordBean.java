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
@Table(name="vehicle_service_record_tbl")
public class VehicleServiceRecordBean implements Serializable{
	
	private int vehicle_service_record_id;
	private String record_date;
	private String items_change;
	private double amount;
	
	private String free_service;
	
	private DriverBean driverBean;
	private VehicleBean vehicleBean;
			

	public VehicleServiceRecordBean(int vehicle_service_record_id, String record_date, String items_change,
			double amount, String free_service, DriverBean driverBean,VehicleBean vehicleBean) {
		super();
		this.vehicle_service_record_id = vehicle_service_record_id;
		this.record_date = record_date;
		this.items_change = items_change;
		this.amount = amount;
		this.free_service = free_service;
		this.driverBean = driverBean;
		this.vehicleBean = vehicleBean;
	}
	

	public VehicleServiceRecordBean(String record_date, String items_change,
			double amount, String free_service, DriverBean driverBean,VehicleBean vehicleBean) {
		super();
		this.record_date = record_date;
		this.items_change = items_change;
		this.amount = amount;
		this.free_service = free_service;
		this.driverBean = driverBean;
		this.vehicleBean = vehicleBean;
	}

	
	public VehicleServiceRecordBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue
	@Column(name="vehicle_service_record_id")
	public int getVehicle_service_record_id() {
		return vehicle_service_record_id;
	}

	public void setVehicle_service_record_id(int vehicle_service_record_id) {
		this.vehicle_service_record_id = vehicle_service_record_id;
	}

	@Column(name="record_date")
	public String getRecord_date() {
		return record_date;
	}

	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
	
	@Column(name="items_change")
	public String getItems_change() {
		return items_change;
	}

	public void setItems_change(String items_change) {
		this.items_change = items_change;
	}

	@Column(name="amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	@Column(name="free_service")
	public String getFree_service() {
		return free_service;
	}

	public void setFree_service(String free_service) {
		this.free_service = free_service;
	}
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	public DriverBean getDriverBean() {
		return driverBean;
	}

	public void setDriverBean(DriverBean driverBean) {
		this.driverBean = driverBean;
	}

	@ManyToOne
	@JoinColumn(name="vehicle_id")
	public VehicleBean getVehicleBean() {
		return vehicleBean;
	}

	public void setVehicleBean(VehicleBean vehicleBean) {
		this.vehicleBean = vehicleBean;
	}

	
	
	
}
