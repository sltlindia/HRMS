package com.hrms.vehicletracking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_document_attachment_tbl")
public class VehicleDocumentAttachmentBean {

		
		private int vehicle_document_attachment_id;
		private String vehicle_attachment_name;
		private VehicleDocumentBean vehicleDocumentBean;
		
		
		public VehicleDocumentAttachmentBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public VehicleDocumentAttachmentBean(String vehicle_attachment_name, VehicleDocumentBean vehicleDocumentBean) {
			super();
			this.vehicle_attachment_name = vehicle_attachment_name;
			this.vehicleDocumentBean = vehicleDocumentBean;
		}


		public VehicleDocumentAttachmentBean(int vehicle_document_attachment_id, String vehicle_attachment_name,
				VehicleDocumentBean vehicleDocumentBean) {
			super();
			this.vehicle_document_attachment_id = vehicle_document_attachment_id;
			this.vehicle_attachment_name = vehicle_attachment_name;
			this.vehicleDocumentBean = vehicleDocumentBean;
		}

		@Id
		@GeneratedValue
		@Column(name="vehicle_document_attachment_id")
		public int getVehicle_document_attachment_id() {
			return vehicle_document_attachment_id;
		}
		public void setVehicle_document_attachment_id(int vehicle_document_attachment_id) {
			this.vehicle_document_attachment_id = vehicle_document_attachment_id;
		}
		
		@Column(name="vehicle_attachment_name")
		public String getVehicle_attachment_name() {
			return vehicle_attachment_name;
		}
		public void setVehicle_attachment_name(String vehicle_attachment_name) {
			this.vehicle_attachment_name = vehicle_attachment_name;
		}
		
		@ManyToOne
		@JoinColumn(name="vehicle_document_id")
		public VehicleDocumentBean getVehicleDocumentBean() {
			return vehicleDocumentBean;
		}
		public void setVehicleDocumentBean(VehicleDocumentBean vehicleDocumentBean) {
			this.vehicleDocumentBean = vehicleDocumentBean;
		}

		
		
}
