package com.hrms.kaizen.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;

@Entity
@Table(name="kaizen_manager_tbl")
public class KaizenManagerBean implements Serializable{

	private int kaizen_manager_id;
	private String status;
	private String rejection_reason;
	
	private EmployeeBean employeeBean;
	private KaizenBean kaizenBean;
	
	
	public KaizenManagerBean() {
		// TODO Auto-generated constructor stub
	}

	

	public KaizenManagerBean(String status, EmployeeBean employeeBean, KaizenBean kaizenBean) {
		super();
		this.status = status;
		this.employeeBean = employeeBean;
		this.kaizenBean = kaizenBean;
	}




	@Id 
    @Column(name="kaizen_manager_id")
    @GeneratedValue
	public int getKaizen_manager_id() {
		return kaizen_manager_id;
	}


	public void setKaizen_manager_id(int kaizen_manager_id) {
		this.kaizen_manager_id = kaizen_manager_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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



	public String getRejection_reason() {
		return rejection_reason;
	}



	public void setRejection_reason(String rejection_reason) {
		this.rejection_reason = rejection_reason;
	}



	
	
	
	
	
	
}
