package com.hrms.lms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrms.pms.bean.EmployeeBean;

@Entity
@Table(name="gate_pass_authority_tbl")
public class GatePassAuthorityBean implements Serializable{

	private int gate_pass_authority_id;
	private GateLoationBean gateLoationBean;
	private EmployeeBean employeeBean;
	
	
	@Id 
    @Column(name="gate_pass_authority_id")
    @GeneratedValue
	public int getGate_pass_authority_id() {
		return gate_pass_authority_id;
	}
	public void setGate_pass_authority_id(int gate_pass_authority_id) {
		this.gate_pass_authority_id = gate_pass_authority_id;
	}
	
	@ManyToOne
	@JoinColumn(name="gate_location_id")
	public GateLoationBean getGateLoationBean() {
		return gateLoationBean;
	}
	public void setGateLoationBean(GateLoationBean gateLoationBean) {
		this.gateLoationBean = gateLoationBean;
	}
	
	@ManyToOne
	@JoinColumn(name="employee_master_id")
	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}
	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	
}
