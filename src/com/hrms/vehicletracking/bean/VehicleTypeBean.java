package com.hrms.vehicletracking.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="vehicle_type_master_tbl")
public class VehicleTypeBean implements Serializable {

	public VehicleTypeBean() {
		
	}
		
		
		private int vehicle_type_id;
		private String vehicle_type_name;
		
		@Id
		@GeneratedValue
		@Column(name="vehicle_type_id")
		public int getVehicle_type_id() {
			return vehicle_type_id;
		}
		public void setVehicle_type_id(int vehicle_type_id) {
			this.vehicle_type_id = vehicle_type_id;
		}
		
		@Column(name="vehicle_type_name")
		public String getVehicle_type_name() {
			return vehicle_type_name;
		}
		public void setVehicle_type_name(String vehicle_type_name) {
			this.vehicle_type_name = vehicle_type_name;
		}
		
		
		

}
