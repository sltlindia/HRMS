package com.hrms.selfservice.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="software_complaint_tbl")
public class SoftwareComplaintBean implements Serializable {
	
	

		private int software_complaint_id;
		private String location;
		private int extension;
		private String description;
		private String date;
		private String correction;
		private String correction_datetime;
		private String status;
		private String remarks;
		private String date_of_resolve;
		private String attachment;
		
		
		
		private EmployeeBean employeeBean;
		private SoftwareNatureBean softwareNatureBean;
		
	
		public SoftwareComplaintBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public SoftwareComplaintBean(String location, int extension, String description, String date,String status,
				String attachment, EmployeeBean employeeBean, SoftwareNatureBean softwareNatureBean) {
			super();
			this.location = location;
			this.extension = extension;
			this.description = description;
			this.date = date;
			this.status = status;
			this.attachment = attachment;
			this.employeeBean = employeeBean;
			this.softwareNatureBean = softwareNatureBean;
		}
		
		
		public SoftwareComplaintBean(int software_complaint_id, String location, int extension, String description,
				String date, String status, String attachment, EmployeeBean employeeBean,
				SoftwareNatureBean softwareNatureBean) {
			super();
			this.software_complaint_id = software_complaint_id;
			this.location = location;
			this.extension = extension;
			this.description = description;
			this.date = date;
			this.status = status;
			this.attachment = attachment;
			this.employeeBean = employeeBean;
			this.softwareNatureBean = softwareNatureBean;
		}
		public SoftwareComplaintBean(int software_complaint_id, String location, int extension, String description,
				String date, String correction, String correction_datetime, String status,
				String remarks, String date_of_resolve, String attachment, EmployeeBean employeeBean,
				SoftwareNatureBean softwareNatureBean) {
			super();
			this.software_complaint_id = software_complaint_id;
			this.location = location;
			this.extension = extension;
			this.description = description;
			this.date = date;
			this.correction = correction;
			this.correction_datetime = correction_datetime;
			this.status = status;
			this.remarks = remarks;
			this.date_of_resolve = date_of_resolve;
			this.attachment = attachment;
			this.employeeBean = employeeBean;
			this.softwareNatureBean = softwareNatureBean;
		}
	
		@Id 
	    @Column(name="software_complaint_id")
	    @GeneratedValue
		public int getSoftware_complaint_id() {
			return software_complaint_id;
		}
		public void setSoftware_complaint_id(int software_complaint_id) {
			this.software_complaint_id = software_complaint_id;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public int getExtension() {
			return extension;
		}
		public void setExtension(int extension) {
			this.extension = extension;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getCorrection() {
			return correction;
		}
		public void setCorrection(String correction) {
			this.correction = correction;
		}
		public String getCorrection_datetime() {
			return correction_datetime;
		}
		public void setCorrection_datetime(String correction_datetime) {
			this.correction_datetime = correction_datetime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		public String getDate_of_resolve() {
			return date_of_resolve;
		}
		public void setDate_of_resolve(String date_of_resolve) {
			this.date_of_resolve = date_of_resolve;
		}
		public String getAttachment() {
			return attachment;
		}
		public void setAttachment(String attachment) {
			this.attachment = attachment;
		}

		@ManyToOne
		@JoinColumn(name="employee_master_id")
		public EmployeeBean getEmployeeBean() {
			return employeeBean;
		}
		public void setEmployeeBean(EmployeeBean employeeBean) {
			this.employeeBean = employeeBean;
		}

		@ManyToOne
		@JoinColumn(name="software_nature_id")
		public SoftwareNatureBean getSoftwareNatureBean() {
			return softwareNatureBean;
		}
		public void setSoftwareNatureBean(SoftwareNatureBean softwareNatureBean) {
			this.softwareNatureBean = softwareNatureBean;
		}
		
	}


