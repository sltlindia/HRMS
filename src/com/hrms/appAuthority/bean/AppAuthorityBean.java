package com.hrms.appAuthority.bean;

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
@Table(name="app_authority_tbl")
public class AppAuthorityBean implements Serializable{
	
		private int app_authority_id;
		private int gate_inword_auth;
		
		private EmployeeBean employeeBean;

		
		public AppAuthorityBean() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		
		public AppAuthorityBean(int gate_inword_auth, EmployeeBean employeeBean) {
			super();
			this.gate_inword_auth = gate_inword_auth;
			this.employeeBean = employeeBean;
		}






		@Id 
		@Column(name="app_authority_id")
		@GeneratedValue
		public int getApp_authority_id() {
			return app_authority_id;
		}

		public void setApp_authority_id(int app_authority_id) {
			this.app_authority_id = app_authority_id;
		}

		
		public int getGate_inword_auth() {
			return gate_inword_auth;
		}

		public void setGate_inword_auth(int gate_inword_auth) {
			this.gate_inword_auth = gate_inword_auth;
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
