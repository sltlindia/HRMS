package com.hrms.pms.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="master_degree_tbl")
public class MasterDegreeBean implements Serializable{

	
	private int master_degree_id;
	private String master_degree;
	
	public MasterDegreeBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@Column(name="master_degree_id")
    @GeneratedValue
	public int getMaster_degree_id() {
		return master_degree_id;
	}

	public void setMaster_degree_id(int master_degree_id) {
		this.master_degree_id = master_degree_id;
	}

	
	@Column(name="master_degree")
	public String getMaster_degree() {
		return master_degree;
	}

	public void setMaster_degree(String master_degree) {
		this.master_degree = master_degree;
	}

	
	
	
	
	
	
}
