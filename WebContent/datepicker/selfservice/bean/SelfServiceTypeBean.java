package com.hrms.selfservice.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServlet;

@Entity
@Table(name="selfservice_type_tbl")
public class SelfServiceTypeBean {

	
		private int selfservice_type_id;
		private String selfservice_type;
		
		public SelfServiceTypeBean() {

		}
		public SelfServiceTypeBean(String selfservice_type) {
			super();
			this.selfservice_type = selfservice_type;
		}



		@Id 
	    @Column(name="selfservice_type_id")
	    @GeneratedValue
		public int getSelfservice_type_id() {
			return selfservice_type_id;
		}

		public void setSelfservice_type_id(int selfservice_type_id) {
			this.selfservice_type_id = selfservice_type_id;
		}
		@Column(name="selfservice_type")
		public String getSelfservice_type() {
			return selfservice_type;
		}

		public void setSelfservice_type(String selfservice_type) {
			this.selfservice_type = selfservice_type;
		}
		
	}
		
