package com.hrms.kaizen.bean;

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
@Table(name="kaizen_member_tbl")
public class KaizenMemberBean implements Serializable {

	private int kaizen_member_id;
	private EmployeeBean employeeBean;
	private KaizenBean kaizenBean;
	
	
	
	
	public KaizenMemberBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public KaizenMemberBean(EmployeeBean employeeBean, KaizenBean kaizenBean) {
		super();
		this.employeeBean = employeeBean;
		this.kaizenBean = kaizenBean;
	}
	
	
	
	@Id 
    @Column(name="kaizen_member_id")
    @GeneratedValue
	public int getKaizen_member_id() {
		return kaizen_member_id;
	}
	public void setKaizen_member_id(int kaizen_member_id) {
		this.kaizen_member_id = kaizen_member_id;
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
	@JoinColumn(name="kaizen_id")
	public KaizenBean getKaizenBean() {
		return kaizenBean;
	}
	public void setKaizenBean(KaizenBean kaizenBean) {
		this.kaizenBean = kaizenBean;
	}
	
	
	
	
	
}
