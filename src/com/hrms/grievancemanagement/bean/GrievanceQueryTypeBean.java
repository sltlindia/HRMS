package com.hrms.grievancemanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grievance_query_type_tbl")
public class GrievanceQueryTypeBean implements Serializable{
	
	private int grievance_query_type_id;
	private String grievance_query_type;
	
	public GrievanceQueryTypeBean() {

	}
	
	public GrievanceQueryTypeBean(String grievance_query_type) {
		this.grievance_query_type = grievance_query_type;
	}
	
	@Id 
    @Column(name="grievance_query_type_id")
    @GeneratedValue
	public int getGrievance_query_type_id() {
		return grievance_query_type_id;
	}
	public void setGrievance_query_type_id(int grievance_query_type_id) {
		this.grievance_query_type_id = grievance_query_type_id;
	}
	
	@Column(name="grievance_query_type")
	public String getGrievance_query_type() {
		return grievance_query_type;
	}
	public void setGrievance_query_type(String grievance_query_type) {
		this.grievance_query_type = grievance_query_type;
	}
	
	
	

}
