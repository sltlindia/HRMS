package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager_grade_master_tbl")
public class ManagerGradeMasterBean implements Serializable {

	 private int manager_grade_master_id;
		private String manager_grade_master_name;
	    private String manager_grade_master_desc;
	    
	    
	    public ManagerGradeMasterBean() {
			// TODO Auto-generated constructor stub
	    }


	    @Id
	    @Column(name="manager_grade_master_id")
	    @GeneratedValue
	    public int getManager_grade_master_id() {
			return manager_grade_master_id;
		}


		public void setManager_grade_master_id(int manager_grade_master_id) {
			this.manager_grade_master_id = manager_grade_master_id;
		}

		 @Column(name="manager_grade_master_name")
		public String getManager_grade_master_name() {
			return manager_grade_master_name;
		}


		public void setManager_grade_master_name(String manager_grade_master_name) {
			this.manager_grade_master_name = manager_grade_master_name;
		}

		 @Column(name="manager_grade_master_desc")
		public String getManager_grade_master_desc() {
			return manager_grade_master_desc;
		}


		public void setManager_grade_master_desc(String manager_grade_master_desc) {
			this.manager_grade_master_desc = manager_grade_master_desc;
		}


	    
	
}
