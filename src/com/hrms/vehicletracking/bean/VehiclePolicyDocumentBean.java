package com.hrms.vehicletracking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_policy_document_tbl")
public class VehiclePolicyDocumentBean {

	
	private int vehicle_policy_document_id;
	private String registration_no;
	private String insurance_policy_description;
	private String policy_issued_on;
	private String period_of_insurance;
	private String attachment;
	private String amount;
	private String policy_no;

	private VehicleBean vehicleBean;
	
	public VehiclePolicyDocumentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public VehiclePolicyDocumentBean(String registration_no, String insurance_policy_description,
			String policy_issued_on, String period_of_insurance, String attachment, String amount, String policy_no,
			VehicleBean vehicleBean) {
		super();
		this.registration_no = registration_no;
		this.insurance_policy_description = insurance_policy_description;
		this.policy_issued_on = policy_issued_on;
		this.period_of_insurance = period_of_insurance;
		this.attachment = attachment;
		this.amount = amount;
		this.policy_no = policy_no;
		this.vehicleBean = vehicleBean;
	}



	public VehiclePolicyDocumentBean(int vehicle_policy_document_id, String registration_no,
			String insurance_policy_description, String policy_issued_on, String period_of_insurance, String attachment,
			String amount, String policy_no, VehicleBean vehicleBean) {
		super();
		this.vehicle_policy_document_id = vehicle_policy_document_id;
		this.registration_no = registration_no;
		this.insurance_policy_description = insurance_policy_description;
		this.policy_issued_on = policy_issued_on;
		this.period_of_insurance = period_of_insurance;
		this.attachment = attachment;
		this.amount = amount;
		this.policy_no = policy_no;
		this.vehicleBean = vehicleBean;
	}



	@Id
	@GeneratedValue
	@Column(name="vehicle_policy_document_id")
	public int getVehicle_policy_document_id() {
		return vehicle_policy_document_id;
	}
	public void setVehicle_policy_document_id(int vehicle_policy_document_id) {
		this.vehicle_policy_document_id = vehicle_policy_document_id;
	}
	@Column(name="registration_no")
	public String getRegistration_no() {
		return registration_no;
	}
	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}
	@Column(name="insurance_policy_description")
	public String getInsurance_policy_description() {
		return insurance_policy_description;
	}
	public void setInsurance_policy_description(String insurance_policy_description) {
		this.insurance_policy_description = insurance_policy_description;
	}
	@Column(name="policy_issued_on")
	public String getPolicy_issued_on() {
		return policy_issued_on;
	}
	public void setPolicy_issued_on(String policy_issued_on) {
		this.policy_issued_on = policy_issued_on;
	}
	@Column(name="period_of_insurance")
	public String getPeriod_of_insurance() {
		return period_of_insurance;
	}
	public void setPeriod_of_insurance(String period_of_insurance) {
		this.period_of_insurance = period_of_insurance;
	}
	@Column(name="attachment")
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	@Column(name="amount")
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Column(name="policy_no")
	public String getPolicy_no() {
		return policy_no;
	}
	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
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
