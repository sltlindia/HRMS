package com.hrms.vehicletracking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_document_tbl")
public class VehicleDocumentBean {

	
	private int vehicle_document_id;
	private String document_name;
	private VehicleBean vehicleBean;
	
	
	public VehicleDocumentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VehicleDocumentBean(int vehicle_document_id, String document_name, VehicleBean vehicleBean) {
		super();
		this.vehicle_document_id = vehicle_document_id;
		this.document_name = document_name;
		this.vehicleBean = vehicleBean;
	}
	
	public VehicleDocumentBean(String document_name, VehicleBean vehicleBean) {
		super();
		this.document_name = document_name;
		this.vehicleBean = vehicleBean;
	}
	@Id
	@GeneratedValue
	@Column(name="vehicle_document_id")
	public int getVehicle_document_id() {
		return vehicle_document_id;
	}
	public void setVehicle_document_id(int vehicle_document_id) {
		this.vehicle_document_id = vehicle_document_id;
	}
	@Column(name="document_name")
	public String getDocument_name() {
		return document_name;
	}
	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}
	
	@ManyToOne
	@JoinColumn(name="vehicle_master_id")
	public VehicleBean getVehicleBean() {
		return vehicleBean;
	}
	public void setVehicleBean(VehicleBean vehicleBean) {
		this.vehicleBean = vehicleBean;
	}
	
	
}
