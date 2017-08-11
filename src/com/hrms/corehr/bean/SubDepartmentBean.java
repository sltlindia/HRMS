package com.hrms.corehr.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sub_department_tbl")
public class SubDepartmentBean implements Serializable{

		private int sub_department_id;
		private String sub_department_name;
		
		public SubDepartmentBean() {
			// TODO Auto-generated constructor stub
		}
		
		public SubDepartmentBean(String sub_department_name) {
			super();
			this.sub_department_name = sub_department_name;
		}


		@Id 
		@Column(name="sub_department_id")
		@GeneratedValue
		public int getSub_department_id() {
			return sub_department_id;
		}
		public void setSub_department_id(int sub_department_id) {
			this.sub_department_id = sub_department_id;
		}

		
		
		@Column(name="sub_department_name")
		public String getSub_department_name() {
			return sub_department_name;
		}

		public void setSub_department_name(String sub_department_name) {
			this.sub_department_name = sub_department_name;
		}
		
			
}

