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
@Table(name="vehicle_tracking_tbl")
public class VehicleTrackingBean implements Serializable {

	
	
	public VehicleTrackingBean() {
	}
	
	private int vehicle_tracking_id;
	private double start_reading;
	private double end_reading;
	private double km;
	private double litre;
	private double amount;
	private double average;
	private String date;
	private String attachment;
	
	private VehicleBean vehicleBean;
	private DriverBean driverBean;
	
	

	public VehicleTrackingBean(double start_reading, double end_reading, double km, double litre,
			double amount, double average, String date, VehicleBean vehicleBean, DriverBean driverBean,String attachment) {
		super();
		this.start_reading = start_reading;
		this.end_reading = end_reading;
		this.km = km;
		this.litre = litre;
		this.amount = amount;
		this.average = average;
		this.date = date;
		this.vehicleBean = vehicleBean;
		this.driverBean = driverBean;
		this.attachment = attachment;
	}

	
	public VehicleTrackingBean(int vehicle_tracking_id, double start_reading, double end_reading, double km,
			double litre, double amount, double average, String date, VehicleBean vehicleBean, DriverBean driverBean,String attachment) {
		super();
		this.vehicle_tracking_id = vehicle_tracking_id;
		this.start_reading = start_reading;
		this.end_reading = end_reading;
		this.km = km;
		this.litre = litre;
		this.amount = amount;
		this.average = average;
		this.date = date;
		this.vehicleBean = vehicleBean;
		this.driverBean = driverBean;
		this.attachment = attachment;
	}


	@Id
	@GeneratedValue
	@Column(name="vehicle_tracking_id")
	public int getVehicle_tracking_id() {
		return vehicle_tracking_id;
	}

	public void setVehicle_tracking_id(int vehicle_tracking_id) {
		this.vehicle_tracking_id = vehicle_tracking_id;
	}
	

	@Column(name="start_reading")
	public double getStart_reading() {
		return start_reading;
	}

	public void setStart_reading(double start_reading) {
		this.start_reading = start_reading;
	}

	@Column(name="end_reading")
	public double getEnd_reading() {
		return end_reading;
	}

	public void setEnd_reading(double end_reading) {
		this.end_reading = end_reading;
	}

	@Column(name="km")
	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	@Column(name="litre")
	public double getLitre() {
		return litre;
	}

	public void setLitre(double litre) {
		this.litre = litre;
	}

	@Column(name="amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name="average")
	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	
	@Column(name="date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name="vehicle_master_id")
	public VehicleBean getVehicleBean() {
		return vehicleBean;
	}

	public void setVehicleBean(VehicleBean vehicleBean) {
		this.vehicleBean = vehicleBean;
	}
	
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	public DriverBean getDriverBean() {
		return driverBean;
	}

	public void setDriverBean(DriverBean driverBean) {
		this.driverBean = driverBean;
	}

	@Column(name="attachment")
	public String getAttachment() {
		return attachment;
	}


	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
}
